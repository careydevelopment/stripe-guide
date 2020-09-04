package com.careydevelopment.stripeguide.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.careydevelopment.stripeguide.model.CreatePaymentResponse;
import com.careydevelopment.stripeguide.model.Order;
import com.careydevelopment.stripeguide.service.OrderFormService;
import com.careydevelopment.stripeguide.util.OrderUtil;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@Controller
public class OrderFormController {

    @Autowired
    private OrderFormService orderFormService;

    @Value("${stripe.secret.key}") 
    private String stripeSecretKey;
 
    
    @GetMapping("/orderForm")
    public String orderForm(Model model) {
        Order order = orderFormService.getEmptyOrder();
        model.addAttribute("order", order);
        
        return "orderForm";
    }
    
    
    @PostMapping("/orderForm")
    public String processOrder(Order order, Model model) {
        Stripe.apiKey = stripeSecretKey;

        Long totalAmount = OrderUtil.calculateOrderAmountInCents(order);
        model.addAttribute("totalAmount", totalAmount);
        
        try {
            PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
                    .setCurrency("usd")
                    .setAmount(totalAmount)
                    .build();
            
            PaymentIntent intent = PaymentIntent.create(createParams);
            CreatePaymentResponse paymentResponse = new CreatePaymentResponse(intent.getClientSecret());
            
            model.addAttribute("paymentResponse", paymentResponse);
        } catch (StripeException se) {
            se.printStackTrace();
        }
        
        return "payment";
    }
}