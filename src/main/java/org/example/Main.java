package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.model.Pizza;
import org.example.service.PizzaService;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        // wpisz dostępne pizze
        // utwurz 3 zamowienia
        // karzy ma numer rosnacy od 1
        Pizza availablePizza1 = new Pizza("Margaritta", true, 10.00d);
        Pizza availablePizza2 = new Pizza("Margaritta z dodatkowym serem", true, 12.00d);
        Pizza unAvailablePizza3 = new Pizza("Margaritta z maksymalnym serem", false, 15.00d);

        PizzaService pizzaService = new PizzaService(List.of(availablePizza1,availablePizza2,unAvailablePizza3));

        pizzaService.makeOrder(List.of(availablePizza1));
        pizzaService.makeOrder(List.of(availablePizza2));
        pizzaService.makeOrder(List.of(availablePizza1, availablePizza2));

        try {
            pizzaService.makeOrder(List.of(unAvailablePizza3));
        } catch (Exception e) {
            logger.info(e);
        }
    }
}