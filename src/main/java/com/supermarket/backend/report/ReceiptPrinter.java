package com.supermarket.backend.report;

import com.supermarket.backend.cart.domain.Receipt;
import com.supermarket.backend.cart.domain.ReceiptItem;
import com.supermarket.backend.catalog.domain.MeasurementUnit;
import com.supermarket.backend.offer.Discount;

import java.util.Locale;

public class ReceiptPrinter implements Report {

    private final int columns;
    private final String LS = System.lineSeparator();

    public ReceiptPrinter() {
        this(40);
    }

    ReceiptPrinter(int columns) {
        this.columns = columns;
    }

    public String printReceipt(Receipt receipt) {
        StringBuilder result = new StringBuilder();
        for (ReceiptItem item : receipt.items) {
            String receiptItem = presentReceiptItem(item);
            result.append(receiptItem);
        }
        for (Discount discount : receipt.discounts) {
            String discountPresentation = presentDiscount(discount);
            result.append(discountPresentation);
        }
        result.append(LS);
        result.append(presentTotal(receipt));
        return result.toString();
    }

    private String presentReceiptItem(ReceiptItem item) {
        String totalPricePresentation = presentPrice(item.price * item.quantity);
        String name = item.product.importer.name();
        String line = formatLineWithWhitespace(name, totalPricePresentation);
        if (item.quantity != 1)
            line += "  " + presentPrice(item.price) + " * " + presentQuantity(item) + LS;
        return line;
    }

    private String presentDiscount(Discount discount) {
        return formatLineWithWhitespace(discount.description,
                "-" + presentPrice(discount.discountAmount));
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
        line.append(LS);
        return line.toString();
    }

    private static String presentPrice(double price) {
        return String.format(Locale.UK, "%.2f", price);
    }

    private static String presentQuantity(ReceiptItem item) {
        return MeasurementUnit.Each.equals(
                item.product.importer.unit()) ?
                String.format(Locale.UK, "%.0f", item.quantity)
                : String.format(Locale.UK, "%.3f", item.quantity
        );
    }
}
