package com.agu.coffeeshop.controllers.dto;

import com.agu.coffeeshop.entities.enums.ItemType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemCreateDto {

    private ItemType ItemType;
    private String itemName;
    private Double price;
}
