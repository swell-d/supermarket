package com.supermarket.backend.catalog.db.h2;

import com.supermarket.backend.catalog.Catalog;
import com.supermarket.backend.catalog.Product;

public class H2Catalog implements Catalog {
    @Override
    public void addProduct(Product product, double price) {

    }

    @Override
    public double getUnitPrice(Product product) {
        return 0;
    }

    @Override
    public Product getProductByName(String productName) {
        return null;
    }
}
