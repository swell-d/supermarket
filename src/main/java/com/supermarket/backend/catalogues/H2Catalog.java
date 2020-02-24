package com.supermarket.backend.catalogues;

import com.supermarket.backend.product.Product;
import com.supermarket.backend.cart.SupermarketCatalog;

public class H2Catalog implements SupermarketCatalog {
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
