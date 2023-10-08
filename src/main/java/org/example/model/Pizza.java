package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Pizza {
    @Getter @Setter private String name;
    @Getter @Setter private Boolean isAvailable;
    @Getter @Setter private double price;

    public Pizza(String name, Boolean isAvailable, double price) {
        this.name = name;
        this.isAvailable = isAvailable;
        this.price = price;
    }
}
