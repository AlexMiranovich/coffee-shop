package com.agu.coffeeshop.repositories.impl;

import com.agu.coffeeshop.entities.Identifiable;
import com.agu.coffeeshop.repositories.BaseRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

public abstract class BaseRepositoryImpl<T extends Identifiable> implements BaseRepository<T> {

    private final Class<T> type;
    private final MongoTemplate mongoTemplate;

    protected BaseRepositoryImpl(Class<T> type, MongoTemplate mongoTemplate) {
        this.type = type;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public T findById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, type);
    }

    @Override
    public List<T> findAll() {
        return mongoTemplate.findAll(type);
    }

    @Override
    public T save(T entity) {
        mongoTemplate.insert(entity);
        return findById(entity.getId());
    }

    @Override
    public T update(T transientEntity) {
        mongoTemplate.updateFirst(Query.query(Criteria.where("_id").is(transientEntity.getId())), new Update(), type);
        return findById(transientEntity.getId());
    }

    @Override
    public void delete(T entity) { mongoTemplate.remove(entity); }
}
