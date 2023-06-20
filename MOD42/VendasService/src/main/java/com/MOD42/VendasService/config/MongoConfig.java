
package com.MOD42.VendasService.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableMongoRepositories(basePackages = "com.MOD42.VendasService.repository")
public class MongoConfig {

}
