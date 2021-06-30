/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.ejb;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import supermarket.entity.LoyaltyPoints;

/**
 *
 * @author buddhini
 */
@Stateless
public class LoyaltyPointsBean {
    
    @PersistenceContext
    private EntityManager em;
    
    public double getPointsAppliedBillAmount(int points, double totalBill) {
        double billAmount = 0;
                
        switch (points) {
            case 1:
                billAmount = totalBill - 50;
                break;
            case 2:
                billAmount = totalBill - 100;
                break;
            case 5:
                billAmount = totalBill - 200;
                break;
            default:
                break;
        }
        
        return billAmount;
    }
    
    public Integer getNonRedeemedPointsTotal(String mobileNo) {
        Integer nonRedeemedPointsTotal;
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Integer> query = cb.createQuery(Integer.class);
        Root<LoyaltyPoints> root = query.from(LoyaltyPoints.class);
        query.select(cb.sum(root.get("nonRedeemedPoints"))).where(cb.equal(root.get("mobileNo"), mobileNo));
        nonRedeemedPointsTotal = em.createQuery(query).getSingleResult();

        
        System.out.println("getNonRedeemedPointsTotal " + nonRedeemedPointsTotal);
        return nonRedeemedPointsTotal;
    }
    
    public void savePointsForLater(String mobileNo, int points) {
        System.out.println(mobileNo + " " + points);
        LoyaltyPoints lp = new LoyaltyPoints(GregorianCalendar.getInstance(),mobileNo,points);
        System.out.println(lp);
        em.persist(lp);
        System.out.println("adasdjk");
    }
}
