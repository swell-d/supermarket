package com.supermarket.backend.cart.rest;

import com.supermarket.backend.cart.actions.AddProductAction;
import com.supermarket.backend.cartrepository.CartRepository;
import com.supermarket.backend.pricing.PriceList;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddProduct {

    private PriceList priceList;
    private CartRepository cartRepository;

    public AddProduct(PriceList priceList, CartRepository cartRepository) {
        this.priceList = priceList;
        this.cartRepository = cartRepository;
    }

    @PutMapping("/addProduct")
    public String addProduct(@RequestParam(name = "productName") String productName,
                             @RequestParam(name = "productCount") String productCount) {
        return AddProductAction.addProduct(
                cartRepository.getCart("user1", priceList), productName, productCount);
    }
}
