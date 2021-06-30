/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.daily.loalty.points;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author buddhini
 */
@Path("dailyLoyaltyPoints")
@RequestScoped
public class DailyLoyaltyPointsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DailyLoyaltyPointsResource
     */
    public DailyLoyaltyPointsResource() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.daily.loalty.points.DailyLoyaltyPointsResource
     * @return an instance of java.lang.Integer
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText() {
       int points; 
       
       Calendar now = GregorianCalendar.getInstance();
       
       int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
       
        switch (dayOfWeek) {
            case 2:
            case 4:
            case 6:
                points = 2;
                break;
            case 3:
            case 5:
                points = 1;
                break;
            case 1:
            case 7:
                points = 5;
                break;
            default:
                points = 0;
                break;
        }
       
       return "" + points;
    }
}
