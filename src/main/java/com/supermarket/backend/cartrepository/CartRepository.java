package com.supermarket.backend.cartrepository;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.pricing.PriceList;

public interface CartRepository {

    public ShoppingCart createCart(String userName, PriceList priceList);

    public ShoppingCart getCart(String userName);

    public int getSize();

}
