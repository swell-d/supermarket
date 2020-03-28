package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.Product;

public class ChangeProductInCatalogAction {

    private Catalog catalog;

    public ChangeProductInCatalogAction(Catalog catalog) {
        this.catalog = catalog;
    }

    public Product changeProductInCatalog(String article) {
        return null;
    }
}
