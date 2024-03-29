package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.MeasurementUnit;
import com.supermarket.backend.catalog.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class StabImporter implements Product.Importer {


    private String article;
    private String name;
    private MeasurementUnit unit;

    public StabImporter(String article, String name, MeasurementUnit unit) {
        this.article = article;
        this.name = name;
        this.unit = unit;
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
        return "";
    }

    @Override
    public String description() {
        return "";
    }

    @Override
    public String smallImage() {
        return "";
    }

    @Override
    public String image() {
        return "";
    }

    @Override
    public MeasurementUnit unit() {
        return unit;
    }

    @Override
    public Map<String, Double> prices() {
        HashMap<String, Double> prices = new HashMap<>();
        prices.put("Base", 0.0);
        return prices;
    }
}
