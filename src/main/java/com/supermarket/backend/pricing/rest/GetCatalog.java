package com.supermarket.backend.pricing.rest;

import com.supermarket.backend.cartrepository.CartRepository;
import com.supermarket.backend.pricing.PriceList;
import com.supermarket.backend.pricing.actions.GetCatalogAction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetCatalog {
    private PriceList priceList;

    public GetCatalog(PriceList priceList, CartRepository cartRepository) {
        this.priceList = priceList;
    }

    @GetMapping("/catalog")
    public String catalog() {
        return GetCatalogAction.getCatalog(priceList);
    }
}
