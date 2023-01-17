package com.softvan.restAPIService.exception;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import com.softvan.restAPIService.model.APICustomError;

/**
 * This class acts as custom controller advice handling exceptions across the whole
 * application.
 * 
 * @author Simran Hotchandani
 *
 */
@ControllerAdvice
public class APIGlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(APIGlobalExceptionHandler.class);
	/**
	 * Method acting as Exception handler for handling NoSuchResourceFoundException
	 * exception
	 * 
	 * @param ex      Represents the exception expected to be thrown, in this case
	 *                NoSuchResourceFoundException
	 * @param request Represents incoming web request
	 * @return custom object of APICustomError wrapped around response entity with
	 *         status 404 in this case
	 */
	@ExceptionHandler(NoSuchResourceFoundException.class)
	public ResponseEntity<APICustomError> noSuchResourceFoundException(NoSuchResourceFoundException ex,
			WebRequest request) {
		APICustomError message = new APICustomError(HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage(),
				request.getDescription(false));
		logger.error("NoSuchResourceFoundException thrown, The requested resource doesn't exist.");
		return new ResponseEntity<APICustomError>(message, HttpStatus.NOT_FOUND);
	}

	/**
	 * Method acting as Exception handler for handling BadRequestCustomException
	 * exception
	 * 
	 * @param ex      Represents the exception expected to be thrown, in this case
	 *                BadRequestCustomException
	 * @param request Represents incoming web request
	 * @return custom object of APICustomError wrapped around response entity with
	 *         status 400 in this case
	 */
	@ExceptionHandler(BadRequestCustomException.class)
	public ResponseEntity<APICustomError> badRequestCustomException(BadRequestCustomException ex, WebRequest request) {
		APICustomError message = new APICustomError(HttpStatus.BAD_REQUEST.value(), new Date(), ex.getMessage(),
				request.getDescription(false));
		logger.error("BadRequestCustomException thrown, Can't process the request.");
		return new ResponseEntity<APICustomError>(message, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Method acting as Exception handler for handling UserNotAuthorizedException
	 * exception
	 * 
	 * @param ex      Represents the exception expected to be thrown, in this case
	 *                UserNotAuthorizedException
	 * @param request Represents incoming web request
	 * @return custom object of APICustomError wrapped around response entity with
	 *         status 401 i.e. unauthorized in this case
	 */
	@ExceptionHandler(UserNotAuthorizedException.class)
	public ResponseEntity<APICustomError> userNotAuthorized(UserNotAuthorizedException ex, WebRequest request) {
		APICustomError message = new APICustomError(HttpStatus.UNAUTHORIZED.value(), new Date(), ex.getMessage(),
				request.getDescription(false));
		logger.error("UserNotAuthorizedException thrown, User isn't authorized.");
		return new ResponseEntity<APICustomError>(message, HttpStatus.UNAUTHORIZED);
	}

	/**
	 * Method acting as Exception handler for all other exceptions other than the
	 * custom exceptions thrown
	 * 
	 * @param ex      Represents the exception expected to be thrown, in this case
	 *                Exception
	 * @param request Represents incoming web request
	 * @return custom object of APICustomError wrapped around response entity with
	 *         status 500 i.e. internal server error in this case
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<APICustomError> globalExceptionHandler(Exception ex, WebRequest request) {
		APICustomError message = new APICustomError(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(),
				ex.getMessage(), request.getDescription(false));
		logger.error("Generic Exception thrown");
		return new ResponseEntity<APICustomError>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
