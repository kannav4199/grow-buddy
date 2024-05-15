package com.growbuddy.app;

import com.growbuddy.app.entity.Person;
import com.growbuddy.app.repoitory.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class GrowBuddyAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrowBuddyAppApplication.class, args);
    }

	@Bean
	public CommandLineRunner run(PersonRepository userRepository, PasswordEncoder passwordEncoder) throws Exception {
		return (String[] args) -> {
			Person user1 = new Person();
			user1.setState("Delhi");
			user1.setPincode("110059");
			user1.setAddress1("b1 kiran garden");
			user1.setFirstName("Kannav");
		user1.setEmail("kannav@gmail.com");
				user1.setMobile("8882775498");
                user1.setFatherName("PAPA");
                user1.setMotherName("MOM");
				user1.setRoles("USER");
				user1.setPassword(passwordEncoder.encode("Password"));


			Person user2 = Person.builder().state("Delhi").pincode("110059").roles("USER").address1("b2 kiran garden").firstName("Pranav").email("pranav@gmail.com").mobile("9992889333").fatherName("papa").motherName("ma").password(passwordEncoder.encode("Password1")).build();

			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.findAll().forEach(System.out::println);
		};
	}

}
