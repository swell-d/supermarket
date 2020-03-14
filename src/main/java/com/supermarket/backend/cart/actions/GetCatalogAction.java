package com.supermarket.backend.cart.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supermarket.backend.catalog.Product;
import com.supermarket.backend.pricing.PriceList;
import org.json.simple.JSONValue;

import java.util.Map;

public class GetCatalogAction {
    public static String getCatalog(PriceList priceList) {
        StringBuilder result = new StringBuilder("[");

        ObjectMapper oMapper = new ObjectMapper();

        for (Map.Entry<Product, Double> entry : priceList.getPriceList().entrySet()) {
            Map<String, Object> map = oMapper.convertValue(entry.getKey(), Map.class);
            map.put("price", entry.getValue());
            result.append(JSONValue.toJSONString(map));
            result.append(", ");
        }
        return result.substring(0, result.length() - 2) + "]";
    }
}
