package com.softvan.restAPIService.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * This class provides a custom implementation of WebSecurityConfigurerAdapter
 * instance, providing the flexibility to configure spring basic security in
 * custom ways.
 * 
 * @author Simran Hotchandani
 *
 */
@Configuration
@EnableWebSecurity
public class APISecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(APISecurityConfig.class);
	/**
	 * Injecting username from properties
	 */
	@Value("${spring.security.user.name}")
	String username;

	/**
	 * Injecting password from properties
	 */
	@Value("${spring.security.user.password}")
	String password;

	/**
	 * Dependency Injected - CustomAuthenticationEntryPoint
	 */
	@Autowired
	CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

	/**Method overridden to authenticate users and configure custom authentication
	 * entry point to throw custom unauthorized error.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().disable().authorizeRequests().anyRequest().authenticated().and()
				.exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint).and().httpBasic();
	}

	/** Method overridden to specify custom AuthenticationManager.
	 * Here noop specifies that NoOpPassword encoder should be used, helpful while working with plain texts.
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		logger.info("Processing Authentication Request");
		auth.inMemoryAuthentication().withUser(username).password("{noop}" + password).roles("");
	}
}
