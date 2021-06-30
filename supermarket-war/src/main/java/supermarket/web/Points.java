/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.web;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import static javax.faces.annotation.FacesConfig.Version.JSF_2_3;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import supermarket.ejb.LoyaltyPointsBean;

/**
 *
 * @author buddhini
 */
@Named
@SessionScoped
@FacesConfig(version=JSF_2_3)
public class Points implements Serializable {

    @EJB
    private LoyaltyPointsBean loyaltyPointsBean;
    protected int pointsToday;
    @NotNull
    protected Double billTotal;
    @NotNull
    protected String mobileNo;
    @NotNull
    private String redeem;
    protected Double billAfterPoints;
    protected int totalNonRedeemedPoints;

    private static final Logger logger = Logger.getLogger("supermarket.web.Points");

    public Points() {
    }

    public int getPointsToday() {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://localhost:8080/daily-loalty-points/webapi/dailyLoyaltyPoints");
            String response = target.request().get(String.class);
            System.out.println("############################### " + response);
            pointsToday = Integer.parseInt(response);
        } catch (IllegalArgumentException | NullPointerException | WebApplicationException ex) {
            logger.severe("processing of HTTP response failed");
        }
        return pointsToday;
    }

    public void setPointsToday(int pointsToday) {
        this.pointsToday = pointsToday;
    }

    public Double getBillTotal() {
        return billTotal;
    }

    public void setBillTotal(Double billTotal) {
        this.billTotal = billTotal;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getRedeem() {
        return redeem;
    }

    public void setRedeem(String redeem) {
        this.redeem = redeem;
    }
    public Double getBillAfterPoints() {
        return billAfterPoints;
    }

    public void setBillAfterPoints(Double billAfterPoints) {
        this.billAfterPoints = billAfterPoints;
    }

    public int getTotalNonRedeemedPoints() {
        totalNonRedeemedPoints = loyaltyPointsBean.getNonRedeemedPointsTotal(mobileNo);
        return totalNonRedeemedPoints;
    }

    public void setTotalNonRedeemedPoints(int totalNonRedeemedPoints) {
        this.totalNonRedeemedPoints = totalNonRedeemedPoints;
    }

    public String processResults() {
        int isRedeem = Integer.parseInt(redeem);
       
        if(isRedeem == 1) {
            System.out.println("######## " + redeem);
            this.setBillAfterPoints(loyaltyPointsBean.getPointsAppliedBillAmount(pointsToday, billTotal));
        } else {
            System.out.println("%%%%%%%%%%% " + redeem);
            loyaltyPointsBean.savePointsForLater(mobileNo, pointsToday);
            this.setBillAfterPoints(billTotal);
        }

        return "/response.xhtml";
    }
 
    public String reset() {
        this.billTotal = null;
        this.mobileNo = "";
        this.redeem = "";
        
        return "/welcome.xhtml";
    }
}
