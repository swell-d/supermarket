package com.supermarket.backend.report;

import com.supermarket.backend.cart.domain.Receipt;

public class ReceiptHTML implements Report {

    private final String LS = System.lineSeparator();

    public String printReceipt(Receipt receipt) {
        StringBuilder result = new StringBuilder();
        ReceiptPrinter printer = new ReceiptPrinter(40);
        result.append("<div class=\"receipt\" style=\"font-family: monospace;\">");
        String simpleText = printer.printReceipt(receipt);
        result.append(simpleText.replace(" ", "&nbsp;").replace(LS, "<br />"));
        result.append("</div>");
        return result.toString();
    }
}
