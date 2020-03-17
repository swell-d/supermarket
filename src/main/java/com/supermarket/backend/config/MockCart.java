package com.supermarket.backend.config;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.pricing.PriceList;

public class MockCart {

    public static ShoppingCart getMockCart() {
        PriceList priceList = new MockPriceList();
        ShoppingCart cart = new ShoppingCart(priceList);

        cart.addBundle(MockBundles.tenPercentBundle(priceList.getCatalog()));
        cart.addBundle(MockBundles.fixPriceBundle(priceList.getCatalog()));

        cart.addItemQuantity(priceList.getProductByName("Tomatoes"), 4.4);
        cart.addItemQuantity(priceList.getProductByName("Potatoes"), 5.5);
        cart.addItemQuantity(priceList.getProductByName("Phone"), 1);
        cart.addItemQuantity(priceList.getProductByName("Bag"), 3);

        return cart;
    }
}
