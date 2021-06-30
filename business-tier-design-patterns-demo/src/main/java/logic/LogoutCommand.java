/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;

/**
 *
 * @author dell
 */
public class LogoutCommand extends Command {
     public void process() throws ServletException, IOException {
        Optional.ofNullable(request.getSession(false))
          .ifPresent(session -> {
              session.removeAttribute("username");
              session.removeAttribute("order");
          });
        //response.sendRedirect("?command=Home");
        forward("login");
    }
}
