package com.growbuddy.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
//@Table(uniqueConstraints=@UniqueConstraint(columnNames="email"))
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String firstName;
    private String lastName;
    @NotBlank(message = "Address is mandatory")
    private String address1;
    private String address2;
    @NotNull(message = "pincode is mandatory")
    private String pincode;
    @NotBlank(message = "Mobile No is mandatory")
    private String mobile;
    private String alternateMobile;
    @NotBlank(message = "State is mandatory")
    private String state;
    @NotBlank(message = "Email is mandatory")
    private String email;
    @NotBlank
    private String password;
    private String roles;
    private String imagePath;
    private String guardianName;
    @NotBlank(message = "Father Name is mandatory")
    private String fatherName;
    @NotBlank(message = "Mother Name is mandatory")
    private String motherName;
    private String adhaarNo;

    @Column(name="created_date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date date;


}
