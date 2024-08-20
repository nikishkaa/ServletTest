package org.example.servlettest.services.quatz;

//import classes
import org.apache.log4j.Logger;
import org.example.servlettest.dao.UserDAO;
import org.example.servlettest.dao.UserDAOImpl;
import org.example.servlettest.services.CurrencySenderService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

//create CreateQuartzJob class that implements Job
public class CreateQuartzJob implements Job{

    //Create instance of logger
 private UserDAO userDAO = new UserDAOImpl();

    private Logger log = Logger.getLogger(CreateQuartzJob.class);

    //execute Job by using execute() method of the Job interface
    public void execute(JobExecutionContext jExeCtx) throws JobExecutionException {//handle JobExecutionException


        CurrencySenderService.sendCurrencies(userDAO.findAll());
        //debug message
        log.debug("CreateQuartzJob is finishing......");
    }
}
