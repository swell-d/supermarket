package com.supermarket.backend.cartrepository.db;

import com.supermarket.backend.cart.db.memory.InMemoryCartRepository;
import org.junit.Test;

public class InMemoryCartRepositoryTests {

    @Test
    public void createCartRepositoryTest() {
        CartRepositoryTests.createCartRepository(new InMemoryCartRepository());
    }

    @Test
    public void createCartTest() {
        CartRepositoryTests.createCart(new InMemoryCartRepository());
    }

    @Test
    public void getCartByUserNameTest() {
        CartRepositoryTests.getCartByUserName(new InMemoryCartRepository());
    }

}
