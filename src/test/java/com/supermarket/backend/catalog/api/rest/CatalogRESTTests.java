package com.supermarket.backend.catalog.api.rest;

import com.supermarket.backend.catalog.domain.Catalog;
import com.supermarket.backend.mock.MockCatalogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CatalogRESTTests {

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
    public void getCatalogTest() throws Exception {
        this.mockMvc.perform(get("/catalog")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getProductFromCatalogTest() throws Exception {
        this.mockMvc.perform(get("/catalog/Tomatoes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void addProductToCatalogTest() throws Exception {
        String requestJson = "{\"article\": \"test article\", \"name\": \"test name\", \"unit\": \"Kilo\"}";

        this.mockMvc.perform(post("/catalog")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("test article")));
    }

    @Test
    public void changeProductInCatalogTest() throws Exception {
        // Todo
    }

    @Test
    public void deleteProductFromCatalogTest() throws Exception {
        this.mockMvc.perform(delete("/catalog/Phone")
                .contentType(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("OK")));
    }

    @Test
    public void deleteNonExistProductFromCatalogTest() throws Exception {
        this.mockMvc.perform(delete("/catalog/NonExistProduct")
                .contentType(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Product not exist")));
    }

}
