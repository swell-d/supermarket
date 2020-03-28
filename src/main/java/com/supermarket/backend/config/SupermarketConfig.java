package com.supermarket.backend.config;

import com.supermarket.backend.cart.actions.AddProductAction;
import com.supermarket.backend.cart.actions.ClearCartAction;
import com.supermarket.backend.cart.actions.GetReceiptAction;
import com.supermarket.backend.cart.db.memory.InMemoryCartRepository;
import com.supermarket.backend.cart.domain.CartRepository;
import com.supermarket.backend.catalog.Catalog;
import com.supermarket.backend.catalog.actions.GetCatalogAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SupermarketConfig {

    @Bean
    public Catalog catalog() {
        return new MockCatalogFactory().createMockCatalog();
    }

    @Bean
    public CartRepository cartRepository() {
        return new InMemoryCartRepository();
    }

    @Bean
    public AddProductAction addProductAction(Catalog catalog, CartRepository cartRepository) {
        return new AddProductAction(cartRepository, catalog);
    }

    @Bean
    public ClearCartAction clearCartAction(Catalog catalog, CartRepository cartRepository) {
        return new ClearCartAction(cartRepository, catalog);
    }

    @Bean
    public GetReceiptAction getReceiptAction(Catalog catalog, CartRepository cartRepository) {
        return new GetReceiptAction(cartRepository, catalog);
    }

    @Bean
    public GetCatalogAction getCatalogAction(Catalog catalog) {
        return new GetCatalogAction(catalog);
    }
}
