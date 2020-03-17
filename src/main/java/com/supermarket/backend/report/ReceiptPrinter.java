package com.supermarket.backend.report;

import com.supermarket.backend.cart.domain.Receipt;
import com.supermarket.backend.cart.domain.ReceiptItem;
import com.supermarket.backend.catalog.ProductUnit;
import com.supermarket.backend.offer.Discount;

import java.util.Locale;

public class ReceiptPrinter implements Report {

    private final int columns;

    public ReceiptPrinter() {
        this(40);
    }

    ReceiptPrinter(int columns) {
        this.columns = columns;
    }

    public String printReceipt(Receipt receipt) {
        StringBuilder result = new StringBuilder();
        for (ReceiptItem item : receipt.getItems()) {
            String receiptItem = presentReceiptItem(item);
            result.append(receiptItem);
        }
        for (Discount discount : receipt.getDiscounts()) {
            String discountPresentation = presentDiscount(discount);
            result.append(discountPresentation);
        }
        result.append("\n");
        result.append(presentTotal(receipt));
        return result.toString();
    }

    private String presentReceiptItem(ReceiptItem item) {
        String totalPricePresentation = presentPrice(item.getTotalPrice());
        String name = item.getProduct().getName();
        String line = formatLineWithWhitespace(name, totalPricePresentation);
        if (item.getQuantity() != 1)
            line += "  " + presentPrice(item.getPrice()) + " * " + presentQuantity(item) + "\n";
        return line;
    }

    private String presentDiscount(Discount discount) {
        return formatLineWithWhitespace(discount.getDescription(),
                "-" + presentPrice(discount.getDiscountAmount()));
    }

    private String presentTotal(Receipt receipt) {
        String name = "Total: ";
        String value = presentPrice(receipt.getTotalPrice());
        return formatLineWithWhitespace(name, value);
    }

    private String formatLineWithWhitespace(String name, String value) {
        StringBuilder line = new StringBuilder();
        line.append(name);
        int whitespaceSize = this.columns - name.length() - value.length();
        for (int i = 0; i < whitespaceSize; i++) line.append(" ");
        line.append(value);
        line.append('\n');
        return line.toString();
    }

    private static String presentPrice(double price) {
        return String.format(Locale.UK, "%.2f", price);
    }

    private static String presentQuantity(ReceiptItem item) {
        return ProductUnit.Each.equals(
                item.getProduct().getUnit()) ?
                String.format(Locale.UK, "%.0f", item.getQuantity())
                : String.format(Locale.UK, "%.3f", item.getQuantity()
        );
    }
}
