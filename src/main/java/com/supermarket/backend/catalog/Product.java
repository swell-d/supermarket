package com.supermarket.backend.catalog;

import java.util.Objects;

public class Product {
    private String article;
    private String name;
    private String shortDescription;
    private String description;
    private String smallImage;
    private String image;
    private ProductUnit unit;

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

    public void setArticle(String article) {
        this.article = article;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setUnit(ProductUnit unit) {
        this.unit = unit;
    }

    public String getArticle() {
        return this.article;
    }

    public String getName() {
        return this.name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public String getImage() {
        return image;
    }

    public ProductUnit getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getArticle().equals(product.getArticle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArticle());
    }
}
