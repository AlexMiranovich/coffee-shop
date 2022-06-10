package com.agu.coffeeshop.entities;

import com.agu.coffeeshop.entities.enums.OrderStatus;
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
@Document(collection = "orders")
public class Order implements Identifiable {

    @Id
    private String id;
    private OrderStatus orderStatus;
    private String userId;
    private String itemId;
    private Instant create;
    private Instant updated;
}
