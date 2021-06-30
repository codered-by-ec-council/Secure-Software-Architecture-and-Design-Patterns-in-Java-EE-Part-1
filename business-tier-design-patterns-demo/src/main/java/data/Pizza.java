/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.logging.Logger;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author dell
 */
public class Pizza {
    
    private static final Logger logger = Logger.getLogger("data.Pizza");
    
    private String code;
    private String category;
    private String name;
    private String topping;
    private String size;
    private Double price;
    private String availability;

    public Pizza() {
    }

    public Pizza(String code, String category, String name, String topping, String size, Double price) {
        this.code = code;
        this.category = category;
        this.name = name;
        this.topping = topping;
        this.price = price;
        this.size = size;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAvailability() {
         try {
            Client client = ClientBuilder.newClient();
            String targetURL = "http://localhost:8080/integration-tier-design-patterns-demo/webapi/retailresource/" + this.code;
            WebTarget target = client.target(targetURL); 
            String response = target.request().get(String.class);
            System.out.println("############################### " + response);
            availability = response;
        } catch (IllegalArgumentException | NullPointerException | WebApplicationException ex) {
            logger.severe("processing of HTTP response failed");
        }
         
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
    
    
}
