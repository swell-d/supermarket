package com.supermarket.backend.offer;

import com.supermarket.backend.cart.domain.Receipt;
import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.catalog.Catalog;
import com.supermarket.backend.catalog.Product;
import com.supermarket.backend.config.MockBundles;
import com.supermarket.backend.config.MockCatalog;
import com.supermarket.backend.config.MockPriceList;
import com.supermarket.backend.pricing.PriceList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BundleTests {

    @Test
    public void percentBundleTest() {
        Catalog catalog = new MockCatalog();
        Product tomatoes = catalog.getProductByName("Tomatoes");
        PriceList priceList = new MockPriceList();
        ShoppingCart cart = new ShoppingCart(priceList);
        cart.addBundle(MockBundles.tenPercentBundle(catalog));

        cart.addItemQuantity(tomatoes, 0.5);
        checkReceipt(cart.getReceipt(), 1, priceList.getProductPrice(tomatoes) * 0.5);
        cart.addItemQuantity(tomatoes, 0.5);
        checkReceipt(cart.getReceipt(), 1, priceList.getProductPrice(tomatoes) * 1);
        cart.addItemQuantity(tomatoes, 0.5);
        checkReceipt(cart.getReceipt(), 1, priceList.getProductPrice(tomatoes) * 1.5 * 0.9);
        cart.addItemQuantity(tomatoes, 0.5);
        checkReceipt(cart.getReceipt(), 1, priceList.getProductPrice(tomatoes) * 2.0 * 0.9);
        cart.addItemQuantity(tomatoes, 0.5);
        checkReceipt(cart.getReceipt(), 1, priceList.getProductPrice(tomatoes) * 2.5 * 0.9);
    }

    @Test
    public void fixAmountBundleTest() {
        Catalog catalog = new MockCatalog();
        Product phone = catalog.getProductByName("Phone");
        Product bag = catalog.getProductByName("Bag");
        PriceList priceList = new MockPriceList();
        ShoppingCart cart = new ShoppingCart(priceList);

        cart.addBundle(MockBundles.fixPriceBundle(catalog));

        cart.addItemQuantity(phone, 1);
        checkReceipt(cart.getReceipt(), 1, priceList.getProductPrice(phone) * 1);
        cart.addItemQuantity(phone, 1);
        checkReceipt(cart.getReceipt(), 1, priceList.getProductPrice(phone) * 2);

        cart.addItemQuantity(bag, 1);
        checkReceipt(cart.getReceipt(), 2, 899.90 + priceList.getProductPrice(phone));
        cart.addItemQuantity(bag, 1);
        checkReceipt(cart.getReceipt(), 2, 899.90 * 2);
        cart.addItemQuantity(bag, 1);
        checkReceipt(cart.getReceipt(), 2, 899.90 * 2 + priceList.getProductPrice(bag));
    }


    private void checkReceipt(Receipt receipt, int items, double sum) {
        assertEquals(items, receipt.getItems().size());
        assertEquals(sum, receipt.getTotalPrice(), 0.01);
    }

}
