package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.Product;

import java.util.List;

public class GetProductsFromCatalogAction {

    private Catalog catalog;

    public GetProductsFromCatalogAction(Catalog catalog) {
        this.catalog = catalog;
    }

    public List<Product.Importer> getProducts() {
        return catalog.getProducts();
    }

}
