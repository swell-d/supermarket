package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetProductByArticleAction {

    private Catalog catalog;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public GetProductByArticleAction(Catalog catalog) {
        this.catalog = catalog;
    }

    public Product getProductByArticle(String article) {
        logger.info("Try to get product from catalog");
        return catalog.byArticle(article);
    }

}
