/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import ejb.AvailabilityService;
import entity.Availability;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author dell
 */
@Path("retailresource")
@RequestScoped
public class RetailResource {

    @Context
    private UriInfo context;
    
    @EJB
    private AvailabilityService availabilityService;

    /**
     * Creates a new instance of RetailResource
     */
    public RetailResource() {
    }

    @GET
    @Path("{param1}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getText(@PathParam("param1") String param1) {
        
        List<Availability> results = availabilityService.getItemAvailability(param1);
        
        return (results != null && results.size() > 0) ? "Available" : "Not Available";
    }

}
