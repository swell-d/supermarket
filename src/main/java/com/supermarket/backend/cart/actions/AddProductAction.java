package com.supermarket.backend.cart.actions;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.catalog.Product;

public class AddProductAction {

    public static boolean addProduct(ShoppingCart cart,
                                     String productName, String productCount) {
        Product product = cart.getProductByName(productName);
        if (product != null) {
            cart.addItemQuantity(product, Double.parseDouble(productCount));
            return true;
        } else {
            return false;
        }
    }
}
