package com.supermarket.backend.cart.domain;

import com.supermarket.backend.catalog.Catalog;
import com.supermarket.backend.catalog.Product;
import com.supermarket.backend.catalog.ProductUnit;
import com.supermarket.backend.offer.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    public ArrayList<Bundle> bundles = new ArrayList<>();
    public Map<Product, Double> productQuantities = new HashMap<>();
    public final Catalog catalog;

    public ShoppingCart(Catalog catalog) {
        this.catalog = catalog;
    }

    public void addItemQuantity(Product product, double quantity) {
        if (productQuantities.containsKey(product)) {
            productQuantities.put(product, productQuantities.get(product) + quantity);
        } else productQuantities.put(product, quantity);
    }

    public void addBundle(Bundle bundle) {
        bundles.add(bundle);
    }

    public Receipt checksOutArticlesFrom() {
        Receipt receipt = new Receipt();
        for (Map.Entry<Product, Double> entry : productQuantities.entrySet()) {
            receipt.addProduct(entry.getKey(), entry.getValue(), catalog.getUnitPrice(entry.getKey()));
        }
        handleOffers(receipt);
        return receipt;
    }

    public void handleOffers(Receipt receipt) {
        for (Bundle bundle : bundles) createDiscounts(receipt, bundle, getFullSets(bundle));
    }

    public double getFullSets(Bundle bundle) {
        double fullSets = Double.MAX_VALUE;
        for (ProductQuantity pq : bundle.getProductsArray()) {
            Product product = pq.getProduct();
            double quantity = pq.getQuantity();
            if (productQuantities.containsKey(product))
                fullSets = Math.min(fullSets, productQuantities.get(product) / quantity);
            else return 0.0;
        }
        return fullSets;
    }

    public void createDiscounts(Receipt receipt, Bundle bundle, double fullSets) {
        if (fullSets == 0.0) return;
        for (ProductQuantity pq : bundle.getProductsArray()) {
            Product product = pq.getProduct();
            if (product.getUnit() == ProductUnit.Each) fullSets = (int) fullSets;
            if (fullSets == 0.0) return;
            double totalPrice = catalog.getUnitPrice(product) * fullSets * pq.getQuantity();
            bundle.getSpecialOfferType().addDiscountToReceipt(totalPrice, receipt, bundle, fullSets, pq, product);
        }
    }
}