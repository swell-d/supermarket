package com.supermarket.backend.rest.config;

import com.supermarket.backend.catalogues.MockCatalog;
import com.supermarket.backend.cart.SupermarketCatalog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SupermarketConfig {

    @Bean
    public SupermarketCatalog supermarketCatalog() {
        return new MockCatalog();
    }
}
