package com.growbuddy.app.model;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequest {

    @NotBlank(message = "Address1 is mandatory")
    @Size(min = 6, max = 40, message = "Invalid Address1: length must be less than 40 characters")
    private String address1;

    @Size(min = 6, max = 40, message = "Invalid Address2: length must be less than 40 characters")
    private String address2;

    @NotBlank(message = "Pincode is mandatory")
    @Pattern(regexp = "^\\d{6}$", message = "Invalid Pincode")
    @Size(min = 6, max = 6, message = "Invalid Pincode: Must be of 6 characters")
    private String pincode;

    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
    private String alternateMobile;

    @NotBlank(message = "State is mandatory")
    @Size(min = 3, max = 30, message = "Invalid State")
    private String state;

    @NotBlank(message = "Invalid First Name: Empty name")
    @Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters")
    private String firstName;

    @NotBlank(message = "Invalid Last Name: Empty name")
    @Size(min = 3, max = 30, message = "Invalid Last Name: Must be of 3 - 30 characters")
    private String lastName;

    @Email(message = "Invalid email")
    @NotBlank(message = "Invalid Email: Empty email")
    @Size(min = 10, max = 30, message = "Invalid Email: Must be of 10 - 30 characters")
    private String email;

    @NotBlank(message = "Invalid Phone number: Empty number")
    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
    private String mobile;

    @Size(min = 4, max = 10, message = "Invalid Role: Must be of 4 - 10 characters")
    private String roles;

    @NotBlank(message = "Invalid Password: Empty name")
    @Size(min = 8, max = 30, message = "Invalid Password: Must be of 8 - 30 characters")
    private String password;

    @Size(min = 8, max = 30, message = "Invalid Guardian Name: Must be of 8 - 30 characters")
    private String guardianName;
    @NotBlank(message = "Father Name is mandatory")
    @Size(min = 2, max = 30, message = "Invalid Father Name: Must be of 8 - 30 characters")
    private String fatherName;
    @NotBlank(message = "Mother Name is mandatory")
    @Size(min = 2, max = 30, message = "Invalid Mother Name: Must be of 8 - 30 characters")
    private String motherName;
    private String adhaarNo;
}
