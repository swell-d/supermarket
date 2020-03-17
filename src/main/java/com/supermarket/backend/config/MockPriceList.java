package com.supermarket.backend.config;

import com.supermarket.backend.pricing.db.memory.InMemoryPriceList;

public class MockPriceList extends InMemoryPriceList {

    public MockPriceList() {
        super(new MockCatalog());
        this.addPrice(catalog.getProductByName("Tomatoes"), 99);
        this.addPrice(catalog.getProductByName("Potatoes"), 66);
        this.addPrice(catalog.getProductByName("Phone"), 999.90);
        this.addPrice(catalog.getProductByName("Bag"), 9);
    }

}
