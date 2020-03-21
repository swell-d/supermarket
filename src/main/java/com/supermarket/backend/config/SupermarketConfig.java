package com.supermarket.backend.config;

import com.supermarket.backend.cart.actions.AddProductAction;
import com.supermarket.backend.cart.actions.ClearCartAction;
import com.supermarket.backend.cart.actions.GetReceiptAction;
import com.supermarket.backend.cartrepository.CartRepository;
import com.supermarket.backend.cartrepository.db.memory.InMemoryCartRepository;
import com.supermarket.backend.pricing.PriceList;
import com.supermarket.backend.pricing.actions.GetCatalogAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SupermarketConfig {

    @Bean
    public PriceList priceList() {
        return new MockPriceListFactory().createMockPriceList();
    }

    @Bean
    public CartRepository cartRepository() {
        return new InMemoryCartRepository();
    }

    @Bean
    public AddProductAction addProductAction(PriceList priceList, CartRepository cartRepository) {
        return new AddProductAction(cartRepository, priceList);
    }

    @Bean
    public ClearCartAction clearCartAction(PriceList priceList, CartRepository cartRepository) {
        return new ClearCartAction(cartRepository, priceList);
    }

    @Bean
    public GetReceiptAction getReceiptAction(PriceList priceList, CartRepository cartRepository) {
        return new GetReceiptAction(cartRepository, priceList);
    }

    @Bean
    public GetCatalogAction getCatalogAction(PriceList priceList) {
        return new GetCatalogAction(priceList);
    }
}
