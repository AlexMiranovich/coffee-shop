package com.agu.coffeeshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, MongoAutoConfiguration.class})
@SpringBootApplication(exclude = {MongoDataAutoConfiguration.class})
@EnableMongoAuditing
public class CoffeeShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeShopApplication.class, args);
	}
}
