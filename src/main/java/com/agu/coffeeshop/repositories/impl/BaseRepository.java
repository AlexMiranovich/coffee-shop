package com.agu.coffeeshop.repositories.impl;

import com.agu.coffeeshop.entities.Identifiable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

public abstract class BaseRepository<T extends Identifiable> {

    private final Class<T> type;
    private final MongoTemplate mongoTemplate;

    protected BaseRepository(Class<T> type, MongoTemplate mongoTemplate) {
        this.type = type;
        this.mongoTemplate = mongoTemplate;
    }

    public T findById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, type);
    }

    public List<T> findAll() {
        return mongoTemplate.findAll(type);
    }

    public T save(T entity) {
        mongoTemplate.insert(entity);
        return findById(entity.getId());
    }

    public T update(T entity) {
        Query query = Query.query(Criteria.where("_id").is(entity.getId()));
        mongoTemplate.updateFirst(query, getMongoUpdate(entity), type);
        return findById(entity.getId());
    }

    public void delete(T entity) { mongoTemplate.remove(entity); }

    protected abstract Update getMongoUpdate(T entity);

}
