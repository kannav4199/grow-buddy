package com.growbuddy.app.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationRequest {
    @Email(message = "Invalid email")
    private String email;
    @NotBlank(message = "Invalid Password: Empty name")
    @NotNull(message = "Invalid Password : Password is NULL")
    @Size(min = 8, max = 30, message = "Invalid Password: Must be of 8 - 30 characters")
    private  String password;
}
