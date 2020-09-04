package com.careydevelopment.stripeguide.model;

import java.util.List;

public class Order {

    private List<LineItem> lineItems;

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }
}
