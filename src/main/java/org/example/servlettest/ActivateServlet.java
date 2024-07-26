package org.example.servlettest;

import org.example.servlettest.dao.UserDAOImpl;
import org.example.servlettest.model.User;
import org.example.servlettest.util.EncryptDecryptUtils;
import org.example.servlettest.util.ServletUtils;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.ServletException;

@WebServlet(name = "Servlet", value = "/activate")
public class ActivateServlet extends HttpServlet {

    private UserDAOImpl userDAO = new UserDAOImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String token = request.getParameter("token");

        if (token != null) {
            // escape chars
            // "+" -> ' '
            token = token.replaceAll(" ", "+");

            String email = EncryptDecryptUtils.decrypt(token);
            User user = userDAO.findUserByEmail(email);

            if (user != null) {
                // User found & should be active
                boolean isActivated = userDAO.activate(user);
                if (isActivated) {
                    request.setAttribute("msg", "WELCOME. YOUR ARE ACTIVATED");
                    ServletUtils.forwardJSP("blog", request, response);
                    return;
                }

            }

        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

}
