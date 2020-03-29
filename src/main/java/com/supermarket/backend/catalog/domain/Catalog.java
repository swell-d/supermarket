package com.supermarket.backend.catalog.domain;

import java.util.ArrayList;

public interface Catalog {

    void addProduct(Product product);

    void deleteProduct(Product product);

    Product getProductByArticle(String productArticle);

    Product getProductByName(String productName);

    ArrayList<Product> getProducts();

    Double getBaseProductPrice(Product product);

}
