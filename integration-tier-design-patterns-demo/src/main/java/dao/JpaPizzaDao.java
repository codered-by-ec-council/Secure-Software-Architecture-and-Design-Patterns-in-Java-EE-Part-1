/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Pizza;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author dell
 */
public class JpaPizzaDao implements Dao<Pizza>{

    private final EntityManager entityManager;

    public JpaPizzaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public Optional<Pizza> get(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pizza> getAll() {
        Query query = entityManager.createQuery("SELECT p FROM Pizza p");
        return query.getResultList();
    }

    @Override
    public void save(Pizza t) {
        entityManager.persist(t);
    }

    @Override
    public void update(Pizza t) {
        entityManager.merge(t);
    }

    @Override
    public void delete(Pizza t) {
        t = entityManager.getReference(Pizza.class, t.getId());
        entityManager.remove(t);
    }
    
}
