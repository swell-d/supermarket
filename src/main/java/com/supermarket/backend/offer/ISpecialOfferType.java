package com.supermarket.backend.offer;

import com.supermarket.backend.product.Product;
import com.supermarket.backend.cart.ShoppingCart;

public interface ISpecialOfferType {
    void addSpecialOffer(Product product, double argument, ShoppingCart shoppingCart);
}
