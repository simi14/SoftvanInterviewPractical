package com.softvan.restAPIService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main/primary class of restAPIService application which spring boot
 * application will get executed i.e. the entry point.
 * 
 * @author Simran
 *
 */
@SpringBootApplication
public class RestApiServiceApplication {

	/**Responsible for bootstrapping and launching spring application.
	 * @param args represents command line arguments 
	 */
	public static void main(String[] args) {
		SpringApplication.run(RestApiServiceApplication.class, args);
	}

}
