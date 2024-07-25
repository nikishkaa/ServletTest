package org.example.servlettest;

import org.example.servlettest.util.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "CarServlet", value = "/table")
public class CarServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("cars", Arrays.asList("BMW", "HONDA", "OPEL"));
        ServletUtils.forwardJSP("cars-table", request, response);
    }
}
