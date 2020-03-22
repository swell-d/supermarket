package com.supermarket.backend.cartrepository.db;

import com.supermarket.backend.cart.domain.CartRepository;
import com.supermarket.backend.cart.domain.ShoppingCart;
import com.supermarket.backend.config.MockPriceListFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class CartRepositoryTests {

    public static void createCartRepository(CartRepository cartRepository) {
        assertNotNull(cartRepository);
        assertEquals(0, cartRepository.getSize());
    }

    public static void createCart(CartRepository cartRepository) {
        ShoppingCart newCart = cartRepository.getCart("test name 1", new MockPriceListFactory().createMockPriceList());
        assertNotNull(newCart);
        assertEquals(1, cartRepository.getSize());
    }

    public static void getCartByUserName(CartRepository cartRepository) {
        ShoppingCart newCart1 = cartRepository.getCart("test name 1", new MockPriceListFactory().createMockPriceList());
        ShoppingCart newCart2 = cartRepository.getCart("test name 2", new MockPriceListFactory().createMockPriceList());
        assertEquals(2, cartRepository.getSize());
        assertEquals(newCart1, cartRepository.getCart("test name 1", new MockPriceListFactory().createMockPriceList()));
        assertEquals(newCart2, cartRepository.getCart("test name 2", new MockPriceListFactory().createMockPriceList()));
    }

}