/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.Collection;
import data.Order;
import data.OrderTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dell
 */
public class OrderCommand extends Command {

    @Override
    public void process() throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        Order order = session.getAttribute("order") != null ?
            (Order)session.getAttribute("order") : new Order();
        
        String code = request.getParameter("code");
        Integer qty = Integer.parseInt(request.getParameter("qty"));
        Collection collection = (Collection)request.getServletContext().getAttribute("collection");
       
        OrderTO orderTO = new OrderTO(order, code, qty, collection);       
        orderTO = (OrderTO)delegate.doTask(orderTO);
        
        session.setAttribute("order", orderTO.getOrder());
        forward("cart");
    }
    
}
