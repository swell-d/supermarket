package com.supermarket.backend.cart.api.rest;

import com.supermarket.backend.cart.actions.AddProductToCartAction;
import com.supermarket.backend.catalog.domain.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddProductToCart {

    private AddProductToCartAction addProductToCartAction;

    public AddProductToCart(AddProductToCartAction addProductToCartAction) {
        this.addProductToCartAction = addProductToCartAction;
    }

    @PostMapping(path = "/cart", consumes = "application/json")
    public String addProduct(@RequestBody Map<String, String> newProduct) {
        Product product = addProductToCartAction.findProductByName(newProduct.get("productName"));
        if (product != null) {
            addProductToCartAction.addProduct(product, newProduct.get("productCount"));
            return newProduct.get("productName") + " added.";
        }
        return newProduct.get("productName") + " not found.";
    }

}
