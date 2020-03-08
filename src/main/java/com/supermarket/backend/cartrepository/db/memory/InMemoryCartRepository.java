package com.supermarket.backend.cartrepository.db.memory;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.cartrepository.CartRepository;
import com.supermarket.backend.pricing.PriceList;

import java.util.LinkedHashMap;

public class InMemoryCartRepository implements CartRepository {

    private LinkedHashMap<String, ShoppingCart> carts = new LinkedHashMap<>();

    @Override
    public ShoppingCart getCart(String userName, PriceList priceList) {
        if (carts.containsKey(userName)) {
            return carts.get(userName);
        }
        return createCart(userName, priceList);
    }

    private ShoppingCart createCart(String userName, PriceList priceList) {
        ShoppingCart shoppingCart = new ShoppingCart(priceList);
        carts.put(userName, shoppingCart);
        return shoppingCart;
    }

    @Override
    public int getSize() {
        return carts.size();
    }

}
