/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class Cache {
    private List<BusinessService> services;

   public Cache(){
      services = new ArrayList<BusinessService>();
   }

   public BusinessService getService(String serviceName){
   
      for (BusinessService service : services) {
         if(service.getName().equalsIgnoreCase(serviceName)){
            System.out.println("Returning cached  " + serviceName + " service object");
            return service;
         }
      }
      return null;
   }

   public void addService(BusinessService newService){
      boolean exists = false;
      
      for (BusinessService service : services) {
         if(service.getName().equalsIgnoreCase(newService.getName())){
            exists = true;
         }
      }
      if(!exists){
         services.add(newService);
      }
   }
}
