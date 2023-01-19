package edu.school21.cinema.listeners;

import edu.school21.cinema.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextListener implements javax.servlet.ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        AnnotationConfigApplicationContext springContext =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        context.setAttribute("springContext", springContext);
    }
}
