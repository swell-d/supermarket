package com.supermarket.backend.cart.actions;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.catalog.Product;

public class AddProductAction {

    public static String addProduct(ShoppingCart cart,
                                    String productName, String productCount) {
        Product product = cart.getPriceList().getCatalog().getProductByName(productName);
        if (product == null) return productName + " not found.";
        cart.addItemQuantity(product, Double.parseDouble(productCount));
        return productName + " added.";
    }

}
