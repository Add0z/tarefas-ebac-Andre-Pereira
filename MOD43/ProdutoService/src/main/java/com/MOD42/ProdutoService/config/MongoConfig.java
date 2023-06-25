/**
 * 
 */
package com.MOD42.ProdutoService.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author rodrigo.pires
 *
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.MOD42.ProdutoService.repository")
public class MongoConfig {

}
