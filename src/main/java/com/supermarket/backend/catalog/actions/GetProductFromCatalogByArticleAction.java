package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.Product;

public class GetProductFromCatalogByArticleAction {

    private Catalog catalog;

    public GetProductFromCatalogByArticleAction(Catalog catalog) {
        this.catalog = catalog;
    }

    public Product getProductByArticle(String article) {
        return catalog.getProductByArticle(article);
    }

}
