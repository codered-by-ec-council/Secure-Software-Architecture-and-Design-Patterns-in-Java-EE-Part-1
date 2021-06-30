/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.BaseTO;

/**
 *
 * @author dell
 */
public class BusinessDelegate {
    
   //private final Lookup lookup = new Lookup();
   private BusinessService businessService;
   private String serviceType;

   public void setServiceType(String serviceType){
      this.serviceType = serviceType;
   }

   public BaseTO doTask(BaseTO tObj){
      //businessService = lookup.getBusinessService(serviceType);
      businessService = ServiceLocator.getService(serviceType);
      return businessService.doProcessing(tObj);		
   }
}
