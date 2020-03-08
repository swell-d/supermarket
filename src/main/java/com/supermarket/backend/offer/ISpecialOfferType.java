package com.supermarket.backend.offer;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.catalog.Product;

public interface ISpecialOfferType {
    void addSpecialOffer(Product product, double argument, ShoppingCart shoppingCart);
}
