package com.supermarket.backend.catalog.domain;

import java.util.ArrayList;

public interface Catalog {

    void add(Product product);

    void deleteProduct(Product product);

    Product byArticle(String productArticle);

    Product getProductByName(String productName);

    ArrayList<Product> getProducts();

    Double getBaseProductPrice(Product product);

    boolean productExists(String article);
}
