package com.supermarket.backend.rest;

import com.supermarket.backend.cart.ShoppingCart;
import com.supermarket.backend.catalogues.SupermarketCatalog;
import com.supermarket.backend.product.Product;
import com.supermarket.backend.report.ReceiptHTML;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private SupermarketCatalog catalog = null;
    private ShoppingCart cart = null;

    public Controller(SupermarketCatalog catalog) {
        this.catalog = catalog;
    }

    @GetMapping("/start")
    public String start() {
        this.cart = new ShoppingCart(catalog);
        return "New shopping cart created.";
    }

    @GetMapping("/addProduct")
    public String addProduct(@RequestParam(name = "productName") String productName, @RequestParam(name = "productCount") String productCount) {
        if (this.cart == null) return "No cart.";
        Product product = catalog.getProductByName(productName);
        if (product == null) return "Product not found.";
        cart.addItemQuantity(product, Double.parseDouble(productCount));
        return productName + " added.";
    }

    @GetMapping("/receipt")
    public String receipt() {
        if (this.cart == null) return "No cart.";
        return new ReceiptHTML().printReceipt(cart.checksOutArticlesFrom());
    }

    @GetMapping("/clearCart")
    public String clearCart() {
        this.cart = new ShoppingCart(catalog);
        return "Cart cleared.";
    }

}

