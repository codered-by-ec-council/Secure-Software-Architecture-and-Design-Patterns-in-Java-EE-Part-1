/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.OutletService;
import entity.Outlet;
import entity.Pizza;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import static javax.faces.annotation.FacesConfig.Version.JSF_2_3;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dell
 */
@Named
@SessionScoped
@FacesConfig(version=JSF_2_3)
public class OutletBean implements Serializable {
    
    @EJB
    private OutletService outletService;
    
    private Long id;
    
    @NotNull
    private String code;
    @NotNull
    private String name;
    @NotNull
    private String location;
    
    private boolean canEdit;
    
    private List<OutletBean> allOutlets;

    public OutletBean() {
    }

    public OutletBean(Long id, String code, String name, String location) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.location = location;
        this.canEdit = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

    public List<OutletBean> getAllOutlets() {
        return allOutlets;
    }

    public void setAllOutlets(List<OutletBean> allOutlets) {
        this.allOutlets = allOutlets;
    }
    
    private void addOutlets(List<Outlet> outlets) {
        this.allOutlets = new ArrayList<>();
        
        for(Outlet o : outlets) {
            OutletBean bean = new OutletBean(o.getId(), o.getCode(), o.getName(), o.getLocation());
            
            this.allOutlets.add(bean);
        }
    }
    
    public String processResults() {
        
        outletService.addOutlet(this);
        
        List<Outlet> results = outletService.getAllOutlets();
        addOutlets(results);
        
        return "/all-outlets";
    }
    
        public void editOutlet(OutletBean outlet) {
        outletService.editOutlet(outlet);
    }
    
    public void deleteOutlet(OutletBean outlet) {
        outletService.deleteOutlet(outlet);
        
        List<Outlet> results = outletService.getAllOutlets();
        addOutlets(results);
    }
    
    public String reset() {
        this.code = "";
        this.name = "";
        this.location = "";
        
        return "/home.xhtml";
    }
}
