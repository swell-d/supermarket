package com.supermarket.backend.catalog.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Product {
    final public String article;
    public String name;
    public String shortDescription;
    public String description;
    public String smallImage;
    public String image;
    public MeasurementUnit unit;
    public Map<PriceCategory, Double> prices = new HashMap<>();

    public Product(String article, String name, MeasurementUnit unit) {
        this.article = article;
        this.name = name;
        this.unit = unit;
    }

    public Product(String name, MeasurementUnit unit) {
        this.article = name;
        this.name = name;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return article.equals(product.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article);
    }
}
