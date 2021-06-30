/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dell
 */
public class LoginCommand extends Command {

    @Override
    public void process() throws ServletException, IOException {        
         if (request.getMethod().equals("POST")) {
            HttpSession session = request.getSession(true);
            session.setAttribute("username", request.getParameter("username"));
            //response.sendRedirect(request.getParameter("redirect"));
            response.sendRedirect(request.getRequestURL()
              .append("?command=Home").toString());
        } else {
//            String queryString = Optional.ofNullable(request.getQueryString())
//              .orElse("command=Home");
//            request.setAttribute("redirect", request.getRequestURL()
//              .append("?").append(queryString).toString());
            forward("login");
        }
    }
    
}
