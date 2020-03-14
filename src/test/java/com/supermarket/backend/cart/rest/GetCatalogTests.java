package com.supermarket.backend.cart.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GetCatalogTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCatalogTest() throws Exception {

        String expected = "[{\"article\":\"tomatoes\",\"name\":\"tomatoes\",\"shortDescription\":null,\"description\":null,\"smallImage\":null,\"image\":null,\"unit\":\"Kilo\",\"price\":99.0}, {\"article\":\"potatoes\",\"name\":\"potatoes\",\"shortDescription\":null,\"description\":null,\"smallImage\":null,\"image\":null,\"unit\":\"Kilo\",\"price\":66.0}, {\"article\":\"phone\",\"name\":\"phone\",\"shortDescription\":null,\"description\":null,\"smallImage\":null,\"image\":null,\"unit\":\"Each\",\"price\":999.9}, {\"article\":\"bag\",\"name\":\"bag\",\"shortDescription\":null,\"description\":null,\"smallImage\":null,\"image\":null,\"unit\":\"Each\",\"price\":9.0}]";

        this.mockMvc.perform(get("/catalog"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(expected)));
    }

}
