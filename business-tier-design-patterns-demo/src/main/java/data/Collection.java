/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author dell
 */
public class Collection {
    
    List<Pizza> pizzas = new ArrayList<>();

    public Collection() {
        pizzas.add(new Pizza("P001","Vegitarian","Tomato & Onion","Chese","Large", 1500.0));
        pizzas.add(new Pizza("P002","Chicken","Spicy Chicken","Sauce","Medium", 1000.0));
        pizzas.add(new Pizza("P003","Bacon","Spicy Bacon","Sauce","Large", 1800.0));
        pizzas.add(new Pizza("P004","Sausage","Cheesy Sausage","Chese","Medium", 1400.0));
        pizzas.add(new Pizza("P005","Vegitarian","Cheesy Tomato & Onion","Chese","Small", 600.0));
        pizzas.add(new Pizza("P006","Bacon","Cheesy Bacon","Chese","Small", 800.0));
    }
    
    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
        
    public Pizza get(String code) {
        return this.pizzas.stream()
          .filter(pizza -> pizza.getCode().equalsIgnoreCase(code))
          .findFirst()
          .orElse(null);
    }

    public List<Pizza> find(String criteria) {
         return this.pizzas.stream()
          .filter(pizza -> pizza.getCategory().toLowerCase().contains(criteria.toLowerCase())
            || pizza.getName().toLowerCase().contains(criteria.toLowerCase())
            || pizza.getTopping().toLowerCase().contains(criteria.toLowerCase()))
          .collect(Collectors.toList());
    }
}
