package com.supermarket.backend.cart.domain;

import com.supermarket.backend.catalog.Catalog;

public interface CartRepository {

    public ShoppingCart getCart(String userName, Catalog catalog);

    public int getSize();

}
