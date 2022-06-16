package com.agu.coffeeshop.controllers.dto;

import com.agu.coffeeshop.entities.enums.ItemType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemResponseDto {
    private String id;
    private ItemType ItemType;
    private String name;
    private Double price;
    private Instant createdDate;
}
