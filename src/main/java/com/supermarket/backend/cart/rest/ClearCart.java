package com.supermarket.backend.cart.rest;

import com.supermarket.backend.cart.actions.ClearCartAction;
import com.supermarket.backend.cartrepository.CartRepository;
import com.supermarket.backend.pricing.PriceList;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClearCart {

    private PriceList priceList;
    private CartRepository cartRepository;

    public ClearCart(PriceList priceList, CartRepository cartRepository) {
        this.priceList = priceList;
        this.cartRepository = cartRepository;
    }

    @PutMapping("/clearCart")
    public String clearCart() {
        return ClearCartAction.clearCart(cartRepository.getCart("user1", priceList));
    }

}
