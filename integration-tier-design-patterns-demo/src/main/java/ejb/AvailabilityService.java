/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dao.Dao;
import dao.JpaAvailabilityDao;
import dao.JpaPizzaDao;
import entity.Availability;
import entity.Pizza;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import web.AvailabilityBean;
import web.PizzaBean;

/**
 *
 * @author dell
 */
@Stateless
public class AvailabilityService {
    
    @PersistenceContext
    private EntityManager em;
    
    private Dao dao;
    
    public void addAvailability(AvailabilityBean bean) {
        boolean isAvailable = bean.getAvailable().equalsIgnoreCase("Yes");
        Availability availability = new Availability(bean.getSelectedItemCode(),
                bean.getSelectedOutletCode(), isAvailable);
        initDao(em);
        dao.save(availability);
    }
    
    public List<Availability> getItemAvailability(String itemCode) {
        initDao(em);
        return ((JpaAvailabilityDao)dao).getItemAvailability(itemCode);
    }
    
    public List<Availability> getAllAvailabilities() {
        initDao(em);
        return dao.getAll();
    }
    
    public void editAvailability(AvailabilityBean bean) {
        boolean isAvailable = bean.getAvailable().equalsIgnoreCase("Yes");
        Availability availability = new Availability(bean.getSelectedItemCode(),
                bean.getSelectedOutletCode(), isAvailable);

        initDao(em);
        
        dao.update(availability);
        
    }
    
    public void initDao(EntityManager em) {
        dao = new JpaAvailabilityDao(em);
    }
}
