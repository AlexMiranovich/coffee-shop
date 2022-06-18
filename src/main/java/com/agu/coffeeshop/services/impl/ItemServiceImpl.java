package com.agu.coffeeshop.services.impl;

import com.agu.coffeeshop.entities.Item;
import com.agu.coffeeshop.entities.enums.ItemType;
import com.agu.coffeeshop.repositories.ItemRepository;
import com.agu.coffeeshop.repositories.impl.BaseRepository;
import com.agu.coffeeshop.services.HistoryService;
import com.agu.coffeeshop.services.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl extends BaseService<Item> implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(BaseRepository<Item> baseRepository, HistoryService historyService, ItemRepository itemRepository) {
        super(baseRepository, historyService);
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> findByItemType(ItemType itemType) {
        return itemRepository.findByItemType(itemType);
    }
}
