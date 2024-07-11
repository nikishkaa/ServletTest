package org.example.servlettest;

import org.example.servlettest.util.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "GuestNumberServlet", value = "/guest")
public class GuestNumberServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("courses", Arrays.asList("USD", "EURO", "RUB"));
        ServletUtils.forwardJSP("gues-number", request, response);

    }
}
