package com.supermarket.backend.cart.api.rest;

import com.supermarket.backend.cart.actions.AddProductToCartAction;
import com.supermarket.backend.catalog.domain.Product;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddProductToCart {

    private AddProductToCartAction addProductToCartAction;

    public AddProductToCart(AddProductToCartAction addProductToCartAction) {
        this.addProductToCartAction = addProductToCartAction;
    }

    @PutMapping("/cart/addProduct")
    public String addProduct(@RequestParam(name = "productName") String productName,
                             @RequestParam(name = "productCount") String productCount) {
        Product product = addProductToCartAction.findProductByName(productName);
        if (product != null) {
            addProductToCartAction.addProduct(product, productCount);
            return productName + " added.";
        }
        return productName + " not found.";
    }
}
