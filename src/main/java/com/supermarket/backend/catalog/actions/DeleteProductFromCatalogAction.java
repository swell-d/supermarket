package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.Product;

public class DeleteProductFromCatalogAction {

    private Catalog catalog;

    public DeleteProductFromCatalogAction(Catalog catalog) {
        this.catalog = catalog;
    }

    public Product deleteProductFromCatalog(String article) {
        return null;
    }
}
