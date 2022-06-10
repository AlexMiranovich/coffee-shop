package com.agu.coffeeshop.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String dob;
    private String city;
    private String country;
    private String phoneNumber;
    private Instant createdDate;
    private Instant updatedDate;
}
