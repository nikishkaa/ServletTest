package org.example.servlettest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "age1", value = "/form")
public class ageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = request.getRequestDispatcher("html/ageForm.html");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        int age = Integer.parseInt(request.getParameter("age"));
        if (age >= 18) {
            response.getWriter().println("<img src=\"img/beer.png\">");
        }else{
            response.getWriter().println("<img src=\"img/juice.png\">");
        }

    }

}
