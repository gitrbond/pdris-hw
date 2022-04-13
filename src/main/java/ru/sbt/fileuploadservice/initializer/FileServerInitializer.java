package ru.sbt.fileuploadservice.initializer;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import java.io.File;

public class FileServerInitializer implements WebApplicationInitializer {
    private final String repositoryPath = "C:\\Users\\cubic\\IdeaProjects\\pdris-hw";

    @Override
    public void onStartup(ServletContext servletContext) {

        final var context = new AnnotationConfigWebApplicationContext();
        context.scan("ru.sbt.fileuploadservice");
        context.refresh();

        final var servlet = new DispatcherServlet(context);
        final var registration = servletContext.addServlet("myapp", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");

        File uploadDirectory = new File(repositoryPath);
        MultipartConfigElement multipartConfigElement = new  MultipartConfigElement(uploadDirectory.getAbsolutePath(), 100000, 100000 * 2, 100000 / 2);

        registration.setMultipartConfig(multipartConfigElement);
    }
}
