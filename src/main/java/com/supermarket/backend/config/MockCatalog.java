package com.supermarket.backend.config;

import com.supermarket.backend.catalog.Product;
import com.supermarket.backend.catalog.ProductUnit;
import com.supermarket.backend.catalog.db.memory.InMemoryCatalog;

public class MockCatalog extends InMemoryCatalog {
    public MockCatalog() {
        this.addProduct(new Product("tomatoes", ProductUnit.Kilo));
        this.addProduct(new Product("potatoes", ProductUnit.Kilo));
        this.addProduct(new Product("phone", ProductUnit.Each));
        this.addProduct(new Product("bag", ProductUnit.Each));
    }
}
