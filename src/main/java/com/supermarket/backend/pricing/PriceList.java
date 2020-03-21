package com.supermarket.backend.pricing;

import com.supermarket.backend.catalog.Catalog;
import com.supermarket.backend.catalog.Product;

import java.util.LinkedHashMap;

public interface PriceList {

    void addPrice(Product product, double price);

    void deleteProduct(Product product);

    double getProductPrice(Product product);

    LinkedHashMap<Product, Double> getPriceList();

    Catalog getCatalog();

    Product getProductByName(String productName);

}
