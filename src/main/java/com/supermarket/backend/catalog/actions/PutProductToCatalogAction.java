package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PutProductToCatalogAction {

    private Catalog catalog;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public PutProductToCatalogAction(Catalog catalog) {
        this.catalog = catalog;
    }

    public void putProductToCatalog(Product.Importer newProductRequest) {
        logger.info("Try to edit product in catalog");
        new ValidateProductData().validate(newProductRequest);
        catalog.edit(newProductRequest);
    }

}
