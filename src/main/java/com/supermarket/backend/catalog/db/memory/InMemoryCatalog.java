package com.supermarket.backend.catalog.db.memory;

import com.supermarket.backend.catalog.Catalog;
import com.supermarket.backend.catalog.PriceType;
import com.supermarket.backend.catalog.Product;

import java.util.ArrayList;
import java.util.Objects;

public class InMemoryCatalog implements Catalog {

    public ArrayList<Product> products = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        for (Product existProduct : this.products) {
            if (Objects.equals(existProduct, product)) throw new IllegalArgumentException();
        }
        products.add(product);
    }

    @Override
    public void deleteProduct(Product product) {
        for (Product existProduct : this.products) {
            if (Objects.equals(existProduct, product)) {
                this.products.remove(product);
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
    public ArrayList<Product> getCatalog() {
        return products;
    }

    @Override
    public Double getBaseProductPrice(Product product) {
        return product.prices.get(PriceType.Base);
    }

}
