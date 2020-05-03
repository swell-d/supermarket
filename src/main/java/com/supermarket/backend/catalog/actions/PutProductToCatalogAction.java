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
        verifyIsExist(newProductRequest);
        catalog.delete(newProductRequest.article());
        catalog.add(newProductRequest);
    }

    private void verifyIsExist(Product.Importer productRequest) {
        if (!catalog.productExists(productRequest.article()))
            throw new IllegalStateException();
    }

}
