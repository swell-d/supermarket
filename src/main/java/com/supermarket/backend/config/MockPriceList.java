package com.supermarket.backend.config;

import com.supermarket.backend.pricing.db.memory.InMemoryPriceList;

public class MockPriceList extends InMemoryPriceList {

    public MockPriceList() {
        super(new MockCatalog());
        this.addPrice(catalog.getProductByName("tomatoes"), 99);
        this.addPrice(catalog.getProductByName("potatoes"), 66);
        this.addPrice(catalog.getProductByName("phone"), 999.90);
        this.addPrice(catalog.getProductByName("bag"), 9);
    }

}
