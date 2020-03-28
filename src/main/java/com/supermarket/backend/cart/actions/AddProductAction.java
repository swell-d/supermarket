package com.supermarket.backend.cart.actions;

import com.supermarket.backend.cart.domain.CartRepository;
import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.catalog.Catalog;
import com.supermarket.backend.catalog.Product;

public class AddProductAction {

    private CartRepository cartRepository;
    private Catalog catalog;

    public AddProductAction(CartRepository cartRepository, Catalog catalog) {
        this.cartRepository = cartRepository;
        this.catalog = catalog;
    }

    public Product findProductByName(String productName) {
        ShoppingCart cart = cartRepository.getCart("user 1", catalog);
        return cart.getProductByName(productName);
    }

    public void addProduct(Product product, String productCount) {
        ShoppingCart cart = cartRepository.getCart("user 1", catalog);
        cart.addItemQuantity(product, Double.parseDouble(productCount));
    }

}
