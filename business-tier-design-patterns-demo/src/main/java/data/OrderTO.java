/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author dell
 */
public class OrderTO extends BaseTO {
    
    private Order order;
    private String code;
    private Integer quantity;

    public OrderTO(Order order, String code, Integer quantity, Collection collection) {
        super(collection);
        this.order = order;
        this.code = code;
        this.quantity = quantity;
    }
    
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
   
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
