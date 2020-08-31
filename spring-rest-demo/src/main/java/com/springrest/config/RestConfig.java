package com.springrest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration // tell spring that this class is a configuration
@EnableWebMvc // tell that this is an mvc web
@ComponentScan("com.springrest") // tell package to scan for component
public class RestConfig {

}
