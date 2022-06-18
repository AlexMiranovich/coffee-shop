package com.agu.coffeeshop.repositories.impl;

import com.agu.coffeeshop.entities.User;
import com.agu.coffeeshop.repositories.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class UserRepositoryImpl extends BaseRepository<User> implements UserRepository {

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

    @Override
    protected Update getMongoUpdate(User user) {
        Update update = new Update();
        update.set("firstName", user.getFirstName());
        update.set("lastName", user.getLastName());
        update.set("email", user.getEmail());
        update.set("dob", user.getDob());
        update.set("city", user.getCity());
        update.set("country", user.getCountry());
        update.set("phoneNumber", user.getPhoneNumber());

        return update;
    }
}
