package com.supermarket.backend.rest.config;

import com.supermarket.backend.catalogues.MockCatalog;
import com.supermarket.backend.catalogues.SupermarketCatalog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SupermarketConfig {

    @Bean
    public SupermarketCatalog supermarketCatalog() {
        return new MockCatalog();
    }
}
