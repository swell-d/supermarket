package com.supermarket.backend.config;

import com.supermarket.backend.pricing.db.hashmap.HashMapPriceList;

public class MockPriceList extends HashMapPriceList {

    public MockPriceList() {
        super(new MockCatalog());
        this.addProduct(catalog.getProductByName("tomatoes"), 99);
        this.addProduct(catalog.getProductByName("potatoes"), 66);
        this.addProduct(catalog.getProductByName("phone"), 999.90);
        this.addProduct(catalog.getProductByName("bag"), 9);
    }

}
