package com.supermarket.backend.customer.db.mongo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MongoCustomerTests {

    @Autowired
    private MongoCustomerRepository mongoCustomer;

    @Test
    public void createCustomerTest() throws Exception {

        MongoCustomer alice = new MongoCustomer("123@gmail.com", "Alice", "Smith");
        MongoCustomer bob = new MongoCustomer("234@gmail.com", "Bob", "Smith");

        mongoCustomer.deleteAll();
        mongoCustomer.save(alice);
        mongoCustomer.save(bob);

        assertEquals(alice, mongoCustomer.findByEmail("123@gmail.com"));
        assertEquals(bob, mongoCustomer.findByEmail("234@gmail.com"));

    }

}
