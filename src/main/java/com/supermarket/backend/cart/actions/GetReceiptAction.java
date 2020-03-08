package com.supermarket.backend.cart.actions;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.report.ReceiptHTML;

public class GetReceiptAction {

    public static String getReceipt(ShoppingCart cart) {
        return cart.export(new ReceiptHTML());
    }

}
