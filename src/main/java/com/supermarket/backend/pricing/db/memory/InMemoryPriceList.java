package com.supermarket.backend.pricing.db.memory;

import com.supermarket.backend.catalog.Catalog;
import com.supermarket.backend.catalog.Product;
import com.supermarket.backend.pricing.PriceList;

import java.util.LinkedHashMap;

public class InMemoryPriceList implements PriceList {

    public Catalog catalog;
    private LinkedHashMap<Product, Double> priceList = new LinkedHashMap<>();

    public InMemoryPriceList(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void addPrice(Product product, double price) {
        if (!catalog.getCatalog().contains(product)) throw new IllegalArgumentException();
        if (priceList.containsKey(product)) throw new IllegalArgumentException();
        priceList.put(product, price);
    }

    @Override
    public void deleteProduct(Product product) {
        if (priceList.containsKey(product)) {
            priceList.remove(product);
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public double getProductPrice(Product product) {
        if (priceList.containsKey(product)) {
            return priceList.get(product);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public LinkedHashMap<Product, Double> getPriceList() {
        return priceList;
    }

    @Override
    public Catalog getCatalog() {
        return catalog;
    }

    @Override
    public Product getProductByName(String productName) {
        return catalog.getProductByName(productName);
    }
}
