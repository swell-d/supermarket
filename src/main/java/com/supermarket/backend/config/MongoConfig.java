package com.supermarket.backend.config;

import com.supermarket.backend.catalog.db.mongo.MongoCatalogAdapter;
import com.supermarket.backend.catalog.db.mongo.MongoProductRepository;
import com.supermarket.backend.catalog.domain.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    @Autowired
    private MongoProductRepository mongoCatalog;

//    @Bean
//    public Catalog catalog() {
//        return new InMemoryCatalog();
//    }

    @Bean
    public Catalog catalog() {
        return new MongoCatalogAdapter(mongoCatalog);
    }

}
