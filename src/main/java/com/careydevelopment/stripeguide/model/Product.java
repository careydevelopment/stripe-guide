package com.careydevelopment.stripeguide.model;

import org.javamoney.moneta.Money;

public class Product {

    private String name;
    private Money price;
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Money getPrice() {
        return price;
    }
    public void setPrice(Money price) {
        this.price = price;
    }
    
    
}
