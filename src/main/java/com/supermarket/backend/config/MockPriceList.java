package com.supermarket.backend.config;

import com.supermarket.backend.catalog.Product;
import com.supermarket.backend.catalog.ProductUnit;
import com.supermarket.backend.pricing.db.hashmap.HashMapPriceList;

public class MockPriceList extends HashMapPriceList {

    public MockPriceList() {
        this.addProduct(new Product("tomatoes", ProductUnit.Kilo), 1);
        this.addProduct(new Product("potatoes", ProductUnit.Kilo), 1);
    }

}
