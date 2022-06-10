package com.agu.coffeeshop.entities;

import com.agu.coffeeshop.entities.enums.UserStatus;
import com.agu.coffeeshop.entities.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "users")
public class User implements Identifiable {

    @Id
    private String id;
    private UserType userType;
    private UserStatus userStatus;
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
