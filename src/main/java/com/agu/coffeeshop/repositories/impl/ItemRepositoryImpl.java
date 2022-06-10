package com.agu.coffeeshop.repositories.impl;

import com.agu.coffeeshop.entities.Item;
import com.agu.coffeeshop.entities.User;
import com.agu.coffeeshop.repositories.BaseRepository;
import com.agu.coffeeshop.repositories.ItemRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepositoryImpl extends BaseRepositoryImpl<Item> implements ItemRepository {

    private final MongoTemplate mongoTemplate;

    protected ItemRepositoryImpl(MongoTemplate itemMongoTemplate) {
        super(Item.class, itemMongoTemplate);
        this.mongoTemplate = itemMongoTemplate;
    }

}
