package com.yourbank.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alexandr Yugov
 */
@Configuration
@ComponentScan("com.yourbank.web.controller")
public class WebConfig {
}
