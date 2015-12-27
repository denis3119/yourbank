package com.yourbank.config;

import com.yourbank.data.config.DatabaseConfig;
import com.yourbank.web.config.WebConfig;
import com.yourbank.service.ServiceConfig;
import org.apache.catalina.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author Yugov Alexandr.
 */

@Order(Ordered.HIGHEST_PRECEDENCE)
@SpringBootApplication
@Import({SecurityConfig.class, DatabaseConfig.class, WebConfig.class, ServiceConfig.class})
@EnableAutoConfiguration()
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
