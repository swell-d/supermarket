package com.supermarket.backend.catalog.api.rest;

import com.supermarket.backend.catalog.domain.MeasurementUnit;
import com.supermarket.backend.catalog.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class AddProductRequest implements Product.Importer {

    public String article;
    public String name;
    public String shortDescription = "";
    public String description = "";
    public String smallImage = "";
    public String image = "";
    public MeasurementUnit unit;
    public Map<String, Double> prices = new HashMap<>();


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
        return unit;
    }

    @Override
    public Map<String, Double> prices() {
        return prices;
    }
}
