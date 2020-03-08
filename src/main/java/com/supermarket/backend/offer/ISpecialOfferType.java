package com.supermarket.backend.offer;

import com.supermarket.backend.cart.domain.Receipt;
import com.supermarket.backend.pricing.PriceList;

public interface ISpecialOfferType {

    void addDiscountToReceipt(Receipt receipt, Bundle bundle, double fullSets, PriceList priceList);

}
