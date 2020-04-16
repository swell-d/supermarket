package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.Catalog;

public class DeleteProductFromCatalogAction {

    private Catalog catalog;

    public DeleteProductFromCatalogAction(Catalog catalog) {
        this.catalog = catalog;
    }

    public void deleteProductFromCatalog(String article) {
        if (!catalog.productExists(article)) throw new IllegalStateException();
        catalog.deleteProduct(article);
    }

}
