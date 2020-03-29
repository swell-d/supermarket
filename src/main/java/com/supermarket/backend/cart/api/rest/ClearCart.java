package com.supermarket.backend.cart.api.rest;

import com.supermarket.backend.cart.actions.ClearCartAction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClearCart {

    private ClearCartAction clearCartAction;

    public ClearCart(ClearCartAction clearCartAction) {
        this.clearCartAction = clearCartAction;
    }

    @DeleteMapping(path = "/cart")
    public String clearCart() {
        clearCartAction.clearCart();
        return "Cart cleared.";
    }

}
