package com.supermarket.backend.cart.rest;

import com.supermarket.backend.cart.actions.AddProductAction;
import com.supermarket.backend.catalog.Product;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddProduct {

    private AddProductAction addProductAction;

    public AddProduct(AddProductAction addProductAction) {
        this.addProductAction = addProductAction;
    }

    @PutMapping("/cart/addProduct")
    public String addProduct(@RequestParam(name = "productName") String productName,
                             @RequestParam(name = "productCount") String productCount) {
        Product product = addProductAction.findProductByName(productName);
        if (product != null) {
            addProductAction.addProduct(product, productCount);
            return productName + " added.";
        }
        return productName + " not found.";
    }
}
