package org.example.servlettest;

import org.example.servlettest.dao.UserDAOImpl;
import org.example.servlettest.model.User;
import org.example.servlettest.util.ServletUtils;

import java.io.*;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "newLogin", value = "/login")
public class NewLoginServlet extends HttpServlet {
    private UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Login page " + new Date());

        ServletUtils.forwardJSP("login", request, response);
        return;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final String email = request.getParameter("email");
        final String psw = request.getParameter("psw");

        User user = null;
        if ((user = userDAO.findUserByEmail(email)) != null) {
            if (user.getPassword().equals(psw)) {
                if (!user.isActive()) {
                    request.setAttribute("msg", "Not Activate Email");
                    ServletUtils.forwardJSP("login", request, response);

                }


                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(5);

                //Store user object within HTTP Session
                session.setAttribute("user", user);

                ServletUtils.forwardJSP("blog", request, response);
                return;
            } else {
                response.getWriter().println("Invalid username or password");
                return;
            }
        }

    }

}
