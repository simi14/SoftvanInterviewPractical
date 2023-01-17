package com.softvan.restAPIService.model;

import java.util.Date;

/**
 * A model class to represent api error response
 * 
 * @author Simran Hotchandani
 *
 */
public class APICustomError {

	private int statusCode;
	private Date timestamp;
	private String message;
	private String description;

	/**
	 * Creates error response body with specified details
	 * 
	 * @param statusCode  Error's Http status Code
	 * @param timestamp   Time at which error occured
	 * @param message     Error's custom message
	 * @param description Error's description
	 */
	public APICustomError(int statusCode, Date timestamp, String message, String description) {
		this.statusCode = statusCode;
		this.timestamp = timestamp;
		this.message = message;
		this.description = description;
	}

	/**Get Error's Status Code
	 * @return an integer representing response's http status code
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**Get Error's timestamp
	 * @return date and time when error occured
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/** Get Error custom message
	 * @return a string representing custom error message
	 */
	public String getMessage() {
		return message;
	}

	/** Get Error custom description
	 * @return a string representing custom error description
	 */
	public String getDescription() {
		return description;
	}

}
