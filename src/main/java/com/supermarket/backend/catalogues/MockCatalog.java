package com.supermarket.backend.catalogues;

import com.supermarket.backend.product.Product;
import com.supermarket.backend.product.ProductUnit;

import java.util.HashMap;
import java.util.Map;

public class MockCatalog implements SupermarketCatalog {

    private Map<String, Product> products = new HashMap<>();
    private Map<String, Double> prices = new HashMap<>();

    public MockCatalog() {

        Product product1 = new Product("tomatoes", ProductUnit.Kilo);
        this.addProduct(product1, 1);
        Product product2 = new Product("potatoes", ProductUnit.Kilo);
        this.addProduct(product2, 1);

    }

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
