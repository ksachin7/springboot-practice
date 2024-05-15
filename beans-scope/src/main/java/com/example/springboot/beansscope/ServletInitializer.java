package com.example.springboot.beansscope;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    /**
     * This method is overridden to provide additional configuration to the Spring application builder.
     * It allows you to customize the configuration of your Spring Boot application when it is deployed as a WAR file,  which can be deployed to a Servlet container like Tomcat or Jetty.
     *
     * @param application The SpringApplicationBuilder to configure.
     * @return The configured SpringApplicationBuilder.
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        // Specify the sources (configuration classes) that should be used to configure the Spring application context.
        // In this case, BeansScopeApplication.class is provided as the source,
        // indicating that the main application class should be used for configuration.
        return application.sources(BeansScopeApplication.class);
    }

}
