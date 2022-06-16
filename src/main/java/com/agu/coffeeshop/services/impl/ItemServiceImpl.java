package com.agu.coffeeshop.services.impl;

import com.agu.coffeeshop.entities.Item;
import com.agu.coffeeshop.entities.enums.ItemType;
import com.agu.coffeeshop.repositories.BaseRepository;
import com.agu.coffeeshop.repositories.ItemRepository;
import com.agu.coffeeshop.services.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final BaseRepository<Item> baseRepository;
    private final ItemRepository itemRepository;

    public ItemServiceImpl(BaseRepository<Item> baseRepository, ItemRepository itemRepository) {
        this.baseRepository = baseRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save(Item item) {
        return baseRepository.save(item);
    }

    @Override
    public List<Item> findByItemType(ItemType itemType) {
        return itemRepository.findByItemType(itemType);
    }
}
