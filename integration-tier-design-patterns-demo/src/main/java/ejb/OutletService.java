/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dao.Dao;
import dao.JpaOutletDao;
import dao.JpaPizzaDao;
import entity.Outlet;
import entity.Pizza;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import web.OutletBean;

/**
 *
 * @author dell
 */
@Stateless
public class OutletService {

    @PersistenceContext
    private EntityManager em;

    private Dao dao;

    public void addOutlet(OutletBean bean) {
        Outlet outlet = new Outlet(bean.getCode(), bean.getName(), bean.getLocation());
        initDao(em);
        dao.save(outlet);
    }

    public List<Outlet> getAllOutlets() {
        initDao(em);
        return dao.getAll();
    }

    public void editOutlet(OutletBean bean) {
        Outlet outlet = new Outlet(bean.getCode(), bean.getName(), bean.getLocation());
        outlet.setId(bean.getId());
        initDao(em);

        dao.update(outlet);

    }

    public void deleteOutlet(OutletBean bean) {
        Outlet outlet = new Outlet(bean.getCode(), bean.getName(), bean.getLocation());
        outlet.setId(bean.getId());
        initDao(em);

        dao.delete(outlet);
    }

    public void initDao(EntityManager em) {
        dao = new JpaOutletDao(em);
    }
}
