/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dao.Dao;
import dao.JpaPizzaDao;
import entity.Pizza;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import web.PizzaBean;

/**
 *
 * @author dell
 */
@Stateless
public class ItemService {
    
    @PersistenceContext
    private EntityManager em;
    
    private Dao dao;
    
    
    
    public void addItem(PizzaBean bean) {
        Pizza pizza = new Pizza(bean.getCode(), bean.getCategory(), bean.getName(),
                            bean.getTopping(), bean.getSize(), bean.getPrice());
        initDao(em);
        dao.save(pizza);
    }
    
    public List<Pizza> getAllItems() {
        initDao(em);
        return dao.getAll();
    }
    
    public void editItem(PizzaBean bean) {
        Pizza pizza = new Pizza(bean.getCode(), bean.getCategory(), bean.getName(),
                            bean.getTopping(), bean.getSize(), bean.getPrice());
        pizza.setId(bean.getId());
        initDao(em);
        
        dao.update(pizza);
        
    }
    
    public void deleteItem(PizzaBean bean) {
        Pizza pizza = new Pizza(bean.getCode(), bean.getCategory(), bean.getName(),
                            bean.getTopping(), bean.getSize(), bean.getPrice());
        pizza.setId(bean.getId());
        initDao(em);
        
        dao.delete(pizza);
    }
    
    public void initDao(EntityManager em) {
        dao = new JpaPizzaDao(em);
    }
}
