package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetProductsFromCatalogAction {

    private Catalog catalog;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public GetProductsFromCatalogAction(Catalog catalog) {
        this.catalog = catalog;
    }

    public List<Product.Importer> getProducts() {
        logger.info("Try to get all products from catalog");
        return catalog.getProducts();
    }

}
