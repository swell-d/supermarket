package com.supermarket.backend.report;

import com.supermarket.backend.cart.domain.Receipt;

public class ReceiptHTML implements Report {

    public String printReceipt(Receipt receipt) {
        StringBuilder result = new StringBuilder();
        ReceiptPrinter printer = new ReceiptPrinter(40);
        result.append("<div class=\"receipt\" style=\"font-family: monospace;\">");
        String simpleText = printer.printReceipt(receipt);
        result.append(simpleText.replace("\n", "<br>").replace(" ", "&nbsp;"));
        result.append("</div>");
        return result.toString();
    }
}
