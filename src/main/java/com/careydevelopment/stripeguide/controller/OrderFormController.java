package com.careydevelopment.stripeguide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.careydevelopment.stripeguide.model.Order;
import com.careydevelopment.stripeguide.service.OrderFormService;

@Controller
public class OrderFormController {

    @Autowired
    private OrderFormService orderFormService;
    
    @GetMapping("/orderForm")
    public String orderForm(Model model) {
        Order order = orderFormService.getEmptyOrder();
        model.addAttribute("order", order);
        
        return "orderForm";
    }
    
    
    @PostMapping("/orderForm")
    public String processOrder(Order order, Model model) {
        
        return "payment";
    }
}
