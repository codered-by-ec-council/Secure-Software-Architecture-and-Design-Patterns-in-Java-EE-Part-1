/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Availability;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author dell
 */
public class JpaAvailabilityDao implements Dao<Availability>{

    private final EntityManager entityManager;

    public JpaAvailabilityDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public Optional<Availability> get(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Availability> getAll() {
        Query query = entityManager.createQuery("SELECT a FROM Availability a");
        return query.getResultList();
    }
    
    public List<Availability> getItemAvailability(String itemCode) {
        Query query = entityManager.createQuery("SELECT a FROM Availability a WHERE "
                + "a.itemCode = :item AND a.isAvailable = 1");
        query.setParameter("item", itemCode);
        return query.getResultList();
    }

    @Override
    public void save(Availability t) {
       entityManager.persist(t);
    }

    @Override
    public void update(Availability t) {
        Query query = entityManager.createQuery("UPDATE Availability a SET a.isAvailable = :ava WHERE a.itemCode = :item AND a.outletCode = :outlet");
        query.setParameter("ava", t.getIsAvailable());
        query.setParameter("item", t.getItemCode());
        query.setParameter("outlet", t.getOutletCode());
        query.executeUpdate();
    }

    @Override
    public void delete(Availability t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
