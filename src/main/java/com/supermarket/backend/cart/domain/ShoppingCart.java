package com.supermarket.backend.cart.domain;

import com.supermarket.backend.catalog.Product;
import com.supermarket.backend.offer.Bundle;
import com.supermarket.backend.offer.SpecialOfferType;
import com.supermarket.backend.pricing.PriceList;
import com.supermarket.backend.report.Report;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCart {

    private ArrayList<Bundle> bundles = new ArrayList<>();
    private LinkedHashMap<Product, Double> productQuantities = new LinkedHashMap<>();
    private final PriceList priceList;

    public PriceList getPriceList() {
        return priceList;
    }

    public ShoppingCart(PriceList priceList) {
        this.priceList = priceList;
    }

    public void addItemQuantity(Product product, double quantity) {
        if (productQuantities.containsKey(product)) {
            productQuantities.put(product, productQuantities.get(product) + quantity);
        } else productQuantities.put(product, quantity);
    }

    public void addBundle(Bundle bundle) {
        bundles.add(bundle);
    }

    public Receipt getReceipt() {
        Receipt receipt = new Receipt();
        for (Map.Entry<Product, Double> entry : productQuantities.entrySet()) {
            receipt.addProduct(entry.getKey(), entry.getValue(), priceList.getProductPrice(entry.getKey()));
        }
        handleOffers(receipt);
        return receipt;
    }

    private void handleOffers(Receipt receipt) {
        for (Bundle bundle : bundles) createDiscounts(receipt, bundle, getFullSets(bundle));
    }

    private double getFullSets(Bundle bundle) {
        double fullSets = Double.MAX_VALUE;
        for (ProductQuantity pq : bundle.getProductsArray()) {
            Product product = pq.getProduct();
            double quantity = pq.getQuantity();
            if (productQuantities.containsKey(product))
                fullSets = Math.min(fullSets, productQuantities.get(product) / quantity);
            else return 0.0;
        }
        if (bundle.getSpecialOfferType() == SpecialOfferType.FixAmount) fullSets = (int) fullSets;
        if (fullSets < 1.0) return 0.0;
        return fullSets;
    }

    private void createDiscounts(Receipt receipt, Bundle bundle, double fullSets) {
        if (fullSets < 1.0) return;
        bundle.addDiscountToReceipt(receipt, bundle, fullSets, priceList);
    }

    public String export(Report printer) {
        return printer.printReceipt(getReceipt());
    }

    public Product getProductByName(String productName) {
        return priceList.getProductByName(productName);
    }

}
