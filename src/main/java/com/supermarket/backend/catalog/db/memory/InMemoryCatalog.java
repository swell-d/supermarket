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
    private final String FILENAME = "catalog.dat";

    public InMemoryCatalog() {
        loadFromFile();
    }

    @Override
    public void addProduct(Product product) {
        for (Product existProduct : this.products) {
            if (product.isSameArticle(existProduct)) throw new IllegalArgumentException();
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
    public Product getProductByArticle(String productArticle) {
        for (Product existProduct : this.products) {
            if (existProduct.article.equals(productArticle)) {
                return existProduct;
            }
        }
        return null;
    }

    @Override
    public Product getProductByName(String productName) {
        for (Product existProduct : this.products) {
            if (existProduct.name.equals(productName)) {
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
        return product.prices.get("Base");
    }

    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(products);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            products = ((ArrayList<Product>) ois.readObject());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
