package com.supermarket.backend.pricing.db.hashmap;

import com.supermarket.backend.catalog.Product;
import com.supermarket.backend.pricing.PriceList;

import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapPriceList implements PriceList {

    private LinkedHashMap<Product, Double> priceList = new LinkedHashMap<>();

    @Override
    public boolean addProduct(Product product, double price) {
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

    public Product getProductByName(String productName) {
        for (Map.Entry<Product, Double> entry : this.priceList.entrySet()) {
            if (entry.getKey().getName().equals(productName)) {
                return entry.getKey();
            }
        }
        return null;
    }

}
