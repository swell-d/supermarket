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

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class GetCatalogTests {

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
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

}
