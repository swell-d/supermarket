package com.supermarket.backend.cart.actions;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.pricing.PriceList;
import com.supermarket.backend.report.ReceiptHTML;

public class GetReceiptAction {

    public static String getReceipt(ShoppingCart cart, PriceList priceList) {
        return cart.export(new ReceiptHTML());
    }

}
