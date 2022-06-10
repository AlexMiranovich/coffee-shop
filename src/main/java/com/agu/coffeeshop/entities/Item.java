package com.agu.coffeeshop.entities;

import com.agu.coffeeshop.entities.enums.ItemType;
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
@Document(collection = "items")
public class Item implements Identifiable {

    @Id
    private String id;
    private ItemType ItemType;
    private String name;
    private Instant createdDate;
    private Instant updatedDate;
}
