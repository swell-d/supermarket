package com.supermarket.backend.catalog.actions;

import com.supermarket.backend.catalog.domain.MeasurementUnit;

public class StabImporterBuilder {
    private String article = "defaultArticle";
    private String name = "defaultName";
    private MeasurementUnit unit = MeasurementUnit.Kilo;


    public static StabImporterBuilder importerBuilder(){
        return new StabImporterBuilder();
    }


    public StabImporterBuilder withArticle(String article) {
        this.article = article;
        return this;
    }

    public StabImporterBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public StabImporterBuilder withMesUnit(MeasurementUnit unit) {
        this.unit = unit;
        return this;
    }

    public StabImporter create() {
        return new StabImporter(article, name, unit);
    }
}