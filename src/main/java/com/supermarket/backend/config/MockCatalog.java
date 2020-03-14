package com.supermarket.backend.config;

import com.supermarket.backend.catalog.Product;
import com.supermarket.backend.catalog.ProductUnit;
import com.supermarket.backend.catalog.db.memory.InMemoryCatalog;

public class MockCatalog extends InMemoryCatalog {
    public MockCatalog() {
        this.addProduct(new Product("Tomatoes", ProductUnit.Kilo));
        this.addProduct(new Product("Potatoes", ProductUnit.Kilo));
        this.addProduct(new Product("Phone", ProductUnit.Each));
        this.addProduct(new Product("Bag", ProductUnit.Each));
    }
}
