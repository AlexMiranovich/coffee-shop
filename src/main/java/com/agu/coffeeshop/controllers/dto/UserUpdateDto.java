package com.agu.coffeeshop.controllers.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDto extends UserCreateDto {
    @NotEmpty
    private String id;
}
