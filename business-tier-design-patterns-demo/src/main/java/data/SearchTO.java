/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.List;

/**
 *
 * @author dell
 */
public class SearchTO extends BaseTO {
    private String criteria;
    private List<Pizza> results;

    public SearchTO(String criteria, Collection collection) {
        super(collection);
        this.criteria = criteria;
    }

    
    
    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public List<Pizza> getResults() {
        return results;
    }

    public void setResults(List<Pizza> results) {
        this.results = results;
    }
}
