package com.supermarket.backend.config;

import com.supermarket.backend.catalog.db.mongo.MongoCatalogAdapter;
import com.supermarket.backend.catalog.db.mongo.MongoProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    @Autowired
    private MongoProductRepository mongoCatalog;

    @Bean
    public MongoCatalogAdapter mongoCatalogAdapter(MongoProductRepository mongoCatalog) {
        return new MongoCatalogAdapter(mongoCatalog);
    }

}
