package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.Catalog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteProductFromCatalogAction {

    private Catalog catalog;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public DeleteProductFromCatalogAction(Catalog catalog) {
        this.catalog = catalog;
    }

    public void deleteProductFromCatalog(String article) {
        logger.info("Try to delete product from catalog");
        if (!catalog.productExists(article)) throw new IllegalStateException();
        catalog.deleteProduct(article);
    }

}
