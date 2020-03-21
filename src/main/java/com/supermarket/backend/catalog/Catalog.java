package com.supermarket.backend.catalog;

import java.util.ArrayList;

public interface Catalog {

    void addProduct(Product product);

    void deleteProduct(Product product);

    Product getProductByArticle(String productArticle);

    Product getProductByName(String productName);

    ArrayList<Product> getCatalog();

}
