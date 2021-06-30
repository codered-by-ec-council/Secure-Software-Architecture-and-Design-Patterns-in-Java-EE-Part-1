/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.AvailabilityService;
import ejb.ItemService;
import ejb.OutletService;
import entity.Availability;
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
@FacesConfig(version = JSF_2_3)
public class AvailabilityBean implements Serializable {

    @EJB
    private ItemService itemService;

    @EJB
    private OutletService outletService;

    @EJB
    private AvailabilityService availabilityService;

    private Long id;

    @NotNull
    private String selectedItemCode;
    @NotNull
    private String selectedOutletCode;

    private List<String> itemCodes;

    private List<String> outletCodes;

    private String available;

    private boolean canEdit;

    private List<AvailabilityBean> availabilities;

    public AvailabilityBean() {
    }

    public AvailabilityBean(Long id, String selectedItemCode, String selectedOutletCode, String available) {
        this.id = id;
        this.selectedItemCode = selectedItemCode;
        this.selectedOutletCode = selectedOutletCode;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSelectedItemCode() {
        return selectedItemCode;
    }

    public void setSelectedItemCode(String selectedItemCode) {
        this.selectedItemCode = selectedItemCode;
    }

    public String getSelectedOutletCode() {
        return selectedOutletCode;
    }

    public void setSelectedOutletCode(String selectedOutletCode) {
        this.selectedOutletCode = selectedOutletCode;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public List<String> getItemCodes() {
        List<Pizza> items = itemService.getAllItems();
        addItemCodes(items);
        return itemCodes;
    }

    public void setItemCodes(List<String> itemCodes) {
        this.itemCodes = itemCodes;
    }

    public List<String> getOutletCodes() {
        List<Outlet> outlets = outletService.getAllOutlets();
        addOutletCodes(outlets);
        return outletCodes;
    }

    public void setOutletCodes(List<String> outletCodes) {
        this.outletCodes = outletCodes;
    }

    private void addOutletCodes(List<Outlet> outlets) {
        this.outletCodes = new ArrayList<>();

        for (Outlet o : outlets) {
            this.outletCodes.add(o.getCode());
        }
    }

    private void addItemCodes(List<Pizza> items) {
        this.itemCodes = new ArrayList<>();

        for (Pizza p : items) {
            this.itemCodes.add(p.getCode());
        }
    }

    public List<AvailabilityBean> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(List<AvailabilityBean> availabilities) {
        this.availabilities = availabilities;
    }

    private void addAvailabilities(List<Availability> ava) {
        this.availabilities = new ArrayList<>();

        for (Availability a : ava) {
            String isAvailabile = a.getIsAvailable() ? "Yes" : "No";
            AvailabilityBean availabilityBean
                    = new AvailabilityBean(a.getId(), a.getItemCode(),
                            a.getOutletCode(), isAvailabile);

            this.availabilities.add(availabilityBean);
        }
    }

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

    public String processResults() {
        availabilityService.addAvailability(this);

        List<Availability> results = availabilityService.getAllAvailabilities();
        addAvailabilities(results);

        return "/availability";
    }

    public void editAvailability(AvailabilityBean ava) {
        availabilityService.editAvailability(ava);
    }
    
    public String reset() {
        
        this.selectedItemCode = itemCodes.get(0);
        this.selectedOutletCode = outletCodes.get(0);
        this.available = "Yes";
        
        return "/home.xhtml";
    }
}
