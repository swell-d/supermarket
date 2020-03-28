package com.supermarket.backend.cart.db.memory;

import com.supermarket.backend.cart.domain.CartRepository;
import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.catalog.domain.Catalog;

import java.util.LinkedHashMap;

public class InMemoryCartRepository implements CartRepository {

    private LinkedHashMap<String, ShoppingCart> carts = new LinkedHashMap<>();

    @Override
    public ShoppingCart getCart(String userName, Catalog catalog) {
        if (carts.containsKey(userName)) {
            return carts.get(userName);
        }
        return createCart(userName, catalog);
    }

    private ShoppingCart createCart(String userName, Catalog catalog) {
        ShoppingCart shoppingCart = new ShoppingCart(catalog);
        carts.put(userName, shoppingCart);
        return shoppingCart;
    }

    @Override
    public int getSize() {
        return carts.size();
    }

}
