package com.supermarket.backend.config;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.pricing.PriceList;

public class MockCart {

    public static ShoppingCart getMockCart() {
        PriceList priceList = new MockPriceList();
        ShoppingCart cart = new ShoppingCart(priceList);

        cart.addBundle(MockBundles.tenPercentBundle(priceList.getCatalog()));
        cart.addBundle(MockBundles.fixPriceBundle(priceList.getCatalog()));

        cart.addItemQuantity(priceList.getCatalog().getProductByName("Tomatoes"), 4.4);
        cart.addItemQuantity(priceList.getCatalog().getProductByName("Potatoes"), 5.5);
        cart.addItemQuantity(priceList.getCatalog().getProductByName("Phone"), 1);
        cart.addItemQuantity(priceList.getCatalog().getProductByName("Bag"), 3);

        return cart;
    }
}
