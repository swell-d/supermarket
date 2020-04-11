package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.Product;

public class AddProductToCatalogAction {

    private Catalog catalog;

    public AddProductToCatalogAction(Catalog catalog) {
        this.catalog = catalog;
    }

    public void addProductToCatalog(Product product) {
        catalog.addProduct(product);
    }

}
