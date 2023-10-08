package org.example.service;

import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Main;
import org.example.exceptions.PizzaNotFoundException;
import org.example.model.Order;
import org.example.model.Pizza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ToString
public class PizzaService {

    private static final Logger logger = LogManager.getLogger(PizzaService.class);
    private List<Pizza> pizzaList;
    private List<Order> orderList = new ArrayList<>();

    public PizzaService(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public Order makeOrder(List<Pizza> orderedPizzaList) throws PizzaNotFoundException {
        logger.info("running makeOrder");
        List<Pizza> availablePizzaList = this.getAvailablePizzas();
        if (availablePizzaList.containsAll(orderedPizzaList)) {
            Order newOrder;
            newOrder = new Order(orderList.size() + 1,
                    orderedPizzaList,
                    orderedPizzaList.stream()
                            .mapToDouble(Pizza::getPrice)
                            .reduce(0, Double::sum)
            );
            orderList.add(newOrder);
            return newOrder;
        } else {
            throw new PizzaNotFoundException("Pizza not on the menu");
        }
    }

    public List<Pizza> getAvailablePizzas() {
        logger.info("running getAvailablePizzas");
        return pizzaList.stream().filter(Pizza::getIsAvailable).toList();
    }
}
