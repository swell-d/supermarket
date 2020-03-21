package com.supermarket.backend.config;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.pricing.PriceList;

public class MockCartFactory {

    public static ShoppingCart createMockCart() {
        PriceList priceList = new MockPriceListFactory().createMockPriceListFactory();
        ShoppingCart cart = new ShoppingCart(priceList);

        cart.addBundle(MockBundlesFactory.createTenPercentBundle(priceList.getCatalog()));
        cart.addBundle(MockBundlesFactory.createFixPriceBundle(priceList.getCatalog()));

        cart.addItemQuantity(priceList.getProductByName("Tomatoes"), 4.4);
        cart.addItemQuantity(priceList.getProductByName("Potatoes"), 5.5);
        cart.addItemQuantity(priceList.getProductByName("Phone"), 1);
        cart.addItemQuantity(priceList.getProductByName("Bag"), 3);

        return cart;
    }
}
