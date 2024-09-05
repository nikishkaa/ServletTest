package org.example.servlettest;


import org.example.servlettest.dao.UsersDao;
import org.example.servlettest.util.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();

        UsersDao usersDao = new UsersDao();


        // Работает // TODO добавить try with resources
        if (usersDao != null) {
            session.invalidate();
            System.out.println("Session with ID: " + session.getId() + " has been invalidated");

            ServletUtils.forwardJSP("blog", request, response);
        } else {
            ServletUtils.forwardJSP("login", request, response);
            return;
        }


    }

}
