package com.agu.coffeeshop.entities;

import com.agu.coffeeshop.entities.enums.ItemStatus;
import com.agu.coffeeshop.entities.enums.ItemType;
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
@Document(collection = "items")
public class Item implements Identifiable, Changeable<Item> {

    @Id
    private String id;
    private String itemName;
    private ItemType ItemType;
    private ItemStatus itemStatus;
    private Double price;
    private Instant createdDate;
    private Instant updatedDate;

    @Override
    public Map<String, Function<Item, Object>> getFields() {
        Map<String, Function<Item, Object>> result = new HashMap<>();
        result.put("itemName", Item::getItemName);
        result.put("itemType", Item::getItemType);
        result.put("itemStatus", Item::getItemStatus);
        result.put("price", Item::getPrice);
        return result;
    }

    @Override
    public List<String> getHashCodeFieldNames() {
        return Collections.emptyList();
    }
}
