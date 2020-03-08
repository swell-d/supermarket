package com.supermarket.backend.config;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.catalog.Catalog;

public class MockCart {

    public static ShoppingCart getMockCart() {
        Catalog catalog = new MockCatalog();
        ShoppingCart cart = new ShoppingCart(new MockPriceList());

        cart.addBundle(MockBundles.tenPercentBundle(catalog));
        cart.addBundle(MockBundles.fixPriceBundle(catalog));

        cart.addItemQuantity(catalog.getProductByName("tomatoes"), 4.4);
        cart.addItemQuantity(catalog.getProductByName("potatoes"), 5.5);
        cart.addItemQuantity(catalog.getProductByName("phone"), 1);
        cart.addItemQuantity(catalog.getProductByName("bag"), 3);

        return cart;
    }
}
