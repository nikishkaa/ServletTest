package org.example.servlettest;

import org.apache.commons.lang3.StringUtils;
import org.example.servlettest.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.servlettest.util.ServletUtils.*;

@WebServlet(name = "CoursesServlet", value = "/curr")

public class CurrenciesServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String path = "currencies_request_form";

        if (StringUtils.isEmpty(request.getParameter("amount"))) {
            // 0. Show currencies request form
            forward(path, request, response);
            return;
        }

        // 1. amount & currencies are presented -> client request to calculate
        // 1.1 get param values
        long amount = getLongParameter(request, "amount");
        String code = request.getParameter("code");

        // 1.2 Get currency Rate
        double rate = Double.parseDouble(XMLCurrencyParser.getCurrency(code));

        // 1.3 Calculate final amount
        if (code.equals("643")) {
            rate /= 100;
        }
        double result = amount * rate;


        // 1.4 Make response
        include(path, "Result Amount: " + result, request, response);
        return;

    }


}
