package com.supermarket.backend.catalog;

import java.util.Objects;

public class Product {
    private final String article;
    private final String name;
    private final ProductUnit unit;

    public Product(String article, String name, ProductUnit unit) {
        this.article = article;
        this.name = name;
        this.unit = unit;
    }

    public Product(String name, ProductUnit unit) {
        this.article = name;
        this.name = name;
        this.unit = unit;
    }

    public String getArticle() {
        return this.article;
    }

    public String getName() {
        return this.name;
    }

    public ProductUnit getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(article, product.article) && Objects.equals(name, product.name) && unit == product.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(article, name, unit);
    }
}
