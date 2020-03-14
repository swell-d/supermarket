package com.supermarket.backend.pricing.rest;

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

        String expected = "[{\"article\":\"Tomatoes\",\"name\":\"Tomatoes\",\"shortDescription\":\"Tasty tomatoes from sunny Spain\",\"description\":\"The tomato is the edible, often red, berry of the plant Solanum lycopersicum, commonly known as a tomato plant. The species originated in western South America and Central America. The Nahuatl (Aztec language) word tomatl gave rise to the Spanish word tomate, from which the English word tomato derived. Its domestication and use as a cultivated food may have originated with the indigenous peoples of Mexico. The Aztecs used tomatoes in their cooking at the time of the Spanish conquest of the Aztec Empire, and after the Spanish encountered the tomato for the first time after their contact with the Aztecs, they brought the plant to Europe. From there, the tomato was introduced to other parts of the European-colonized world during the 16th century.\",\"smallImage\":\"https:\\/\\/upload.wikimedia.org\\/wikipedia\\/commons\\/thumb\\/5\\/50\\/%E0%B0%9F%E0%B0%AE%E0%B0%BE%E0%B0%9F%E0%B0%BE%E0%B0%B2%E0%B1%81_%282%29.jpg\\/1920px-%E0%B0%9F%E0%B0%AE%E0%B0%BE%E0%B0%9F%E0%B0%BE%E0%B0%B2%E0%B1%81_%282%29.jpg\",\"image\":\"https:\\/\\/upload.wikimedia.org\\/wikipedia\\/commons\\/thumb\\/5\\/50\\/%E0%B0%9F%E0%B0%AE%E0%B0%BE%E0%B0%9F%E0%B0%BE%E0%B0%B2%E0%B1%81_%282%29.jpg\\/1920px-%E0%B0%9F%E0%B0%AE%E0%B0%BE%E0%B0%9F%E0%B0%BE%E0%B0%B2%E0%B1%81_%282%29.jpg\",\"unit\":\"Kilo\",\"price\":99.0}, {\"article\":\"Potatoes\",\"name\":\"Potatoes\",\"shortDescription\":\"Young potatoes from the fields of Germany\",\"description\":\"The potato is a root vegetable native to the Americas, a starchy tuber of the plant Solanum tuberosum, and the plant itself, a perennial in the family Solanaceae.[2]\\n\\nWild potato species can be found throughout the Americas, from the United States to southern Chile.[3] The potato was originally believed to have been domesticated by indigenous peoples of the Americas independently in multiple locations,[4] but later genetic testing of the wide variety of cultivars and wild species traced a single origin for potatoes. In the area of present-day southern Peru and extreme northwestern Bolivia, from a species in the Solanum brevicaule complex, potatoes were domesticated approximately 7,000\\u201310,000 years ago.[5][6][7] In the Andes region of South America, where the species is indigenous, some close relatives of the potato are cultivated.\",\"smallImage\":\"https:\\/\\/upload.wikimedia.org\\/wikipedia\\/commons\\/thumb\\/a\\/ab\\/Patates.jpg\\/220px-Patates.jpg\",\"image\":\"https:\\/\\/upload.wikimedia.org\\/wikipedia\\/commons\\/thumb\\/a\\/ab\\/Patates.jpg\\/220px-Patates.jpg\",\"unit\":\"Kilo\",\"price\":66.0}, {\"article\":\"Phone\",\"name\":\"Phone\",\"shortDescription\":\"Apple iPhone 11 Pro Max\",\"description\":\"1. iPhone 11 Pro pricing is after trade-in of iPhone X 64GB. Trade-in values vary based on the condition, year and configuration of your trade-in device. You must be at least 18 years old. Additional terms from Apple or Apple\\u2019s trade-in partner may apply. Monthly pricing requires a 24-month instalment loan with 0% APR from Barclays Partner Finance (a trading name of Clydesdale Financial Services Limited, a wholly owned subsidiary of Barclays Bank PLC) and £20 upfront payment. Subject to application and status. Full terms apply.\\n\\nRepresentative example: £1,049 purchase, less £250 trade-in credit and £20 upfront payment. Total amount of credit £779 paid over 24 months as 23 monthly payments of £32.99 and a final payment of £20.23 at 0% p.a. Total cost of credit £0.\",\"smallImage\":\"https:\\/\\/images-na.ssl-images-amazon.com\\/images\\/I\\/81HSzsIkJdL._AC_SL1500_.jpg\",\"image\":\"https:\\/\\/images-na.ssl-images-amazon.com\\/images\\/I\\/81HSzsIkJdL._AC_SL1500_.jpg\",\"unit\":\"Each\",\"price\":999.9}, {\"article\":\"Bag\",\"name\":\"Bag\",\"shortDescription\":\"Louis Vuitton Onthego\",\"description\":\"The name says it all: Onthego MM takes care of business or shopping with plenty of room for a busy woman\\u2019s essentials. With classic Monogram canvas on one side and Monogram Reverse on the other, it is virtually two bags in one. Twin Toron top handles and two shoulder straps offer several different carry styles for extra versatility.\",\"smallImage\":\"https:\\/\\/de.louisvuitton.com\\/images\\/is\\/image\\/lv\\/1\\/PP_VP_L\\/louis-vuitton--M44576_PM2_Front%20view.png\",\"image\":\"https:\\/\\/de.louisvuitton.com\\/images\\/is\\/image\\/lv\\/1\\/PP_VP_L\\/louis-vuitton--M44576_PM2_Front%20view.png\",\"unit\":\"Each\",\"price\":9.0}]";

        this.mockMvc.perform(get("/catalog"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(expected)));
    }

}
