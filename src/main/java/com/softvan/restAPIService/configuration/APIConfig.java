package com.softvan.restAPIService.configuration;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.softvan.restAPIService.model.User;


/**This class acts as Configuration/Bean Instantiations for all API related code.
 * @author Simran Hotchandani
 *
 */
@Configuration
public class APIConfig {

	private static final Logger logger = LoggerFactory.getLogger(APIConfig.class);
	/**Creates a singleton bean of List of Users
	 * @return list of user's instantiated
	 */
	@Bean
	@Scope("singleton")
	public List<User> usersList(){
		logger.info("Creating List of Users");
		List<User> userList=new ArrayList<>();
		userList.add(new User(1, "Simran", "Hotchandani", "Simi", "simran@gmail.com","female"));
		userList.add(new User(2, "Pratha", "Patel", "Pratha", "pratha@gmail.com","female"));
		userList.add(new User(3, "Bhavika", "Balani", "Bhavika", "bhavika@gmail.com","female"));
		logger.info("List of Users Created");
		return userList;
	}
}
