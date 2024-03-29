package com.supermarket.backend.catalog.db.mongo;

import com.supermarket.backend.catalog.domain.AddProductRequest;
import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.catalog.domain.Product;

import java.util.ArrayList;

public class MongoCatalogAdapter implements Catalog {

    MongoProductRepository mongoCatalog;

    public MongoCatalogAdapter(MongoProductRepository mongoCatalog) {
        this.mongoCatalog = mongoCatalog;
    }

    @Override
    public void add(Product.Importer importer) {
        if (mongoCatalog.findByArticle(importer.article()) != null)
            throw new IllegalStateException("Product already exist");
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
    public void edit(Product.Importer importer) {
        MongoProduct mongoProduct = mongoCatalog.findByArticle(importer.article());
        if (mongoProduct == null) throw new IllegalStateException("Product not exist");
        mongoProduct.article = importer.article();
        mongoProduct.name = importer.name();
        mongoProduct.shortDescription = importer.shortDescription();
        mongoProduct.description = importer.description();
        mongoProduct.smallImage = importer.smallImage();
        mongoProduct.image = importer.image();
        mongoProduct.unit = importer.unit();
        mongoProduct.prices = importer.prices();

        mongoCatalog.save(mongoProduct);
    }

    @Override
    public void delete(String article) {
        MongoProduct mongoProduct = mongoCatalog.findByArticle(article);
        if (mongoProduct == null) throw new IllegalStateException("Product not exist");
        mongoCatalog.delete(mongoProduct);
    }

    @Override
    public Product byArticle(String article) {
        MongoProduct mongoProduct = mongoCatalog.findByArticle(article);
        return new Product(createImporter(mongoProduct));
    }

    @Override
    public ArrayList<Product.Importer> getProducts() {
        ArrayList<Product.Importer> result = new ArrayList<>();
        for (MongoProduct mongoProduct : mongoCatalog.findAll()) {
            result.add(createImporter(mongoProduct));
        }
        return result;
    }

    @Override
    public boolean productExists(String article) {
        return mongoCatalog.findByArticle(article) != null;
    }

    private AddProductRequest createImporter(MongoProduct mongoProduct) {
        AddProductRequest importer = new AddProductRequest();
        importer.article = mongoProduct.article;
        importer.name = mongoProduct.name;
        importer.shortDescription = mongoProduct.shortDescription;
        importer.description = mongoProduct.description;
        importer.smallImage = mongoProduct.smallImage;
        importer.image = mongoProduct.image;
        importer.unit = mongoProduct.unit;
        importer.prices = mongoProduct.prices;
        return importer;
    }

}
