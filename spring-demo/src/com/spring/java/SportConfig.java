// this file is equivalent with xml configuration for spring config

package com.spring.java;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.spring.annotations.FortuneService;


// annotate config with @Configuration and @ComponentScan
// @Configuration() is used to specify that this is a spring config file written in java
// @ComponentScan("package") is used to scan object in certain package. Scanned object will be register to spring factory
// if you want specific and has more control about your bean, use manual register instead of component scan
// @Bean() is used to register certain object to spring factory
@Configuration()
@PropertySource("classpath:./sport.properties")
public class SportConfig {
	
	@Value("${foo.team}")
	private String team;
	
	@Value("${foo.email}")
	private String email;
	
	// sad fortune bean
	@Bean()
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	
	// swim coach bean
	// inject swim with sad fortune
	@Bean()
	public SwimCoach swimCoach() {
		return new SwimCoach(this.sadFortuneService(), this.team, this.email);
	}
	
}
