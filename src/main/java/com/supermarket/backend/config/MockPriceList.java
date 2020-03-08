package com.supermarket.backend.config;

import com.supermarket.backend.pricing.db.hashmap.HashMapPriceList;

public class MockPriceList extends HashMapPriceList {

    public MockPriceList() {
        super(new MockCatalog());
        this.addProduct(this.getProductByName("tomatoes"), 99);
        this.addProduct(this.getProductByName("potatoes"), 66);
        this.addProduct(this.getProductByName("phone"), 999.90);
        this.addProduct(this.getProductByName("bag"), 9);
    }

}
