package com.supermarket.backend.model;

public interface SupermarketCatalog {
    void addProduct(Product product, double price);

    double getUnitPrice(Product product);

    Product getProductByName(String productName);
}
