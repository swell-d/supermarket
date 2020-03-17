package com.supermarket.backend.cart.actions;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.pricing.PriceList;

public class ClearCartAction {

    public static void clearCart(ShoppingCart cart) {
        PriceList priceList = cart.getPriceList();
        cart = new ShoppingCart(priceList);
    }

}
