package com.supermarket.backend.customer.db.mongo;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class MongoCustomer {

    @Id
    public String id;

    public String email;
    public String firstName;
    public String lastName;

    public MongoCustomer(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, email='%s', firstName='%s', lastName='%s']",
                id, email, firstName, lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MongoCustomer customer = (MongoCustomer) o;
        return id.equals(customer.id) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, firstName, lastName);
    }

}
