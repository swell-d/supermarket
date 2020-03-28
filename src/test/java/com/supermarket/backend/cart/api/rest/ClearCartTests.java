package com.supermarket.backend.cart.api.rest;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.mock.MockCatalogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ClearCartTests {

    @Autowired
    private MockMvc mockMvc;

    @TestConfiguration
    static class CatalogTestConfiguration {
        @Bean
        public Catalog catalog() {
            return new MockCatalogFactory().createMockCatalog();
        }
    }

    @Test
    public void clearCartTest() throws Exception {
        this.mockMvc.perform(put("/cart/addProduct")
                .param("productName", "Tomatoes")
                .param("productCount", "42"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Tomatoes added.")));

        this.mockMvc.perform(put("/cart/clearCart"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Cart cleared.")));

        this.mockMvc.perform(get("/cart/receipt"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("0.00")));
    }

}
