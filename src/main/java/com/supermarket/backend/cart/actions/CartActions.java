package com.supermarket.backend.cart.actions;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.catalog.Product;
import com.supermarket.backend.pricing.PriceList;
import com.supermarket.backend.report.ReceiptHTML;

public class CartActions {
    public static ShoppingCart createCart(PriceList priceList) {
        return new ShoppingCart(priceList);
    }

    public static boolean addProduct(ShoppingCart cart, PriceList priceList,
                                     String productName, String productCount) {
        Product product = priceList.getProductByName(productName);
        if (product == null) return false;
        cart.addItemQuantity(product, Double.parseDouble(productCount));
        return true;
    }

    public static String getHTMLReceipt(ShoppingCart cart) {
        return new ReceiptHTML().printReceipt(cart.getReceipt());
    }

}
