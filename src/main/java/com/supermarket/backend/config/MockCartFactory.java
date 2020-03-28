package com.supermarket.backend.config;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.catalog.domain.Catalog;

public class MockCartFactory {

    public static ShoppingCart createMockCart() {
        Catalog catalog = new MockCatalogFactory().createMockCatalog();
        ShoppingCart cart = new ShoppingCart(catalog);

        cart.addBundle(MockBundlesFactory.createTenPercentBundle(catalog));
        cart.addBundle(MockBundlesFactory.createFixPriceBundle(catalog));

        cart.addItemQuantity(catalog.getProductByName("Tomatoes"), 4.4);
        cart.addItemQuantity(catalog.getProductByName("Potatoes"), 5.5);
        cart.addItemQuantity(catalog.getProductByName("Phone"), 1);
        cart.addItemQuantity(catalog.getProductByName("Bag"), 3);

        return cart;
    }
}
