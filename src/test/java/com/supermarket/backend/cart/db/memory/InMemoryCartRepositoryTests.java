package com.supermarket.backend.cart.db.memory;

import com.supermarket.backend.cart.domain.CartRepositoryTests;
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
