package com.agu.coffeeshop.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class MongoProperties {

    @Value("${spring.data.mongodb.uri}")
    public String uri;
    @Value("${spring.data.mongodb.database}")
    public String database;
}
