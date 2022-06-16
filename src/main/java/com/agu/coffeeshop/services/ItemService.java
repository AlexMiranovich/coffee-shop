package com.agu.coffeeshop.services;

import com.agu.coffeeshop.entities.Item;
import com.agu.coffeeshop.entities.enums.ItemType;

import java.util.List;

public interface ItemService {
    Item save(Item item);

    List<Item> findByItemType(ItemType itemType);
}
