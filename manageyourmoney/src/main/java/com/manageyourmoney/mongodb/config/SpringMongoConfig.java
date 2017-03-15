package com.manageyourmoney.mongodb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = "com.manageyourmoney.mongodb.repository")
public class SpringMongoConfig extends AbstractMongoConfiguration {

	@Override
	public String getDatabaseName() {
		return "manageYourMoneyApp";
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient("127.0.0.1");
	}

}
