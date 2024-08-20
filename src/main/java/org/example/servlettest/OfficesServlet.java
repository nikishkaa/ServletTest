package org.example.servlettest;

import org.example.servlettest.util.HTMLTableBuilder;
import org.example.servlettest.util.XMLCurrencyParser;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.ServletException;

@WebServlet(name = "OfficesServlet", value = "/offices")
public class OfficesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HTMLTableBuilder offices = new HTMLTableBuilder("Offices", true, 3, 3, 10, 10, 10);
        offices.addTableHeader("offices Code", "city", "phone", "Address Line 1", "Address Line 2", "State", "Country", "Postal Code", "Territory");

        offices.addRowValues("1", "USD", XMLCurrencyParser.getCurrency("840"));
        offices.addRowValues("2", "EUR", XMLCurrencyParser.getCurrency("978"));
        offices.addRowValues("3", "RUB(100)", XMLCurrencyParser.getCurrency("643"));


    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

}
