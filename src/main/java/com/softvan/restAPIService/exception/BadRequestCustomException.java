package com.softvan.restAPIService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * A custom exception thrown when user tries to send a bad request
 * with Http status as 400 i.e. bad request
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestCustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BadRequestCustomException() {
		super();
	}

	/**Instantiate BadRequestCustomException with specified message
	 * 
	 * @param message A string representing error message
	 */
	public BadRequestCustomException(String message) {
		super(message);
	}

}
