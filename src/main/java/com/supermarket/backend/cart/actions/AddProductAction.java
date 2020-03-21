package com.supermarket.backend.cart.actions;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.cartrepository.CartRepository;
import com.supermarket.backend.catalog.Product;
import com.supermarket.backend.pricing.PriceList;

public class AddProductAction {

    private CartRepository cartRepository;
    private PriceList priceList;

    public AddProductAction(CartRepository cartRepository, PriceList priceList) {
        this.cartRepository = cartRepository;
        this.priceList = priceList;
    }

    public Product findProductByName(String productName) {
        ShoppingCart cart = cartRepository.getCart("user 1", priceList);
        return cart.getProductByName(productName);
    }

    public void addProduct(Product product, String productCount) {
        ShoppingCart cart = cartRepository.getCart("user 1", priceList);
        cart.addItemQuantity(product, Double.parseDouble(productCount));
    }

}
