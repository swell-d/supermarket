package com.supermarket.backend.customer.db.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoCustomerRepository extends MongoRepository<MongoCustomer, String> {

    public MongoCustomer findByEmail(String email);

}
