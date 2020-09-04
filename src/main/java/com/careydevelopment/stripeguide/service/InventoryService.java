package com.careydevelopment.stripeguide.service;

import java.util.ArrayList;
import java.util.List;

import javax.money.CurrencyUnit;
import javax.money.Monetary;

import org.javamoney.moneta.Money;
import org.springframework.stereotype.Service;

import com.careydevelopment.stripeguide.model.Product;

@Service
public class InventoryService {
    
    private CurrencyUnit usd = Monetary.getCurrency("USD");

    public List<Product> getInventory() {
        List<Product> inventory = new ArrayList<Product>();

        Product bigMonsterShirt = new Product();
        bigMonsterShirt.setName("Big Monster T-Shirt");
        bigMonsterShirt.setPrice(Money.of(22.99, usd));
        
        Product superSquirtGun = new Product();
        superSquirtGun.setName("Super Squirt Gun");
        superSquirtGun.setPrice(Money.of(33.75, usd));
        
        inventory.add(bigMonsterShirt);
        inventory.add(superSquirtGun);
        
        return inventory;
        
    }
}
