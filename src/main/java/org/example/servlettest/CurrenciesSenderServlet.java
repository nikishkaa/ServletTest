package org.example.servlettest;

import org.apache.log4j.Logger;
import org.example.servlettest.dao.UserDAOImpl;
import org.example.servlettest.services.CurrencySenderService;
import org.example.servlettest.services.quatz.CreateQuartzJob;
import org.example.servlettest.services.quatz.QuartzScheduler;
import org.example.servlettest.util.ServletUtils;
import org.quartz.SchedulerException;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.ServletException;

@WebServlet(name = "CurrenciesSenderServlet", value = "/send-currencies")
public class CurrenciesSenderServlet extends HttpServlet {
    UserDAOImpl userDAO = new UserDAOImpl();
    private Logger log = Logger.getLogger(CreateQuartzJob.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
// http://localhost:8080/ServletTest1/send-currencies?job=1&action=stop

        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            request.setAttribute("msg", "Your should login to perform such operation");
            ServletUtils.forwardJSP("login", request, response);
        }


        String job = request.getParameter("job");
        String action = request.getParameter("action");
        String interval = request.getParameter("interval");


        if (job.equals("1")) {
            if (action.equals("start")) {
                log.info("job #1 has been started via Servlet");
                try {
                    if (interval != null) {
                        int i = Integer.parseInt(interval);
                        if (i > 0 && i < 3000) {
                            QuartzScheduler.TIME_INTERVAL = i;
                        } else {
                            log.warn("Invalid time interval: " + i);
                        }
                    }
                    QuartzScheduler.jobOne();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if (action.equals("stop")) {
                try {
                    log.info("Trying to stop job #1");
                    QuartzScheduler.stopJob();
                } catch (SchedulerException e) {
                    throw new RuntimeException(e);
                }
            }

        } else {
            log.info("Common sender Servlet");
            CurrencySenderService.sendCurrencies(userDAO.findAll());
            request.setAttribute("msg", "Currencies has been send");
            ServletUtils.forwardJSP("blog", request, response);
        }


    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

}
