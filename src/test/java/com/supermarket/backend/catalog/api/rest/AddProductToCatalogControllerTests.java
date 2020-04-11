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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AddProductToCatalogControllerTests {

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
    public void addProductToCatalogTest() throws Exception {
        String requestJson = "{" +
                "\"article\": \"test article 1\", " +
                "\"name\": \"test name\", " +
                "\"shortDescription\": \"shortDescription\", " +
                "\"description\": \"description\", " +
                "\"smallImage\": \"https://www.google.com/\", " +
                "\"image\": \"https://www.google.com/\", " +
                "\"unit\": \"Kilo\", " +
                "\"prices\": {\"Base\": 0.0}}";

        this.mockMvc.perform(post("/catalog")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());

        this.mockMvc.perform(post("/catalog")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isConflict());
    }

    @Test
    public void articleValidateTest() throws Exception {
        String requestJson = "{\"article\": \"\", \"name\": \"test name\", \"unit\": \"Kilo\"," +
                "\"prices\": {\"Base\": 0.0}}";
        checkBadRequest(requestJson);
    }

    @Test
    public void nameValidateTest() throws Exception {
        String requestJson = "{\"article\": \"test article 2\", \"name\": \"\", \"unit\": \"Kilo\"," +
                "\"prices\": {\"Base\": 0.0}}";
        checkBadRequest(requestJson);
    }

    @Test
    public void smallImageValidateTest() throws Exception {
        String requestJson = "{\"article\": \"test article 3\", \"name\": \"test name\", \"unit\": \"Kilo\"," +
                "\"prices\": {\"Base\": 0.0}, \"smallImage\": \"https:/www.google.com/\"}";
        checkBadRequest(requestJson);
    }

    @Test
    public void imageValidateTest() throws Exception {
        String requestJson = "{\"article\": \"test article 4\", \"name\": \"test name\", \"unit\": \"Kilo\"," +
                "\"prices\": {\"Base\": 0.0}, \"image\": \"https:/www.google.com/\"}";
        checkBadRequest(requestJson);
    }

    @Test
    public void wrongPriceValidateTest() throws Exception {
        String requestJson = "{\"article\": \"test article 5\", \"name\": \"test name\", \"unit\": \"Kilo\"," +
                "\"prices\": {\"NonBase\": 1.1}}";
        checkBadRequest(requestJson);
    }

    @Test
    public void negativePriceValidateTest() throws Exception {
        String requestJson = "{\"article\": \"test article 6\", \"name\": \"test name\", \"unit\": \"Kilo\"," +
                "\"prices\": {\"Base\": -1}}";
        checkBadRequest(requestJson);
    }

    private void checkBadRequest(String requestJson) throws Exception {
        this.mockMvc.perform(post("/catalog")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}
