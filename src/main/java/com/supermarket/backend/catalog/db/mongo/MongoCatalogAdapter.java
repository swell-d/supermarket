package com.supermarket.backend.catalog.db.mongo;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.MeasurementUnit;
import com.supermarket.backend.catalog.domain.Product;

import java.util.ArrayList;
import java.util.Map;

public class MongoCatalogAdapter implements Catalog {

    MongoProductRepository mongoCatalog;

    public MongoCatalogAdapter(MongoProductRepository mongoCatalog) {
        this.mongoCatalog = mongoCatalog;
    }

    @Override
    public void add(Product.Importer importer) {
        if (mongoCatalog.findByArticle(importer.article()) != null) throw new IllegalArgumentException();
        MongoProduct mongoProduct = new MongoProduct(
                importer.article(),
                importer.name(),
                importer.shortDescription(),
                importer.description(),
                importer.smallImage(),
                importer.image(),
                importer.unit(),
                importer.prices());
        mongoCatalog.save(mongoProduct);
    }

    @Override
    public void deleteProduct(String article) {
        MongoProduct mongoProduct = mongoCatalog.findByArticle(article);
        mongoCatalog.delete(mongoProduct);
    }

    @Override
    public Product byArticle(String article) {
        MongoProduct mongoProduct = mongoCatalog.findByArticle(article);
        Product.Importer importer = new Product.Importer() {
            @Override
            public String article() {
                return mongoProduct.article;
            }

            @Override
            public String name() {
                return mongoProduct.name;
            }

            @Override
            public String shortDescription() {
                return mongoProduct.shortDescription;
            }

            @Override
            public String description() {
                return mongoProduct.description;
            }

            @Override
            public String smallImage() {
                return mongoProduct.smallImage;
            }

            @Override
            public String image() {
                return mongoProduct.image;
            }

            @Override
            public MeasurementUnit unit() {
                return mongoProduct.unit;
            }

            @Override
            public Map<String, Double> prices() {
                return mongoProduct.prices;
            }
        };
        return new Product(importer);
    }

    @Override
    public ArrayList<Product> getProducts() {
        ArrayList<Product> result = new ArrayList<>();
        for (MongoProduct mongoProduct : mongoCatalog.findAll()) {
            Product.Importer importer = new Product.Importer() {
                @Override
                public String article() {
                    return mongoProduct.article;
                }

                @Override
                public String name() {
                    return mongoProduct.name;
                }

                @Override
                public String shortDescription() {
                    return mongoProduct.shortDescription;
                }

                @Override
                public String description() {
                    return mongoProduct.description;
                }

                @Override
                public String smallImage() {
                    return mongoProduct.smallImage;
                }

                @Override
                public String image() {
                    return mongoProduct.image;
                }

                @Override
                public MeasurementUnit unit() {
                    return mongoProduct.unit;
                }

                @Override
                public Map<String, Double> prices() {
                    return mongoProduct.prices;
                }
            };
            result.add(new Product(importer));
        }
        return result;
    }

    @Override
    public boolean productExists(String article) {
        return byArticle(article) != null;
    }

}
