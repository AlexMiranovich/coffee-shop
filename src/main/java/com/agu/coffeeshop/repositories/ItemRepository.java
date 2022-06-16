package com.agu.coffeeshop.repositories;

import com.agu.coffeeshop.entities.Item;
import com.agu.coffeeshop.entities.enums.ItemType;

import java.util.List;

public interface ItemRepository {

    List<Item> findByItemType(ItemType itemType);
}
