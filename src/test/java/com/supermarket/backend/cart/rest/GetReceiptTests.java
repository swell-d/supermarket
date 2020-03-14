package com.supermarket.backend.cart.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GetReceiptTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getReceiptTest() throws Exception {
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

        String expected = "<div class=\"receipt\" style=\"font-family: monospace;\">Tomatoes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4158.00<br>&nbsp;&nbsp;99.00&nbsp;*&nbsp;42.000<br>Potatoes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1584.00<br>&nbsp;&nbsp;66.00&nbsp;*&nbsp;24.000<br><br>Total:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5742.00<br></div>";

        this.mockMvc.perform(get("/receipt"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(expected)));
    }

}
