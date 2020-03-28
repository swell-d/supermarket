package com.supermarket.backend.catalog.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supermarket.backend.catalog.Catalog;
import com.supermarket.backend.catalog.PriceType;
import com.supermarket.backend.catalog.Product;

import java.util.ArrayList;
import java.util.Map;

public class GetCatalogAction {

    private Catalog catalog;

    public GetCatalogAction(Catalog catalog) {
        this.catalog = catalog;
    }

    public ArrayList<Map<String, String>> getCatalog() {
        ArrayList<Map<String, String>> result = new ArrayList<>();
        ObjectMapper oMapper = new ObjectMapper();

        for (Product entry : catalog.getCatalog()) {
            Map<String, String> map = oMapper.convertValue(entry, Map.class);
            map.put("price", entry.prices.get(PriceType.Base).toString());
            result.add(map);
        }
        return result;
    }
}
