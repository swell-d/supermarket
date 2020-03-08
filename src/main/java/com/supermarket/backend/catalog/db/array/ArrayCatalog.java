package com.supermarket.backend.catalog.db.array;

import com.supermarket.backend.catalog.Catalog;
import com.supermarket.backend.catalog.Product;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayCatalog implements Catalog {

    private ArrayList<Product> products = new ArrayList<>();

    @Override
    public boolean addProduct(Product product) {  // Todo check for unique Article
        for (Product existProduct : this.products) {
            if (Objects.equals(existProduct, product)) return false;
        }
        products.add(product);
        return true;
    }

    @Override
    public boolean deleteProduct(Product product) {
        for (Product existProduct : this.products) {
            if (Objects.equals(existProduct, product)) {
                this.products.remove(product);
                return true;
            }
        }
        return false;
    }

    @Override
    public Product getProductById(long productId) {  // Todo - need to discuss
        return null;
    }

    @Override
    public Product getProductByArticle(String productArticle) {
        for (Product existProduct : this.products) {
            if (existProduct.getArticle().equals(productArticle)) {
                return existProduct;
            }
        }
        return null;
    }

    @Override
    public Product getProductByName(String productName) {
        for (Product existProduct : this.products) {
            if (existProduct.getName().equals(productName)) {
                return existProduct;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Product> getCatalog() {
        return products;
    }

}
