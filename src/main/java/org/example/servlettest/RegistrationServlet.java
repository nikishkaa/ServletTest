package org.example.servlettest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.example.servlettest.dao.UserDAOImpl;
import org.example.servlettest.model.User;
import org.example.servlettest.util.EncryptDecryptUtils;
import org.example.servlettest.util.MailUtils;
import org.example.servlettest.util.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", value = "/reg-user")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletUtils.forwardJSP("reg", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("psw");
        String repeatedPassword = request.getParameter("psw2");

        if (password.equals(repeatedPassword)) {
            User user = new User();
            user.setEmail(email);
            user.setName(name);

            String encryptedPassword = EncryptDecryptUtils.encrypt(password);
            user.setPassword(encryptedPassword);

            UserDAOImpl userDAO = new UserDAOImpl();

            try {
                boolean isCreated = userDAO.createUser(user);
                if (isCreated) {
                    // just created - not active!
                    // send msg with instructions

                    String subject = "Welcome to crazy users applications";

                    String token = EncryptDecryptUtils.encrypt(user.getEmail());
                    System.out.println(token);
                    String msg = String.format("<b> To confirm your account, please <a href='http://localhost:8080/ServletTest1/activate?token='>click</a></b>", token);
                    System.out.println(token);


                    MailUtils.sendHTMLMail(user.getEmail(), subject, msg, null, null);


                    request.setAttribute("msg", "Check Your Email to confirm Registration");
                    ServletUtils.forwardJSP("reg", request, response);
//                    ServletUtils.forwardJSP("blog", request, response);
                    return;
                } else {
                    request.setAttribute("msg", "Error User Registration");
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("msg", "Internal Error User Registration");
                String message = ExceptionUtils.getMessage(e.getCause());
                String stackTrace = ExceptionUtils.getStackTrace(e);
                request.setAttribute("cause", StringUtils.isEmpty(message) ? ExceptionUtils.getMessage(e) : message);
                request.setAttribute("stack-trace", stackTrace);
                ServletUtils.forwardJSP("reg", request, response);

                return;

            }


            return;
        } else {
            response.getWriter().println("Password mismatch");
            return;
        }
    }
}