package com.supermarket.backend.cart.rest;

import com.supermarket.backend.cart.actions.GetReceiptAction;
import com.supermarket.backend.cartrepository.CartRepository;
import com.supermarket.backend.pricing.PriceList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetReceipt {

    private PriceList priceList;
    private CartRepository cartRepository;

    public GetReceipt(PriceList priceList, CartRepository cartRepository) {
        this.priceList = priceList;
        this.cartRepository = cartRepository;
    }

    @GetMapping("/receipt")
    public String receipt() {
        return GetReceiptAction.getReceipt(cartRepository.getCart("user1", priceList));
    }

}
