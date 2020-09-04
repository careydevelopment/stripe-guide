package com.careydevelopment.stripeguide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentFormController {

    @GetMapping("/payment")
    public String payment() {
        return "payment";
    }
}
