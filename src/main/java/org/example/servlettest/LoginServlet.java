package org.example.servlettest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Login page " + new Date());

        RequestDispatcher rd = request.getRequestDispatcher("html/loginForm.html");
        rd.forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String userName = request.getParameter("first");
        String password = request.getParameter("password");

        // Check in DB
        if (userName.equalsIgnoreCase("John")) {
            if (password.equals("1234")) {
                response.getWriter().println("Welcome back, dear " + userName);
            }
        } else {
            // include
            response.getWriter().println("<h2>Incorrect login or password</h2>");
            RequestDispatcher rd = request.getRequestDispatcher("html/loginForm.html");
            rd.include(request, response);
            return;
        }


    }
}
