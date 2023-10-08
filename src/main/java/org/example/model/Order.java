package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
public class Order {

     @Getter @Setter private int orderNumber;
    @Getter @Setter private List<Pizza> orderedPizzaList;
    @Getter @Setter private double price;
    public Order(int orderNumber, List<Pizza> orderedPizzaList, double price) {
        this.orderNumber = orderNumber;
        this.orderedPizzaList = orderedPizzaList;
        this.price = price;
    }
}
