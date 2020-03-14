package com.supermarket.backend.cart.rest;

import com.supermarket.backend.cart.actions.GetCatalogAction;
import com.supermarket.backend.cartrepository.CartRepository;
import com.supermarket.backend.pricing.PriceList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetCatalog {
    private PriceList priceList;
    private CartRepository cartRepository;

    public GetCatalog(PriceList priceList, CartRepository cartRepository) {
        this.priceList = priceList;
        this.cartRepository = cartRepository;
    }

    @GetMapping("/catalog")
    public String catalog() {
        return GetCatalogAction.getCatalog(priceList);
    }
}
