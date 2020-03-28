package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.Product;

public class CatalogActions {

    private Catalog catalog;

    public CatalogActions(Catalog catalog) {
        this.catalog = catalog;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public Product getProductByArticle(String article) {
        return catalog.getProductByArticle(article);
    }

    public void addProductToCatalog(Product product) {
        catalog.addProduct(product);
    }

    public void changeProductInCatalog(String article, Product product) {
        // Todo how??
    }

    public void deleteProductFromCatalog(Product product) {
        catalog.deleteProduct(product);
    }

}
