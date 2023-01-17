package com.softvan.restAPIService.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.softvan.restAPIService.exception.NoSuchResourceFoundException;
import com.softvan.restAPIService.model.User;

/**
 * This is a implementation of User service class interface with all
 * business/data logic implemented exposed as REST APIs to Rest controller.
 * 
 * 
 * @author Simran Hotchandani
 *
 */
@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	/**
	 * Dependency Injected Using Constructor Injection
	 * 
	 * @param usersList The List of User's from singleton List of User bean
	 *                  instantiated
	 */
	public UserServiceImpl(List<User> usersList) {
		this.usersList = usersList;
	}

	private List<User> usersList;

	/**
	 * Get's List of all User
	 * 
	 * @return HTTP response with status code, headers body considering list of all
	 *         Users. If List of User is null, it returns response status as
	 *         NO_CONTENT.
	 */
	public ResponseEntity<List<User>> getUsersList() {
		logger.info("Inside Service getUsersList Method");
		if (usersList != null) {
			logger.debug("Fetching List of Users, found "+usersList.size()+" users");
			return new ResponseEntity<>(usersList, HttpStatus.OK);
		} else {
			logger.debug("Fetching List of Users, no user found");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	/**
	 * Get's User with Id
	 * @param Integer representing User's id
	 * @return HTTP response with status code, headers body considering User with
	 *         specified id.
	 * @throws NoSuchResourceFoundException If user with specified id doesn't exist,
	 *                                      it throws a custom error stating no such
	 *                                      id exists.
	 */
	public ResponseEntity<User> getUserById(Integer id) {
		logger.info("Inside Service getUserById Method");
		Optional<User> user = usersList.stream().filter(currentUser -> currentUser.getId().equals(id)).findFirst();
		if (user.isPresent()) {
			logger.debug("User with id "+id+" found");
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		} else {
			logger.error("No such User exists with id "+id);
			throw new NoSuchResourceFoundException("No User exists with id " + id);
		}
	}
}
