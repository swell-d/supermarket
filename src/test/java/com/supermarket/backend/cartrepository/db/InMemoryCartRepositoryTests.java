package com.supermarket.backend.cartrepository.db;

import com.supermarket.backend.cartrepository.db.memory.InMemoryCartRepository;
import org.junit.jupiter.api.Test;

import static com.supermarket.backend.cartrepository.db.CartRepositoryTests.*;

public class InMemoryCartRepositoryTests {

    @Test
    public void hashMapCartRepositoryTests() {
        createCartRepositoryTest(new InMemoryCartRepository());
        createCartTest(new InMemoryCartRepository());
        getCartByUserNameTest(new InMemoryCartRepository());
    }

}
