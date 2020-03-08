package com.supermarket.backend.config;

import com.supermarket.backend.catalog.Catalog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SupermarketConfig {

    @Bean
    public Catalog supermarketCatalog() {
        return new MockCatalog();
    }
}
