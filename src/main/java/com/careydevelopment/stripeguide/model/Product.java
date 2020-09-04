package com.careydevelopment.stripeguide.model;

import java.math.BigDecimal;

import org.javamoney.moneta.Money;

import com.careydevelopment.stripeguide.util.CurrencyUtil;

public class Product {

    private String name;
    private Money price;
    private BigDecimal priceValue;
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Money getPrice() {
        return Money.of(priceValue, CurrencyUtil.USD);
    }
    public BigDecimal getPriceValue() {
        return priceValue;
    }
    public void setPriceValue(BigDecimal priceValue) {
        this.priceValue = priceValue;
    }
}
