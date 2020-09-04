package com.careydevelopment.stripeguide.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careydevelopment.stripeguide.model.LineItem;
import com.careydevelopment.stripeguide.model.Order;
import com.careydevelopment.stripeguide.model.Product;

@Service
public class OrderFormService {

    @Autowired
    private InventoryService inventoryService;
    
    
    public Order getEmptyOrder() {
        Order order = new Order();
        
        List<LineItem> lineItems = new ArrayList<LineItem>();
        
        List<Product> products = inventoryService.getInventory();
        products.forEach(product -> {
            LineItem lineItem = new LineItem();
            lineItem.setProduct(product);
            lineItem.setQuantity(0);
            
            lineItems.add(lineItem);
        });
        
        order.setLineItems(lineItems);
        
        return order;
    }
}

