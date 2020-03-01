package com.supermarket.backend.catalogues;

import com.supermarket.backend.product.Product;

public interface SupermarketCatalog {
    void addProduct(Product product, double price);

    double getUnitPrice(Product product);

    Product getProductByName(String productName);
}
