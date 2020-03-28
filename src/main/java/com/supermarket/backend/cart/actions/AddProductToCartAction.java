package com.supermarket.backend.cart.actions;

import com.supermarket.backend.cart.domain.CartRepository;
import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.Product;

public class AddProductToCartAction {

    private CartRepository cartRepository;
    private Catalog catalog;

    public AddProductToCartAction(CartRepository cartRepository, Catalog catalog) {
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
