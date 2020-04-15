package com.supermarket.backend.catalog.db.memory;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.Product;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class InMemoryCatalog implements Catalog {

    private ArrayList<Product> products = new ArrayList<Product>();
    private String FILENAME = "catalog.dat";
    private boolean testMode = false;

    public InMemoryCatalog() {
        loadFromFile();
    }

    public InMemoryCatalog(boolean testMode) {
        this.testMode = testMode;
    }

    @Override
    public void add(Product.Importer importer) {
        Product product = new Product(importer);
        for (Product existProducts : this.products) {
            if (product.isSameArticle(existProducts)) throw new IllegalArgumentException();
        }
        products.add(product);
        saveToFile();
    }

    @Override
    public void deleteProduct(Product product) {
        for (Product existProduct : this.products) {
            if (product.isSameArticle(existProduct)) {
                this.products.remove(existProduct);
                saveToFile();
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Product byArticle(String productArticle) {
        for (Product existProduct : this.products) {
            if (existProduct.importer.article().equals(productArticle)) {
                return existProduct;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public Double getBaseProductPrice(Product product) {
        return product.basePrice();
    }

    @Override
    public boolean productExists(String article) {
        return byArticle(article) != null;
    }

    public void saveToFile() {
        if (testMode) return;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(products);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void loadFromFile() {
        if (testMode) return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            products = ((ArrayList<Product>) ois.readObject());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
