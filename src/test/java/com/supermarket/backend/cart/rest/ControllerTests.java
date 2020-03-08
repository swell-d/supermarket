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
public class ControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testNonexistentProduct() throws Exception {
        this.mockMvc.perform(get("/addProduct")
                .param("productName", "product3")
                .param("productCount", "42"))
                .andDo(print())
                .andExpect(status().isOk())  // Todo return 404 ? to be discussed
                .andExpect(content().string(containsString("product3 not found.")));
    }

    @Test
    public void testAddTwoProductsToCart() throws Exception {
        this.mockMvc.perform(get("/addProduct")
                .param("productName", "tomatoes")
                .param("productCount", "42"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("tomatoes added.")));

        this.mockMvc.perform(get("/addProduct")
                .param("productName", "potatoes")
                .param("productCount", "24"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("potatoes added.")));

        this.mockMvc.perform(get("/receipt"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("tomatoes")))
                .andExpect(content().string(containsString("42.00")))
                .andExpect(content().string(containsString("potatoes")))
                .andExpect(content().string(containsString("24.00")))
                .andExpect(content().string(containsString("66.00")));
    }

    @Test
    public void testClearCart() throws Exception {
        this.mockMvc.perform(get("/addProduct")
                .param("productName", "tomatoes")
                .param("productCount", "42"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("tomatoes added.")));

        this.mockMvc.perform(get("/clearCart"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Cart cleared.")));

        this.mockMvc.perform(get("/receipt"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("0.00")));
    }
}
