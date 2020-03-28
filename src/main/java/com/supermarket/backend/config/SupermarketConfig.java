package com.supermarket.backend.config;

import com.supermarket.backend.cart.actions.AddProductToCartAction;
import com.supermarket.backend.cart.actions.ClearCartAction;
import com.supermarket.backend.cart.actions.GetReceiptAction;
import com.supermarket.backend.cart.db.memory.InMemoryCartRepository;
import com.supermarket.backend.cart.domain.CartRepository;
import com.supermarket.backend.catalog.actions.CatalogActions;
import com.supermarket.backend.catalog.db.memory.InMemoryCatalog;
import com.supermarket.backend.catalog.domain.Catalog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SupermarketConfig {

    @Bean
    public Catalog catalog() {
        return new InMemoryCatalog();
    }

    @Bean
    public CartRepository cartRepository() {
        return new InMemoryCartRepository();
    }

    @Bean
    public AddProductToCartAction addProductAction(Catalog catalog, CartRepository cartRepository) {
        return new AddProductToCartAction(cartRepository, catalog);
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
    public CatalogActions getCatalogAction(Catalog catalog) {
        return new CatalogActions(catalog);
    }

}
