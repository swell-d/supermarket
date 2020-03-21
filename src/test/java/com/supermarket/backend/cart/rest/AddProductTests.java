package com.supermarket.backend.cart.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AddProductTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void noneExistentProductTest() throws Exception {
        this.mockMvc.perform(put("/addProduct")
                .param("productName", "product3")
                .param("productCount", "42"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("product3 not found.")));
    }

    @Test
    public void addTwoProductsToCartTest() throws Exception {
        this.mockMvc.perform(put("/addProduct")
                .param("productName", "Tomatoes")
                .param("productCount", "42"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Tomatoes added.")));

        this.mockMvc.perform(put("/addProduct")
                .param("productName", "Potatoes")
                .param("productCount", "24"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Potatoes added.")));
    }

}
