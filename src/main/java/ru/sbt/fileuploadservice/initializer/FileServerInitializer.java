package ru.sbt.fileuploadservice.initializer;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import java.io.File;

public class FileServerInitializer implements WebApplicationInitializer {
    private final String repositoryPath = "C:\\Users\\cubic\\IdeaProjects\\pdris-hw";
    private final long maxFileSize = 100000;
    private final long maxRequestSize = 200000;
    private final long fileSizeThreshold = 50000;

    @Override
    public void onStartup(ServletContext servletContext) {

        final var context = new AnnotationConfigWebApplicationContext();
        context.scan("ru.sbt.fileuploadservice");
        context.refresh();

        final var servlet = new DispatcherServlet(context);
        final var registration = servletContext.addServlet("myapp", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
        MultipartConfigElement multipartConfigElement = new  MultipartConfigElement(repositoryPath, maxFileSize, maxRequestSize, fileSizeThreshold);
        registration.setMultipartConfig(multipartConfigElement);
    }
}
