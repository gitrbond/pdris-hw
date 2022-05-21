package ru.sbt.fileuploadservice.initializer;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;

public class FileServerInitializer implements WebApplicationInitializer {
    private final String repositoryPath = "";
    private final int maxFileSize = 100000;

    @Override
    public void onStartup(ServletContext servletContext) {

        final var context = new AnnotationConfigWebApplicationContext();
        context.scan("ru.sbt.fileuploadservice");
        context.refresh();

        final var servlet = new DispatcherServlet(context);
        final var registration = servletContext.addServlet("myapp", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
        MultipartConfigElement multipartConfigElement = new  MultipartConfigElement(repositoryPath, (long)maxFileSize, (long)maxFileSize * 2, maxFileSize / 2);
        registration.setMultipartConfig(multipartConfigElement);
    }
}
