package com.supermarket.backend.report;

import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.config.MockCart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiptPrinterTests {

    @Test
    public void receiptPrinterTest() {
        ShoppingCart cart = MockCart.getMockCart();
        String expected =
                "Tomatoes                          435.60\n" +
                        "  99.00 * 4.400\n" +
                        "Potatoes                          363.00\n" +
                        "  66.00 * 5.500\n" +
                        "Phone                             999.90\n" +
                        "Bag                                27.00\n" +
                        "  9.00 * 3\n" +
                        "10% off (Tomatoes)                -43.56\n" +
                        "bundle for 899.90 (Phone+Bag)    -109.00\n" +
                        "\n" +
                        "Total:                           1672.94\n";
        assertEquals(expected, new ReceiptPrinter(40).printReceipt(cart.getReceipt()));
    }

}
