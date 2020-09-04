package com.careydevelopment.stripeguide.util;

import java.math.BigDecimal;

import org.javamoney.moneta.Money;

import com.careydevelopment.stripeguide.model.LineItem;
import com.careydevelopment.stripeguide.model.Order;
import com.careydevelopment.stripeguide.model.Product;

public class OrderUtil {

    public static Long calculateOrderAmountInCents(Order order) {
        BigDecimal amount = new BigDecimal("0");

        if (order != null && order.getLineItems() != null) {
            for (LineItem lineItem : order.getLineItems()) {
                if (lineItem.getQuantity() > 0) {
                    Product product = lineItem.getProduct();
                    Money productPrice = product.getPrice();
                    Money totalCost = productPrice.multiply(lineItem.getQuantity());
                    amount = amount.add(totalCost.getNumberStripped());
                }
            };
        }
        
        amount = amount.multiply(new BigDecimal("100"));
        
        return amount.longValue();
    }
}
