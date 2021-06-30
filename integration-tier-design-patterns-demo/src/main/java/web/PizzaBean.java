/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.ItemService;
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
public class PizzaBean implements Serializable {

    @EJB
    private ItemService itemService;
    
    private Long id;
    
    @NotNull
    private String code;
    @NotNull
    private String category;
    @NotNull
    private String name;
    @NotNull
    private String topping;
    @NotNull
    private String size;
    @NotNull
    private Double price;
    
    private boolean canEdit;
    
    private List<PizzaBean> allItems;
    
    
    public PizzaBean() {
    }

    public PizzaBean(Long id, String code, String category, String name, String topping, String size, Double price) {
        this.id = id;
        this.code = code;
        this.category = category;
        this.name = name;
        this.topping = topping;
        this.size = size;
        this.price = price;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ItemService getItemService() {
        return itemService;
    }

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    public List<PizzaBean> getAllItems() {
        return allItems;
    }

    public void setAllItems(List<PizzaBean> allItems) {
        this.allItems = allItems;
    }
    
    private void addItems(List<Pizza> items) {
        this.allItems = new ArrayList<>();
        
        for(Pizza i : items) {
            PizzaBean bean = new PizzaBean(i.getId(), i.getCode(), i.getCategory(),
                    i.getName(), i.getTopping(), i.getSize(), i.getPrice());
            
            this.allItems.add(bean);
        }
    }

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }
    
    
    
    public String processResults() {
        itemService.addItem(this);
        
        List<Pizza> results = itemService.getAllItems();
        addItems(results);
        
        return "/all-items.xhtml";
    }

    public void editItem(PizzaBean item) {
        itemService.editItem(item);
    }
    
    public void deleteItem(PizzaBean item) {
        itemService.deleteItem(item);
        
        List<Pizza> results = itemService.getAllItems();
        addItems(results);
    }
    
    public String reset() {
        this.code = "";
        this.category = "";
        this.topping = "";
        this.name = "";
        this.size = "";
        this.price = null;
        
        return "/home.xhtml";
    }
}
