package com.supermarket.backend.cart.rest;

import com.supermarket.backend.cart.actions.ClearCartAction;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClearCart {

    private ClearCartAction clearCartAction;

    public ClearCart(ClearCartAction clearCartAction) {
        this.clearCartAction = clearCartAction;
    }

    @PutMapping("/cart/clearCart")
    public String clearCart() {
        clearCartAction.clearCart();
        return "Cart cleared.";
    }

}
