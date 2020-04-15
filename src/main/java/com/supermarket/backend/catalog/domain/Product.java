package com.supermarket.backend.catalog.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Product implements Serializable {
    final public String article;
    public String name;
    public String shortDescription = "";
    public String description = "";
    public String smallImage = "";
    public String image = "";
    public MeasurementUnit unit;
    public Map<String, Double> prices = new HashMap<>();


    public Product(Importer importer){
        this.article = importer.article();
        this.name = importer.name();
        this.shortDescription = importer.shortDescription();
        this.description = importer.description();
        this.smallImage = importer.smallImage();
        this.image = importer.image();
        this.unit = importer.unit();
        this.prices = importer.prices();
    }


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

    public interface Importer {
        String article();

        String name();

        String shortDescription();

        String description();

        String smallImage();

        String image();

        MeasurementUnit unit();

        Map<String, Double> prices();
    }
}

