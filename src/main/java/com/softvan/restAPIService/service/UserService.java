package com.softvan.restAPIService.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.softvan.restAPIService.model.User;

/**
 * This is the service interface, the class implementing it will contain
 * business/data logic to get User's details. 
 * 
 * @author Simran Hotchandani
 *
 */
public interface UserService {

	/**Gets list of users
	 * 
	 * @return list of users wrapped around response entity
	 */
	public ResponseEntity<List<User>> getUsersList();

	/**Gets user with specified Id
	 * 
	 * @param id Integer representing User's id
	 * @return User with specified Id
	 */
	public ResponseEntity<User> getUserById(Integer id);
}
