package com.supermarket.backend.catalog.domain;

import java.util.ArrayList;

public interface Catalog {

    void add(Product.Importer importer);

    void deleteProduct(String article);

    Product byArticle(String article);

    ArrayList<Product.Importer> getProducts();

    boolean productExists(String article);

}
