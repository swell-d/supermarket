package com.supermarket.backend.cartrepository.db;

import com.supermarket.backend.cartrepository.db.hashmap.HashMapCartRepository;
import org.junit.jupiter.api.Test;

import static com.supermarket.backend.cartrepository.db.CartRepositoryTests.*;

public class HashMapCartRepositoryTests {

    @Test
    public void hashMapCartRepositoryTests() {
        createCartRepositoryTest(new HashMapCartRepository());
        createCartTest(new HashMapCartRepository());
        getCartByUserNameTest(new HashMapCartRepository());
    }

}
