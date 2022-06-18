package com.agu.coffeeshop.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "users")
public class User implements Identifiable, Changeable<User> {

    @Id
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
    private Double discount;

    @Override
    public Map<String, Function<User, Object>> getFields() {
        Map<String, Function<User, Object>> result = new HashMap<>();
        result.put("firstName", User::getFirstName);
        result.put("lastName", User::getLastName);
        result.put("email", User::getEmail);
        result.put("dob", User::getDob);
        result.put("city", User::getCity);
        result.put("country", User::getCountry);
        result.put("phoneNumber", User::getPhoneNumber);
        return result;
    }

    @Override
    public List<String> getHashCodeFieldNames() {
        return Collections.emptyList();
    }
}
