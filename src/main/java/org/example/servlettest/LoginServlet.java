//package org.example.servlettest;
//
//import org.example.servlettest.dao.UserDAO;
//import org.example.servlettest.dao.UserDaoImpl;
//import org.example.servlettest.model.User;
//import org.example.servlettest.util.ServletUtils;
//
//import java.io.*;
//import java.util.Date;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//
//@WebServlet(name = "LoginServlet", value = "login")
//public class LoginServlet extends HttpServlet {
//    private UserDaoImpl userDAO = new UserDaoImpl();
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("Login page " + new Date());
//
//        request.getRequestDispatcher("html/login.html");
//        ServletUtils.forwardJSP("login", request, response);
//        return;
//    }
//
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        final String email = request.getParameter("name");
//        final String psd = request.getParameter("psd");
//
//        User user = null;
//        if ((user = userDAO.findUserByEmail(email)) != null) {
//            if (user.getPassword().equals(psd)) {
//                ServletUtils.forwardJSP("login", request, response);
//                return;
//            } else {
//                response.getWriter().println("Invalid username or password");
//                return;
//            }
//        }
//
//    }
//
//}
