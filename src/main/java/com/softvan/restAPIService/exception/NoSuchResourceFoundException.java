package com.softvan.restAPIService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * A custom exception thrown when user tries to get/update a resource that
 * doesn't exist with Http status as 404 i.e. Not Found
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchResourceFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoSuchResourceFoundException() {
		super();
	}
	
	/**Instantiate NoSuchResourceFoundException with specified message
	 * 
	 * @param message A string representing error message
	 */
	public NoSuchResourceFoundException(String message) {
		super(message);
	}

}
