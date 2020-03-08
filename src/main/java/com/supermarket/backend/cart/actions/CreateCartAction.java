package com.supermarket.backend.cart.actions;

import com.supermarket.backend.cart.domain.ShoppingCart;

public class CreateCartAction {

    public ShoppingCart createCart() {
        return new ShoppingCart(priceList);
    }

}
