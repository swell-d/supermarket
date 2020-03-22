package com.supermarket.backend.cart.domain;

import com.supermarket.backend.pricing.PriceList;

public interface CartRepository {

    public ShoppingCart getCart(String userName, PriceList priceList);

    public int getSize();

}
