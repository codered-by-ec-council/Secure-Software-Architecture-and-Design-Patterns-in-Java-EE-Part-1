/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.IOException;
import javax.servlet.ServletException;

/**
 *
 * @author dell
 */
public class UnknownCommand extends Command {
    @Override
    public void process() throws ServletException, IOException {
        forward("login");
    }
}
