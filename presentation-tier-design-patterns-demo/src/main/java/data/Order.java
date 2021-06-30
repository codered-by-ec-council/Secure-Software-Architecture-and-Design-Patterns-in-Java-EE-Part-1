/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dell
 */
public class Order {
    Map<Pizza, Integer> items = new HashMap<>();

    public Map<Pizza, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Pizza, Integer> items) {
        this.items = items;
    }
    
    public void add(Pizza item, Integer quantity) {
        Integer orderedQty = 0;
        if (this.items.containsKey(item)) {
            orderedQty = this.items.get(item);
        }
        this.items.put(item, quantity + orderedQty);
    }
}
