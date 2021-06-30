/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Outlet;
import entity.Pizza;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author dell
 */
public class JpaOutletDao implements Dao<Outlet> {

    private final EntityManager entityManager;

    public JpaOutletDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
     
    @Override
    public Optional<Outlet> get(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Outlet> getAll() {
        Query query = entityManager.createQuery("SELECT o FROM Outlet o");
        return query.getResultList();
    }

    @Override
    public void save(Outlet t) {
        entityManager.persist(t);
    }

    @Override
    public void update(Outlet t) {
         entityManager.merge(t);
    }

    @Override
    public void delete(Outlet t) {
        t = entityManager.getReference(Outlet.class, t.getId());
        entityManager.remove(t);
    }
    
}
