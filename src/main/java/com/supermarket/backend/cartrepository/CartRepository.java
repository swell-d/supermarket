package com.supermarket.backend.cartrepository;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.pricing.PriceList;

public interface CartRepository {

    public ShoppingCart getCart(String userName, PriceList priceList);

    public int getSize();

}
