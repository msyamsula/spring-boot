package com.self.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@SuppressWarnings("deprecation")
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		UserBuilder user = User.withDefaultPasswordEncoder();
		
		// specify user, password, and roles for acess purposes
		auth.inMemoryAuthentication()
		.withUser(user.username("syamsul").password("syamsul123").roles("creator", "viewer"))
		.withUser(user.username("fajar").password("fajar").roles("viewer"))
		.withUser(user.username("ken").password("arok").roles("viewer", "buyer"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
//		http.authorizeRequests()
//		.anyRequest().authenticated() // allow all request that has been authenticated
//		.and()
//		.formLogin().loginPage("/login").loginProcessingUrl("/user/login").permitAll() // login flow
//		.and().logout().permitAll(); // logout flow
		
		http.authorizeRequests()
		.antMatchers("/").hasRole("viewer") // give acess for viewer
		.antMatchers("/leaders/**").hasRole("creator") // give access for creator
		.antMatchers("/admins/**").hasAnyRole("creator", "buyer") // give access for buyer and creator
		.and()
		.formLogin().loginPage("/login").loginProcessingUrl("/user/login").permitAll() // login flow
		.and().logout().permitAll(); // logout flow
	}
	
	
	
}
