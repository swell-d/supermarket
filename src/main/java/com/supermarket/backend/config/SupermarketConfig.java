package com.supermarket.backend.config;

import com.supermarket.backend.pricing.PriceList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SupermarketConfig {

    @Bean
    public PriceList supermarketCatalog() {
        return new MockPriceList();
    }
}
