package com.supermarket.backend.catalog.db.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoProductRepository extends MongoRepository<MongoProduct, String> {

    MongoProduct findByArticle(String article);

}
