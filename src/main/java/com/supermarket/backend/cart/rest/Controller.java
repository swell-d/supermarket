package com.supermarket.backend.cart.rest;

import com.supermarket.backend.cart.actions.CartActions;
import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.pricing.PriceList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private ShoppingCart cart = null;
    private PriceList priceList = null;

    public Controller(PriceList priceList) {
        this.cart = CartActions.createCart(priceList);
        this.priceList = priceList;
    }

    @GetMapping("/addProduct")
    public String addProduct(@RequestParam(name = "productName") String productName,
                             @RequestParam(name = "productCount") String productCount) {
        if (!CartActions.addProduct(this.cart, this.priceList, productName, productCount))
            return productName + " not found.";
        return productName + " added.";
    }

    @GetMapping("/receipt")
    public String receipt() {
        return CartActions.getHTMLReceipt(this.cart);
    }

    @GetMapping("/clearCart")
    public String clearCart() {
        this.cart = CartActions.createCart(this.priceList);
        return "Cart cleared.";
    }

}

