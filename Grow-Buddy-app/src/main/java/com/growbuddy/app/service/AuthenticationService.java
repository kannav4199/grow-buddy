package com.growbuddy.app.service;

import com.growbuddy.app.config.UserInfoUserDetails;
import com.growbuddy.app.entity.Person;
import com.growbuddy.app.model.AuthenticationRequest;
import com.growbuddy.app.model.AuthenticationResponse;
import com.growbuddy.app.model.RegisterRequest;
import com.growbuddy.app.repoitory.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PersonRepository personRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = personRepository.findByEmail(request.getEmail()).orElseThrow(() -> new UsernameNotFoundException("user not found " + request.getEmail()));
        return AuthenticationResponse.builder().token(jwtService.generateToken(new UserInfoUserDetails(user))).build();
    }

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = Person.builder()
                .email(registerRequest.getEmail())
                .address1(registerRequest.getAddress1())
                .address2(registerRequest.getAddress2())
                .alternateMobile(registerRequest.getAlternateMobile())
                .mobile(registerRequest.getMobile())
                .roles(registerRequest.getRole())
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .pincode(registerRequest.getPincode())
                .state(registerRequest.getState())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .motherName(registerRequest.getMotherName())
                .fatherName(registerRequest.getFatherName())
                .guardianName(registerRequest.getGuardianName())
                .build();

        personRepository.save(user);
        return AuthenticationResponse.builder().token(jwtService.generateToken(new UserInfoUserDetails(user))).build();

    }
}
