package com.supermarket.backend.model;

import com.supermarket.backend.cart.domain.ProductQuantity;
import com.supermarket.backend.cart.domain.Receipt;
import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.catalog.Product;
import com.supermarket.backend.catalog.ProductUnit;
import com.supermarket.backend.offer.Bundle;
import com.supermarket.backend.offer.SpecialOfferType;
import com.supermarket.backend.offer.SpecialOfferTypeV2;
import com.supermarket.backend.pricing.PriceList;
import com.supermarket.backend.pricing.db.hashmap.HashMapPriceList;
import com.supermarket.backend.report.ReceiptHTML;
import com.supermarket.backend.report.ReceiptPrinter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupermarketTest {

    @Test
    public void testBundles() {
        PriceList priceList = new HashMapPriceList();
        Product product1 = new Product("product1", ProductUnit.Each);
        priceList.addProduct(product1, 1);
        Product product2 = new Product("product2", ProductUnit.Each);
        priceList.addProduct(product2, 1);
        Product product3 = new Product("product3", ProductUnit.Each);
        priceList.addProduct(product3, 22);

        ArrayList<ProductQuantity> productsArray1 = new ArrayList<>();
        productsArray1.add(new ProductQuantity(product1, 2));
        productsArray1.add(new ProductQuantity(product2, 1));
        Bundle bundle1 = new Bundle(productsArray1, 10, SpecialOfferTypeV2.Percent);
        assertEquals(productsArray1, bundle1.getProductsArray());
        assertEquals(10, bundle1.getValue());

        ShoppingCart cart = new ShoppingCart(priceList);
        cart.addBundle(bundle1);

        AddProductToCartAndTestIt(cart, product1, 1, 1, 0, 1);
        AddProductToCartAndTestIt(cart, product2, 1, 2, 0, 2);
        AddProductToCartAndTestIt(cart, product1, 1, 2.7, 2, 2);
        AddProductToCartAndTestIt(cart, product1, 1, 3.7, 2, 2);
        AddProductToCartAndTestIt(cart, product1, 1, 4.7, 2, 2);
        AddProductToCartAndTestIt(cart, product2, 1, 5.4, 2, 2);
        AddProductToCartAndTestIt(cart, product2, 1, 6.4, 2, 2);
        AddProductToCartAndTestIt(cart, product3, 15, 15 * 22 + 6.4, 2, 3);

        // print receipt
        System.out.println(new ReceiptPrinter(40).printReceipt(cart.checksOutArticlesFrom()));
        System.out.println(new ReceiptHTML().printReceipt(cart.checksOutArticlesFrom()));
    }

    @Test
    public void testDiscountsOld() {
        PriceList priceList = new HashMapPriceList();
        Product toothbrush = new Product("toothbrush", ProductUnit.Each);
        priceList.addProduct(toothbrush, 0.99);
        Product apples = new Product("apples", ProductUnit.Kilo);
        priceList.addProduct(apples, 1.99);
        Product rice = new Product("rice", ProductUnit.Each);
        priceList.addProduct(rice, 2.49);
        Product toothpaste = new Product("toothpaste", ProductUnit.Each);
        priceList.addProduct(toothpaste, 1.79);
        Product cherrytomatoes = new Product("cherrytomatoes", ProductUnit.Each);
        priceList.addProduct(cherrytomatoes, 0.69);

        ShoppingCart cart = new ShoppingCart(priceList);
        SpecialOfferType.TwoForAmount.addSpecialOffer(toothbrush, 0.99, cart);
        SpecialOfferType.TenPercentDiscount.addSpecialOffer(apples, 20.0, cart);
        SpecialOfferType.TenPercentDiscount.addSpecialOffer(rice, 10.0, cart);
        SpecialOfferType.FiveForAmount.addSpecialOffer(toothpaste, 7.49, cart);
        SpecialOfferType.TwoForAmount.addSpecialOffer(cherrytomatoes, 0.99, cart);

        Product product;
        double productPrice;
        double productCount;
        double manualSum = 0;
        int discountsSize;
        int itemsSize = 0;

        // add apples
        product = apples;
        productPrice = 1.99;
        productCount = 0.5;
        manualSum += productPrice * productCount * 0.8;
        discountsSize = 1;
        itemsSize += 1;
        AddProductToCartAndTestIt(cart, product, productCount, manualSum, discountsSize, itemsSize);

        // add one toothbrush
        product = toothbrush;
        productPrice = 0.99;
        productCount = 1;
        manualSum += productPrice * productCount * 1;
        discountsSize = 1;
        itemsSize += 1;
        AddProductToCartAndTestIt(cart, product, productCount, manualSum, discountsSize, itemsSize);

        // add second toothbrush
        product = toothbrush;
        productPrice = 0.99;
        productCount = 1;
        manualSum += productPrice * productCount * 0;
        discountsSize = 2;
        itemsSize += 0;
        AddProductToCartAndTestIt(cart, product, productCount, manualSum, discountsSize, itemsSize);

        // add 3 more toothbrush, total = 5
        product = toothbrush;
        productPrice = 0.99;
        productCount = 3;
        manualSum += productPrice * productCount * 2 / 3;
        discountsSize = 2;
        itemsSize += 0;
        AddProductToCartAndTestIt(cart, product, productCount, manualSum, discountsSize, itemsSize);

        // add rice
        product = rice;
        productPrice = 2.49;
        productCount = 2;
        manualSum += productPrice * productCount * 0.9;
        discountsSize = 3;
        itemsSize += 1;
        AddProductToCartAndTestIt(cart, product, productCount, manualSum, discountsSize, itemsSize);

        // add toothpaste
        product = toothpaste;
        productPrice = 1.79;
        productCount = 1;
        manualSum += productPrice * productCount * 1;
        discountsSize = 3;
        itemsSize += 1;
        AddProductToCartAndTestIt(cart, product, productCount, manualSum, discountsSize, itemsSize);

        // add 4 more toothpaste
        product = toothpaste;
        productPrice = 1.79;
        productCount = 4;
        manualSum += -1.79 + 7.49;
        discountsSize = 4;
        itemsSize += 0;
        AddProductToCartAndTestIt(cart, product, productCount, manualSum, discountsSize, itemsSize);

        // add cherrytomatoes
        product = cherrytomatoes;
        productPrice = 0.69;
        productCount = 1;
        manualSum += productPrice * productCount * 1;
        discountsSize = 4;
        itemsSize += 1;
        AddProductToCartAndTestIt(cart, product, productCount, manualSum, discountsSize, itemsSize);

        // add 1 more cherrytomatoes
        product = cherrytomatoes;
        productPrice = 0.69;
        productCount = 1;
        manualSum += -0.69 + 0.99;
        discountsSize = 5;
        itemsSize += 0;
        AddProductToCartAndTestIt(cart, product, productCount, manualSum, discountsSize, itemsSize);

        // print receipt
        Receipt receipt = cart.checksOutArticlesFrom();
        ReceiptPrinter printer = new ReceiptPrinter(40);
        System.out.println(printer.printReceipt(receipt));

        // get html receipt
        ReceiptHTML html = new ReceiptHTML();
        System.out.println(html.printReceipt(receipt));
    }

    @Test
    public void testDiscountsNewV1() {
        PriceList priceList = new HashMapPriceList();
        Product product1 = new Product("product1", ProductUnit.Each);
        priceList.addProduct(product1, 1);
        Product product2 = new Product("product2", ProductUnit.Each);
        priceList.addProduct(product2, 1);
        Product product3 = new Product("product3", ProductUnit.Each);
        priceList.addProduct(product3, 1);
        Product product4 = new Product("product4", ProductUnit.Each);
        priceList.addProduct(product4, 1);

        ShoppingCart cart = new ShoppingCart(priceList);
        SpecialOfferType.ThreeForTwo.addSpecialOffer(product1, 2, cart);
        SpecialOfferType.TenPercentDiscount.addSpecialOffer(product2, 10, cart);
        SpecialOfferType.TwoForAmount.addSpecialOffer(product3, 1, cart);
        SpecialOfferType.FiveForAmount.addSpecialOffer(product4, 3, cart);

        AddProductToCartAndTestIt(cart, product1, 3, 2, 1, 1);
        AddProductToCartAndTestIt(cart, product2, 1, 2 + 0.9, 2, 2);
        AddProductToCartAndTestIt(cart, product3, 2, 2 + 0.9 + 1, 3, 3);
        AddProductToCartAndTestIt(cart, product4, 5, 2 + 0.9 + 1 + 3, 4, 4);
    }

    @Test
    public void testDiscountsNewV2() {
        PriceList priceList = new HashMapPriceList();
        Product product1 = new Product("product1", ProductUnit.Each);
        priceList.addProduct(product1, 1);
        Product product2 = new Product("product2", ProductUnit.Each);
        priceList.addProduct(product2, 1);
        Product product3 = new Product("product3", ProductUnit.Each);
        priceList.addProduct(product3, 1);
        Product product4 = new Product("product4", ProductUnit.Each);
        priceList.addProduct(product4, 1);

        ShoppingCart cart = new ShoppingCart(priceList);

        ArrayList<ProductQuantity> productsArray1 = new ArrayList<>();
        productsArray1.add(new ProductQuantity(product1, 3));
        cart.addBundle(new Bundle(productsArray1, 2, SpecialOfferTypeV2.FixAmount));

        ArrayList<ProductQuantity> productsArray2 = new ArrayList<>();
        productsArray2.add(new ProductQuantity(product2, 1));
        cart.addBundle(new Bundle(productsArray2, 10, SpecialOfferTypeV2.Percent));

        ArrayList<ProductQuantity> productsArray3 = new ArrayList<>();
        productsArray3.add(new ProductQuantity(product3, 2));
        cart.addBundle(new Bundle(productsArray3, 1, SpecialOfferTypeV2.FixAmount));

        ArrayList<ProductQuantity> productsArray4 = new ArrayList<>();
        productsArray4.add(new ProductQuantity(product4, 5));
        cart.addBundle(new Bundle(productsArray4, 3, SpecialOfferTypeV2.FixAmount));

        AddProductToCartAndTestIt(cart, product1, 3, 2, 1, 1);
        AddProductToCartAndTestIt(cart, product2, 1, 2 + 0.9, 2, 2);
        AddProductToCartAndTestIt(cart, product3, 2, 2 + 0.9 + 1, 3, 3);
        AddProductToCartAndTestIt(cart, product4, 5, 2 + 0.9 + 1 + 3, 4, 4);
    }

    @Test
    public void testThreeForTwo() {
        PriceList priceList = new HashMapPriceList();
        Product product = new Product("product", ProductUnit.Each);
        priceList.addProduct(product, 1);

        ShoppingCart cart = new ShoppingCart(priceList);
        SpecialOfferType.ThreeForTwo.addSpecialOffer(product, 2, cart);

        AddProductToCartAndTestIt(cart, product, 1, 1, 0, 1);
        AddProductToCartAndTestIt(cart, product, 1, 2, 0, 1);
        AddProductToCartAndTestIt(cart, product, 1, 2, 1, 1);
        AddProductToCartAndTestIt(cart, product, 1, 3, 1, 1);
        AddProductToCartAndTestIt(cart, product, 1, 4, 1, 1);
        AddProductToCartAndTestIt(cart, product, 1, 4, 1, 1);
        AddProductToCartAndTestIt(cart, product, 1, 5, 1, 1);
    }

    @Test
    public void testTenPercentDiscount10() {
        PriceList priceList = new HashMapPriceList();
        Product product = new Product("product", ProductUnit.Each);
        priceList.addProduct(product, 1);

        ShoppingCart cart = new ShoppingCart(priceList);
        SpecialOfferType.TenPercentDiscount.addSpecialOffer(product, 10, cart);

        AddProductToCartAndTestIt(cart, product, 1, 0.9, 1, 1);
        AddProductToCartAndTestIt(cart, product, 1, 1.8, 1, 1);
    }

    @Test
    public void testTenPercentDiscount20() {
        PriceList priceList = new HashMapPriceList();
        Product product = new Product("product", ProductUnit.Each);
        priceList.addProduct(product, 1);

        ShoppingCart cart = new ShoppingCart(priceList);
        SpecialOfferType.TenPercentDiscount.addSpecialOffer(product, 20, cart);

        AddProductToCartAndTestIt(cart, product, 1, 0.8, 1, 1);
        AddProductToCartAndTestIt(cart, product, 1, 1.6, 1, 1);
    }

    @Test
    public void testTwoForAmount() {
        PriceList priceList = new HashMapPriceList();
        Product product = new Product("product", ProductUnit.Each);
        priceList.addProduct(product, 1);

        ShoppingCart cart = new ShoppingCart(priceList);
        SpecialOfferType.TwoForAmount.addSpecialOffer(product, 1, cart);

        AddProductToCartAndTestIt(cart, product, 1, 1, 0, 1);
        AddProductToCartAndTestIt(cart, product, 1, 1, 1, 1);
        AddProductToCartAndTestIt(cart, product, 1, 2, 1, 1);
        AddProductToCartAndTestIt(cart, product, 1, 2, 1, 1);
        AddProductToCartAndTestIt(cart, product, 1, 3, 1, 1);
    }

    @Test
    public void testFiveForAmount() {
        PriceList priceList = new HashMapPriceList();
        Product product = new Product("product", ProductUnit.Each);
        priceList.addProduct(product, 1);

        ShoppingCart cart = new ShoppingCart(priceList);
        SpecialOfferType.FiveForAmount.addSpecialOffer(product, 3, cart);

        AddProductToCartAndTestIt(cart, product, 1, 1, 0, 1);
        AddProductToCartAndTestIt(cart, product, 1, 2, 0, 1);
        AddProductToCartAndTestIt(cart, product, 1, 3, 0, 1);
        AddProductToCartAndTestIt(cart, product, 1, 4, 0, 1);
        AddProductToCartAndTestIt(cart, product, 1, 3, 1, 1);
        AddProductToCartAndTestIt(cart, product, 1, 4, 1, 1);
        AddProductToCartAndTestIt(cart, product, 1, 5, 1, 1);
        AddProductToCartAndTestIt(cart, product, 1, 6, 1, 1);
        AddProductToCartAndTestIt(cart, product, 1, 7, 1, 1);
        AddProductToCartAndTestIt(cart, product, 1, 6, 1, 1);
        AddProductToCartAndTestIt(cart, product, 1, 7, 1, 1);
    }

    private void AddProductToCartAndTestIt(ShoppingCart cart, Product product, double productCount, double manualSum, int discountsSize, int itemsSize) {
        cart.addItemQuantity(product, productCount);
        Receipt receipt = cart.checksOutArticlesFrom();
        assertEquals(manualSum, receipt.getTotalPrice(), 0.01);
        assertEquals(discountsSize, receipt.getDiscounts().size());
        assertEquals(itemsSize, receipt.getItems().size());
    }
}
