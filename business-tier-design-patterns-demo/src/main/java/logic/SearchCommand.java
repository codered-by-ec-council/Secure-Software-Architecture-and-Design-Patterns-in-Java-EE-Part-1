/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.Collection;
import data.SearchTO;
import java.io.IOException;
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
        
        SearchTO searchTO = new SearchTO(criteria, collection);       
        searchTO = (SearchTO) delegate.doTask(searchTO);
       
        if (searchTO.getResults().size() > 0) {
            
            SearchResultsHelper sHelper = new SearchResultsHelper();
            sHelper.setItems(searchTO.getResults());
            request.setAttribute("sHelper", sHelper);
            forward("item-found");
        } else {
            forward("item-notfound");
        }
    }
    
}
