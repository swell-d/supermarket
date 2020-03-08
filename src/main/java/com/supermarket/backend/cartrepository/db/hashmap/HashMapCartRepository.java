package com.supermarket.backend.cartrepository.db.hashmap;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.cartrepository.CartRepository;
import com.supermarket.backend.pricing.PriceList;

import java.util.LinkedHashMap;

public class HashMapCartRepository implements CartRepository {

    private LinkedHashMap<String, ShoppingCart> carts = new LinkedHashMap<>();

    @Override
    public ShoppingCart createCart(String userName, PriceList priceList) {
        if (carts.containsKey(userName)) {
            throw new IllegalArgumentException();
        }
        ShoppingCart shoppingCart = new ShoppingCart(priceList);
        carts.put(userName, shoppingCart);
        return shoppingCart;
    }

    @Override
    public ShoppingCart getCart(String userName) {
        if (carts.containsKey(userName)) {
            return carts.get(userName);
        }
        return null;
    }

    @Override
    public int getSize() {
        return carts.size();
    }

}
