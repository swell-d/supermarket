package com.supermarket.backend.cart.actions;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.catalog.Product;
import com.supermarket.backend.pricing.PriceList;

public class AddProductToCartByName {

    public static boolean addProduct(ShoppingCart cart, PriceList priceList,
                                     String productName, String productCount) {
        Product product = priceList.getCatalog().getProductByName(productName);
        if (product == null) return false;
        cart.addItemQuantity(product, Double.parseDouble(productCount));
        return true;
    }

}
