package com.agu.coffeeshop.repositories.impl;

import com.agu.coffeeshop.entities.History;
import com.agu.coffeeshop.repositories.HistoryRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HistoryRepositoryImpl implements HistoryRepository {

    private final MongoTemplate mongoTemplate;

    public HistoryRepositoryImpl(MongoTemplate lrtDataTemplate) {
        this.mongoTemplate = lrtDataTemplate;
    }

    @Override
    public void insert(History history) {
        mongoTemplate.insert(history);
    }

    @Override
    public List<History> findAllByParentId(String parentId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("parentId").is(parentId));
        return mongoTemplate.find(query, History.class);
    }
}
