package com.supermarket.backend.config;

import com.supermarket.backend.catalog.Catalog;
import com.supermarket.backend.pricing.PriceList;
import com.supermarket.backend.pricing.db.memory.InMemoryPriceList;

public class MockPriceListFactory {

    public PriceList createMockPriceList() {

        Catalog catalog = new MockCatalogFactory().createMockCatalog();
        PriceList priceList = new InMemoryPriceList(catalog);

        priceList.addPrice(catalog.getProductByName("Tomatoes"), 99);
        priceList.addPrice(catalog.getProductByName("Potatoes"), 66);
        priceList.addPrice(catalog.getProductByName("Phone"), 999.90);
        priceList.addPrice(catalog.getProductByName("Bag"), 9);

        return priceList;
    }

}
