package com.santin.citycatalog;

import com.santin.citycatalog.config.CityCatalogConfig;
import com.santin.citycatalog.config.PersistenceJPAConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class CityCatalogInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(final ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(CityCatalogConfig.class, PersistenceJPAConfig.class);
        context.setServletContext(container);

        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher",
                new DispatcherServlet(context));

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
