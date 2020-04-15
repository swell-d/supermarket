package com.supermarket.backend.mock;

import com.supermarket.backend.catalog.domain.MeasurementUnit;
import com.supermarket.backend.catalog.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class MockProductDto implements Product.Importer {
    private final String article;
    private final String name;
    private final MeasurementUnit measurementUnit;
    public String shortDescription;
    public String description;
    public String smallImage;
    public String image;
    public Map<String, Double> prices;

    public MockProductDto(String article, String name, MeasurementUnit measurementUnit) {

        this.article = article;
        this.name = name;
        this.measurementUnit = measurementUnit;
        prices = new HashMap<>();

    }

    @Override
    public String article() {
        return article;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String shortDescription() {
        return shortDescription;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public String smallImage() {
        return smallImage;
    }

    @Override
    public String image() {
        return image;
    }

    @Override
    public MeasurementUnit unit() {
        return measurementUnit;
    }

    @Override
    public Map<String, Double> prices() {
        return prices;
    }
}
