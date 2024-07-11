package org.example.servlettest;

import org.example.servlettest.util.IOUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "templateServlet", value = "/template")
public class TemplateTestServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        File f = new File("D:\\Programming\\ee-projects\\ServletTest\\src\\main\\webapp\\index.html");
        String indexContent = IOUtils.read(f);

        if (request.getParameter("user") != null) {
            indexContent = indexContent.replace("${action.link}", "Logout");
            indexContent = indexContent.replace("${action.name}", "Logout");
        } else {
            indexContent = indexContent.replace("${action.link}", "Login");
            indexContent = indexContent.replace("${action.name}", "Login");
        }

        response.getWriter().println(indexContent);


//        System.out.println(indexContent);


    }

}
