package com.agu.coffeeshop.controllers.dto;

import com.agu.coffeeshop.entities.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserUpsertDto {

    @NotNull
    private UserType userType;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Email
    @NotNull
    private String email;
    private String dob;
    private String city;
    private String country;
    @NotNull
    private String phoneNumber;
}
