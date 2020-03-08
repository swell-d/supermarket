package com.supermarket.backend.catalog;

public interface Catalog {
    void addProduct(Product product, double price);

    double getUnitPrice(Product product);

    Product getProductByName(String productName);
}
