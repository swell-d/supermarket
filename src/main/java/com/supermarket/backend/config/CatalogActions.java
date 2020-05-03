package com.supermarket.backend.config;

import com.supermarket.backend.catalog.actions.*;
import com.supermarket.backend.catalog.domain.Catalog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatalogActions {

    @Bean
    public AddProductToCatalogAction addProductToCatalogAction(Catalog catalog) {
        return new AddProductToCatalogAction(catalog);
    }

    @Bean
    public DeleteProductFromCatalogAction deleteProductFromCatalogAction(Catalog catalog) {
        return new DeleteProductFromCatalogAction(catalog);
    }

    @Bean
    public GetProductByArticleAction getProductFromCatalogByArticleAction(Catalog catalog) {
        return new GetProductByArticleAction(catalog);
    }

    @Bean
    public GetProductsFromCatalogAction getProductsFromCatalogAction(Catalog catalog) {
        return new GetProductsFromCatalogAction(catalog);
    }

    @Bean
    public PutProductToCatalogAction putProductToCatalogAction(Catalog catalog) {
        return new PutProductToCatalogAction(catalog);
    }

}
