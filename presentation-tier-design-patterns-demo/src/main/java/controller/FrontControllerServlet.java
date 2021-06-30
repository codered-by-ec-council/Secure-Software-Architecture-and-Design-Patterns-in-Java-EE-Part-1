/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.Collection;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Command;

/**
 *
 * @author dell
 */
@WebServlet("/")
public class FrontControllerServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //To change body of generated methods, choose Tools | Templates.
        Collection collection = new Collection();
        getServletContext().setAttribute("collection", collection);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Class type;
            HttpSession session = request.getSession(false);
            if (request.getParameter("command") == null 
                    && session.getAttribute("username") != null) {
                type = Class.forName("logic.HomeCommand");
            } else {
                type = Class.forName(String.format("logic.%sCommand", request.getParameter("command")));
            }

            Command command = (Command) type.asSubclass(Command.class).newInstance();
            command.init(request, response);
            command.process();
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | ServletException e) {
            System.out.println("Unknown Command " + e);
        }
    }

}
