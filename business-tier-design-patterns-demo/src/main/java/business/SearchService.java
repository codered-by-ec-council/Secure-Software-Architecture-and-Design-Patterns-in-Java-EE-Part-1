/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.BaseTO;
import data.Pizza;
import data.SearchTO;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author dell
 */
@Stateless
public class SearchService implements BusinessService {

    @Override
    public BaseTO doProcessing(BaseTO tObj) {
        SearchTO searchTO = (SearchTO)tObj;
        List<Pizza> pizzas = searchTO.getCollection().find(searchTO.getCriteria());
        searchTO.setResults(pizzas);
        
        return searchTO;
    }

    @Override
    public String getName() {
        return "Search";
    }
}
