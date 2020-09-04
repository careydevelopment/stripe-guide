package com.careydevelopment.stripeguide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.careydevelopment.stripeguide.model.Order;
import com.careydevelopment.stripeguide.service.OrderFormService;

@Controller
public class OrderFormController {

    @Autowired
    private OrderFormService orderFormService;
    
    public String orderForm(Model model) {
        Order order = orderFormService.getEmptyOrder();
        model.addAttribute("order", order);
        
        return "orderForm";
    }
    
}
