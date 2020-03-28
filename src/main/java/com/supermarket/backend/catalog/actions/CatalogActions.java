package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.Product;

import java.util.List;

public class CatalogActions {

    private Catalog catalog;

    public CatalogActions(Catalog catalog) {
        this.catalog = catalog;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public List<Product> getProducts() {
        return catalog.getProducts();
    }

    public Product getProductByArticle(String article) {
        return catalog.getProductByArticle(article);
    }

    public void addProductToCatalog(Product product) {
        catalog.addProduct(product);
    }

    public void changeProductInCatalog(Product product, Product newProductData) {
        // Todo how??
    }

    public void deleteProductFromCatalog(Product product) {
        catalog.deleteProduct(product);
    }

}
