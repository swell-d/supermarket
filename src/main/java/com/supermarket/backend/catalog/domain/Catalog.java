package com.supermarket.backend.catalog.domain;

import java.util.ArrayList;

public interface Catalog {

    void add(Product.Importer importer);

    void deleteProduct(Product product);

    Product byArticle(String productArticle);

    ArrayList<Product> getProducts();

    Double getBaseProductPrice(Product product);

    boolean productExists(String article);
}
