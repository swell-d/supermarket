package com.supermarket.backend.cart.actions;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.pricing.PriceList;

public class CreateCart {

    public static ShoppingCart createCart(PriceList priceList) {
        return new ShoppingCart(priceList);
    }

}
