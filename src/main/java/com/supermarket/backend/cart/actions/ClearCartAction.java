package com.supermarket.backend.cart.actions;

import com.supermarket.backend.cart.domain.CartRepository;
import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.pricing.PriceList;

public class ClearCartAction {

    private CartRepository cartRepository;
    private PriceList priceList;

    public ClearCartAction(CartRepository cartRepository, PriceList priceList) {
        this.cartRepository = cartRepository;
        this.priceList = priceList;
    }

    public void clearCart() {
        ShoppingCart cart = cartRepository.getCart("user 1", priceList);
        cart.clearCart();
    }

}
