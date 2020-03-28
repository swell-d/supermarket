package com.supermarket.backend.catalog.api.rest;

import com.supermarket.backend.catalog.actions.DeleteProductFromCatalogAction;
import com.supermarket.backend.catalog.domain.Product;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class DeleteProductFromCatalog {


    private DeleteProductFromCatalogAction deleteProductFromCatalogAction;

    public DeleteProductFromCatalog(DeleteProductFromCatalogAction deleteProductFromCatalogAction) {
        this.deleteProductFromCatalogAction = deleteProductFromCatalogAction;
    }

    @DeleteMapping("/catalog/{article}")
    public Product product(@PathVariable String article) {
        return deleteProductFromCatalogAction.deleteProductFromCatalog(article);
    }


}
