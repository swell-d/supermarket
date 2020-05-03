package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddProductToCatalogAction {

    private Catalog catalog;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public AddProductToCatalogAction(Catalog catalog) {
        this.catalog = catalog;
    }

    public void addProductToCatalog(Product.Importer newProductRequest) {
        logger.info("Try to add product to catalog");
        new ValidateProductData().validate(newProductRequest);
        verifyIsUnique(newProductRequest);
        catalog.add(newProductRequest);
    }

    private void verifyIsUnique(Product.Importer addProductRequest) {
        if(catalog.productExists(addProductRequest.article()))
            throw new IllegalStateException();
    }

}
