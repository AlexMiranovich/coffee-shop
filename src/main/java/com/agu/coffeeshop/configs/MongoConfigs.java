package com.agu.coffeeshop.configs;

import com.agu.coffeeshop.properties.MongoProperties;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfigs extends AbstractMongoClientConfiguration {

    private final MongoProperties mongoProperties;

    public MongoConfigs(MongoProperties mongoProperties) {
        this.mongoProperties = mongoProperties;
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }

    @Override
    protected String getDatabaseName() { return mongoProperties.getDatabase();  }

    @Bean
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString(mongoProperties.getUri() + "/" + getDatabaseName()
);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }
}
