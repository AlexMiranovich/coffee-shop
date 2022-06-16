package com.agu.coffeeshop.repositories.impl;

import com.agu.coffeeshop.entities.Item;
import com.agu.coffeeshop.entities.User;
import com.agu.coffeeshop.entities.enums.ItemType;
import com.agu.coffeeshop.repositories.BaseRepository;
import com.agu.coffeeshop.repositories.ItemRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepositoryImpl extends BaseRepositoryImpl<Item> implements ItemRepository {

    private final MongoTemplate mongoTemplate;

    protected ItemRepositoryImpl(MongoTemplate itemMongoTemplate) {
        super(Item.class, itemMongoTemplate);
        this.mongoTemplate = itemMongoTemplate;
    }


    @Override
    public List<Item> findByItemType(ItemType itemType) {
        Query query = new Query();
        query.addCriteria(Criteria.where("itemType").is(itemType));
        return mongoTemplate.find(query, Item.class);
    }
}
