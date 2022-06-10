package com.agu.coffeeshop.repositories.impl;

import com.agu.coffeeshop.entities.User;
import com.agu.coffeeshop.repositories.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository {

    private final MongoTemplate mongoTemplate;

    protected UserRepositoryImpl(MongoTemplate userMongoTemplate) {
        super(User.class, userMongoTemplate);
        this.mongoTemplate = userMongoTemplate;
    }

    @Override
    public User save(User user) {
        mongoTemplate.insert(user);
        return findById(user.getId());
    }
}
