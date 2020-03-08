package com.supermarket.backend.pricing;

import com.supermarket.backend.catalog.Catalog;
import com.supermarket.backend.catalog.Product;

import java.util.LinkedHashMap;

public interface PriceList {

    Catalog catalog = null;

    boolean addProduct(Product product, double price);

    boolean deleteProduct(Product product);

    double getProductPrice(Product product);

    LinkedHashMap<Product, Double> getPriceList();

    public Product getProductByName(String productName);
}
