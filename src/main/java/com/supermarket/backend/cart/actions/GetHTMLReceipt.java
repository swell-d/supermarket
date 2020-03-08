package com.supermarket.backend.cart.actions;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.report.ReceiptHTML;

public class GetHTMLReceipt {

    public static String getHTMLReceipt(ShoppingCart cart) {
        return cart.export(new ReceiptHTML());
    }

}
