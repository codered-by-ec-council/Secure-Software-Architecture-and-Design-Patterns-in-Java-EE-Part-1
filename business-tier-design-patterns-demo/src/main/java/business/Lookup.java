/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author dell
 */
public class Lookup {
    public BusinessService getBusinessService(String serviceType){
        switch(serviceType) {
            case "Order":
                return new OrderService();
            case "Search":
                return new SearchService();
        }
        
        return null;
    }
}
