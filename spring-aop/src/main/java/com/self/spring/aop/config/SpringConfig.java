package com.self.spring.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableAspectJAutoProxy // tell that we want use aspect in our app
@PropertySource("classpath:env")
@ComponentScan("com.self.spring.aop")
public class SpringConfig {

	public SpringConfig() {
	}

}
