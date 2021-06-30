/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.Collection;
import data.Pizza;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import view.helper.SearchResultsHelper;

/**
 *
 * @author dell
 */
public class SearchCommand extends Command {

    @Override
    public void process() throws ServletException, IOException {
        Collection collection = (Collection)request.getServletContext().getAttribute("collection");
        String criteria = request.getParameter("criteria");
        
        List<Pizza> pizzas = collection.find(criteria);
        if (pizzas.size() > 0) {
            
            SearchResultsHelper sHelper = new SearchResultsHelper();
            sHelper.setItems(pizzas);
            request.setAttribute("sHelper", sHelper);
            forward("item-found");
        } else {
            forward("item-notfound");
        }
    }
    
}
