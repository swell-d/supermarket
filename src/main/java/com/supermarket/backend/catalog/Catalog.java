package com.supermarket.backend.catalog;

import java.util.ArrayList;

public interface Catalog {

    boolean addProduct(Product product);

    boolean deleteProduct(Product product);

    Product getProductById(long productId);

    Product getProductByArticle(String productArticle);

    Product getProductByName(String productName);

    ArrayList<Product> getCatalog();

}
