package com.supermarket.backend.pricing.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supermarket.backend.catalog.Product;
import com.supermarket.backend.pricing.PriceList;

import java.util.ArrayList;
import java.util.Map;

public class GetCatalogAction {

    private PriceList priceList;

    public GetCatalogAction(PriceList priceList) {
        this.priceList = priceList;
    }

    public ArrayList<Map<String, String>> getCatalog() {
        ArrayList<Map<String, String>> result = new ArrayList<>();
        ObjectMapper oMapper = new ObjectMapper();

        for (Map.Entry<Product, Double> entry : priceList.getPriceList().entrySet()) {
            Map<String, String> map = oMapper.convertValue(entry.getKey(), Map.class);
            map.put("price", entry.getValue().toString());
            result.add(map);
        }
        return result;
    }
}
