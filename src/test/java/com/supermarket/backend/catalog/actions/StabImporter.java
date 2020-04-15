package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.MeasurementUnit;
import com.supermarket.backend.catalog.domain.Product;

import java.util.HashMap;
import java.util.Map;

class StabImporter implements Product.Importer {


    @Override
    public String article() {
        return "test article 1";
    }

    @Override
    public String name() {
        return "test name 1";
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
        return MeasurementUnit.Each;
    }

    @Override
    public Map<String, Double> prices() {
        HashMap<String, Double> prices = new HashMap<>();
        prices.put("Base", 0.0);
        return prices;
    }
}
