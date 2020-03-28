package com.supermarket.backend.config;

import com.supermarket.backend.cart.actions.AddProductToCartAction;
import com.supermarket.backend.cart.actions.ClearCartAction;
import com.supermarket.backend.cart.actions.GetReceiptAction;
import com.supermarket.backend.cart.db.memory.InMemoryCartRepository;
import com.supermarket.backend.cart.domain.CartRepository;
import com.supermarket.backend.catalog.actions.AddProductToCatalogAction;
import com.supermarket.backend.catalog.actions.ChangeProductInCatalogAction;
import com.supermarket.backend.catalog.actions.DeleteProductFromCatalogAction;
import com.supermarket.backend.catalog.actions.GetCatalogAction;
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
    public GetCatalogAction getCatalogAction(Catalog catalog) {
        return new GetCatalogAction(catalog);
    }

    @Bean
    public AddProductToCatalogAction addProductToCatalogAction(Catalog catalog) {
        return new AddProductToCatalogAction(catalog);
    }

    @Bean
    public ChangeProductInCatalogAction changeProductInCatalogAction(Catalog catalog) {
        return new ChangeProductInCatalogAction(catalog);
    }

    @Bean
    public DeleteProductFromCatalogAction deleteProductFromCatalogAction(Catalog catalog) {
        return new DeleteProductFromCatalogAction(catalog);
    }

}
