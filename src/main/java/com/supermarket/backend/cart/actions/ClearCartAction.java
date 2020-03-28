package com.supermarket.backend.cart.actions;

import com.supermarket.backend.cart.domain.CartRepository;
import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.catalog.Catalog;

public class ClearCartAction {

    private CartRepository cartRepository;
    private Catalog catalog;

    public ClearCartAction(CartRepository cartRepository, Catalog catalog) {
        this.cartRepository = cartRepository;
        this.catalog = catalog;
    }

    public void clearCart() {
        ShoppingCart cart = cartRepository.getCart("user 1", catalog);
        cart.clearCart();
    }

}
