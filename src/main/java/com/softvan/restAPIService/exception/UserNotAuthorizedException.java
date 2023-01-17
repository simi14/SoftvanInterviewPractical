package com.softvan.restAPIService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * A custom exception thrown when user tries to login with invalid credentials
 * with Http status as 401 i.e. Unauthorized
 */

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UserNotAuthorizedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotAuthorizedException() {
		super();
	}

	/**Instantiate UserNotAuthorizedException with specified message
	 * 
	 * @param message A string representing error message
	 */
	public UserNotAuthorizedException(String message) {
		super(message);
	}

}
