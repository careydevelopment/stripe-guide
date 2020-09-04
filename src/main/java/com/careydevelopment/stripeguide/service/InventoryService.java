package com.careydevelopment.stripeguide.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.careydevelopment.stripeguide.model.Product;

@Service
public class InventoryService {

    public List<Product> getInventory() {
        List<Product> inventory = new ArrayList<Product>();

        Product bigMonsterShirt = new Product();
        bigMonsterShirt.setName("Big Monster T-Shirt");
        bigMonsterShirt.setPriceValue(new BigDecimal("22.99"));
        
        Product superSquirtGun = new Product();
        superSquirtGun.setName("Super Squirt Gun");
        superSquirtGun.setPriceValue(new BigDecimal("33.75"));
        
        inventory.add(bigMonsterShirt);
        inventory.add(superSquirtGun);
        
        return inventory;
        
    }
}
