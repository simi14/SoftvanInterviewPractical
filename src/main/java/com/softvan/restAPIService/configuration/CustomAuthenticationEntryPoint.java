package com.softvan.restAPIService.configuration;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import com.softvan.restAPIService.exception.UserNotAuthorizedException;

/**
 * This class provides a custom implementation of AuthenticationEntryPoint
 * instance, providing the flexibility to configure custom unauthorized
 * exception.
 * 
 * @author Simran Hotchandani
 *
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationEntryPoint.class);
	/**
	 * Dependency Injected To resolve exceptions
	 */
	@Autowired
	@Qualifier("handlerExceptionResolver")
	HandlerExceptionResolver resolver;

	/**
	 * Method overridden to throw UserNotAuthorizedException custom exception
	 */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		logger.info("Inside AuthenticationEntryPoint");
		resolver.resolveException(request, response, null, new UserNotAuthorizedException("User is Not Authorized"));
	}
}
