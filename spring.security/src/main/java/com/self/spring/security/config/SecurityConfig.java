package com.self.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.self.spring.security.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userService;


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		UserBuilder user = User.withDefaultPasswordEncoder();
		
		// specify user, password, and roles for acess purposes
//		auth.inMemoryAuthentication()
//		.withUser(user.username("syamsul").password("syamsul123").roles("MANAGER"))
//		.withUser(user.username("fajar").password("fajar").roles("EMPLOYEE"))
//		.withUser(user.username("ken").password("arok").roles("GUEST", "EMPLOYEE"));
		
//		jdbc authentication
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
//		http.authorizeRequests()
//		.anyRequest().authenticated() // allow all request that has been authenticated
//		.and()
//		.formLogin().loginPage("/login").loginProcessingUrl("/user/login").permitAll() // login flow
//		.and().logout().permitAll(); // logout flow
		
		http.authorizeRequests()
			.antMatchers("/").hasAnyRole("MANAGER", "EMPLOYEE", "GUESS") // give acess for viewer
			.antMatchers("/leaders/**").hasRole("MANAGER") // give access for creator
			.antMatchers("/admins/**").hasAnyRole("EMPLOYEE", "MANAGER") // give access for buyer and creator
			.antMatchers("/api/**").permitAll()
		.and()
			.formLogin().loginPage("/login").loginProcessingUrl("/user/login").permitAll() // login flow
		.and()
			.logout().permitAll() // logout flow
		.and()
			.exceptionHandling().accessDeniedPage("/api/user/access/denied"); // access denied page
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
//		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	
}
