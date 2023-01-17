package com.softvan.restAPIService.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.softvan.restAPIService.model.User;
import com.softvan.restAPIService.service.UserService;

/**
 * This is a singleton class acting as rest controller for all the incoming
 * requests from REST APIs. Every public method maps an incoming request and
 * returns response as required/specified.
 * 
 * Annotation RestController ensures response generated will be converted to
 * JSON by default.
 * 
 * @author Simran Hotchandani
 *
 */
@RestController
public class APIController {

	private static final Logger logger = LoggerFactory.getLogger(APIController.class);
	/**
	 * Get UserService object UserService Dependency Injected
	 */
	@Autowired
	private UserService userService;

	/**
	 * Get List of Users Incoming Request with "/getUsers" is mapped to this method
	 * 
	 * @return list of all users available
	 */
	@GetMapping(value = "/getUsers")
	public ResponseEntity<List<User>> getUsers() {
		logger.debug("Inside Get Users Method ");
		return userService.getUsersList();
	}

	/**
	 * Gets User with specified Id Incoming Request with "/getUserById/{id}" is
	 * mapped to this method
	 * 
	 * @param id Integer representing User's id
	 * @return User with specified Id
	 */
	@GetMapping(value = "/getUserById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
		logger.debug("Inside Get User By Id Method ");
		return userService.getUserById(id);
	}
}
