package com.supermarket.backend.config;

import com.supermarket.backend.cartrepository.CartRepository;
import com.supermarket.backend.cartrepository.db.memory.InMemoryCartRepository;
import com.supermarket.backend.pricing.PriceList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SupermarketConfig {

    @Bean
    public PriceList priceList() {
        return new MockPriceList();
    }

    @Bean
    public CartRepository cartRepository() {
        return new InMemoryCartRepository();
    }

}
