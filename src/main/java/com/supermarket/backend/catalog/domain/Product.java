package com.supermarket.backend.catalog.domain;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class Product implements Serializable {

    public Importer importer;

    public Product(Importer importer) {
        this.importer = importer;
    }

    public boolean isSameArticle(Product product) {
        return importer.article().equals(product.importer.article());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return importer.article().equals(product.importer.article()) &&
                Objects.equals(importer.name(), product.importer.name()) &&
                Objects.equals(importer.shortDescription(), product.importer.shortDescription()) &&
                Objects.equals(importer.description(), product.importer.description()) &&
                Objects.equals(importer.smallImage(), product.importer.smallImage()) &&
                Objects.equals(importer.image(), product.importer.image()) &&
                importer.unit() == product.importer.unit() &&
                Objects.equals(importer.prices(), product.importer.prices());
    }

    @Override
    public int hashCode() {
        return Objects.hash(importer.article(),
                importer.name(),
                importer.shortDescription(),
                importer.description(),
                importer.smallImage(),
                importer.image(),
                importer.unit(),
                importer.prices());
    }

    public Double basePrice() {
        return importer.prices().get("Base");
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

