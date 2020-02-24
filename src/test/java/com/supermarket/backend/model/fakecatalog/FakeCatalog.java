package com.supermarket.backend.model.fakecatalog;

import com.supermarket.backend.model.Product;
import com.supermarket.backend.model.SupermarketCatalog;

import java.util.HashMap;
import java.util.Map;

public class FakeCatalog implements SupermarketCatalog {
    private Map<String, Product> products = new HashMap<>();
    private Map<String, Double> prices = new HashMap<>();

    @Override
    public void addProduct(Product product, double price) {
        this.products.put(product.getName(), product);
        this.prices.put(product.getName(), price);
    }

    @Override
    public double getUnitPrice(Product p) {
        return this.prices.get(p.getName());
    }

    @Override
    public Product getProductByName(String productName) {
        return this.products.get(productName);
    }

}
