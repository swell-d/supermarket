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
    public Map<String, Double> prices = new HashMap<>();

    public Product(String article, String name, MeasurementUnit unit) {
        this.article = article;
        this.name = name;
        this.unit = unit;
    }

    public boolean isSameArticle(Product product) {
        return article.equals(product.article);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return article.equals(product.article) &&
                Objects.equals(name, product.name) &&
                Objects.equals(shortDescription, product.shortDescription) &&
                Objects.equals(description, product.description) &&
                Objects.equals(smallImage, product.smallImage) &&
                Objects.equals(image, product.image) &&
                unit == product.unit &&
                Objects.equals(prices, product.prices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article, name, shortDescription, description, smallImage, image, unit, prices);
    }

}

