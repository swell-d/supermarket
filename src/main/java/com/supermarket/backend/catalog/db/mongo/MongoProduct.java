package com.supermarket.backend.catalog.db.mongo;

import com.supermarket.backend.catalog.domain.MeasurementUnit;
import org.springframework.data.annotation.Id;

import java.util.Map;
import java.util.Objects;

public class MongoProduct {

    @Id
    public String id;

    public String article;
    public String name;
    public String shortDescription;
    public String description;
    public String smallImage;
    public String image;
    public MeasurementUnit unit;
    public Map<String, Double> prices;

    public MongoProduct(String article, String name, String shortDescription, String description, String smallImage, String image, MeasurementUnit unit, Map<String, Double> prices) {
        this.article = article;
        this.name = name;
        this.shortDescription = shortDescription;
        this.description = description;
        this.smallImage = smallImage;
        this.image = image;
        this.unit = unit;
        this.prices = prices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MongoProduct that = (MongoProduct) o;
        return id.equals(that.id) &&
                article.equals(that.article) &&
                Objects.equals(name, that.name) &&
                Objects.equals(shortDescription, that.shortDescription) &&
                Objects.equals(description, that.description) &&
                Objects.equals(smallImage, that.smallImage) &&
                Objects.equals(image, that.image) &&
                Objects.equals(unit, that.unit) &&
                Objects.equals(prices, that.prices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, article, name, shortDescription, description, smallImage, image, unit, prices);
    }

}
