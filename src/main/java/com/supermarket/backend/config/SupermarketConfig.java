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

    CartRepository cartRepository = new InMemoryCartRepository();
    PriceList priceList = new MockPriceListFactory().createMockPriceList();

    @Bean
    public PriceList priceList() {
        return priceList;
    }

    @Bean
    public CartRepository cartRepository() {
        return cartRepository;
    }

    @Bean
    public AddProductAction addProductAction() {
        return new AddProductAction(cartRepository, priceList);
    }

    @Bean
    public ClearCartAction clearCartAction() {
        return new ClearCartAction(cartRepository, priceList);
    }

    @Bean
    public GetReceiptAction getReceiptAction() {
        return new GetReceiptAction(cartRepository, priceList);
    }

    @Bean
    public GetCatalogAction getCatalogAction() {
        return new GetCatalogAction(priceList);
    }
}
