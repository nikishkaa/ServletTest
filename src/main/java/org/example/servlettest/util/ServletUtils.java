package org.example.servlettest.util;

import org.example.servlettest.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

public class ServletUtils {
    public static void forward(final String path, final HttpServletRequest request,
                               final HttpServletResponse response) throws ServletException, IOException {
        System.out.println(new Date() + " forwarding to: " + path);
        request.getRequestDispatcher(("/html/" + path + ".html")).forward(request, response);
    }

    public static void forwardJSP(final String path, final HttpServletRequest request,
                                  final HttpServletResponse response) throws ServletException, IOException {
        System.out.println(new Date() + " forwarding to jsp: " + path);
        request.getRequestDispatcher((path + ".jsp")).forward(request, response);
    }

    public static void include(final String path, final String msg, final HttpServletRequest request,
                               final HttpServletResponse response) throws ServletException, IOException {
        String charSet = "UTF-8";
        response.setHeader("Content-type", "text/html;charset=" + charSet);
        System.out.println(new Date() + " Include for: " + path);
        response.getWriter().println("<h3>" + msg + "<>");
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.include(request, response);
    }

    public static void redirect(final String path,
                                final HttpServletResponse response) throws IOException {
        System.out.println(new Date() + " Redirect for: " + path + ".html");
        response.sendRedirect(path);
    }

    public static long getLongParameter(final HttpServletRequest request, final String paramName) {
        return Long.parseLong(request.getParameter(paramName));
    }

    public static User getUserInSession(final HttpServletRequest request) {
        Optional<User> userOpt = Optional.ofNullable((User) request.getSession().getAttribute("user"));

        if (userOpt.isPresent()) {
            return (User) userOpt.get();
        }

        return null;
    }
}
