package com.agu.coffeeshop.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserUpsertDto {

    private String firstName;
    private String lastName;
    private String email;
    private String dob;
    private String city;
    private String country;
    private String phoneNumber;
}
