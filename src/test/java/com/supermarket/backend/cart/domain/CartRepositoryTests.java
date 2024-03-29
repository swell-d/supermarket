package com.supermarket.backend.cart.domain;

import com.supermarket.backend.mock.MockCatalogFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class CartRepositoryTests {

    public static void createCartRepository(CartRepository cartRepository) {
        assertNotNull(cartRepository);
        assertEquals(0, cartRepository.getSize());
    }

    public static void createCart(CartRepository cartRepository) {
        ShoppingCart newCart = cartRepository.getCart("test name 1", new MockCatalogFactory().createMockCatalog());
        assertNotNull(newCart);
        assertEquals(1, cartRepository.getSize());
    }

    public static void getCartByUserName(CartRepository cartRepository) {
        ShoppingCart newCart1 = cartRepository.getCart("test name 1", new MockCatalogFactory().createMockCatalog());
        ShoppingCart newCart2 = cartRepository.getCart("test name 2", new MockCatalogFactory().createMockCatalog());
        assertEquals(2, cartRepository.getSize());
        assertEquals(newCart1, cartRepository.getCart("test name 1", new MockCatalogFactory().createMockCatalog()));
        assertEquals(newCart2, cartRepository.getCart("test name 2", new MockCatalogFactory().createMockCatalog()));
    }

}
