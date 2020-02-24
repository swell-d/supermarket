package com.supermarket.backend.receiptoutput;

import com.supermarket.backend.model.Receipt;

public class ReceiptHTML implements ReceiptOutput {

    public String printReceipt(Receipt receipt) {
        StringBuilder result = new StringBuilder();
        ReceiptPrinter printer = new ReceiptPrinter(40);
        result.append("<html><head><style>.receipt {font-family: monospace;}</style></head><body><div class=\"receipt\">");
        String simpleText = printer.printReceipt(receipt);
        result.append(simpleText.replace("\n", "<br>").replace(" ", "&nbsp;"));
        result.append("</div></body></html>");
        return result.toString();
    }
}
