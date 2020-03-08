package com.supermarket.backend.pricing.db.hashmap;

import com.supermarket.backend.catalog.Catalog;
import com.supermarket.backend.catalog.Product;
import com.supermarket.backend.pricing.PriceList;

import java.util.LinkedHashMap;

public class HashMapPriceList implements PriceList {

    public Catalog catalog;
    private LinkedHashMap<Product, Double> priceList = new LinkedHashMap<>();

    public HashMapPriceList(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public boolean addProduct(Product product, double price) {
        if (!catalog.getCatalog().contains(product)) throw new IllegalArgumentException();
        priceList.put(product, price);
        return true;
    }

    @Override
    public boolean deleteProduct(Product product) {
        if (priceList.containsKey(product)) {
            priceList.remove(product);
            return true;
        }
        return false;
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
    public Product getProductByName(String productName) {
        return catalog.getProductByName(productName);
    }

}
