package com.supermarket.backend.catalog.db.memory;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.Product;

import java.util.ArrayList;

public class InMemoryCatalog implements Catalog {

    private ArrayList<Product> products = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        for (Product existProduct : this.products) {
            if (product.isSameArticle(existProduct)) throw new IllegalArgumentException();
        }
        products.add(product);
    }

    @Override
    public void deleteProduct(Product product) {
        for (Product existProduct : this.products) {
            if (product.isSameArticle(existProduct)) {
                this.products.remove(existProduct);
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

}
