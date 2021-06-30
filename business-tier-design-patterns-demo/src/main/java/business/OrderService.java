/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.BaseTO;
import data.Collection;
import data.OrderTO;
import data.Pizza;
import javax.ejb.Stateless;

/**
 *
 * @author dell
 */
@Stateless
public class OrderService implements BusinessService {

    @Override
    public BaseTO doProcessing(BaseTO tObj) {
        OrderTO orderTO = (OrderTO) tObj;
        Pizza item =  orderTO.getCollection().get(orderTO.getCode());
        orderTO.getOrder().add(item, orderTO.getQuantity());
        
        return orderTO;
    }

    @Override
    public String getName() {
        return "Order";
    }
}
