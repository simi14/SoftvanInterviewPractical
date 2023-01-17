package com.softvan.restAPIService.model;

/**
 * A model class used to represent User
 * 
 * @author Simran Hotchandani
 *
 */
public class User {

	private Integer id;
	private String fname;
	private String lname;
	private String username;
	private String email;
	private String gender;

	/**
	 * Creates a user with specified Details
	 * 
	 * @param id       User's id
	 * @param fname    User's first name
	 * @param lname    User's last name
	 * @param username User's username
	 * @param email    User's email address
	 * @param gender   User's gender
	 *
	 */
	public User(Integer id, String fname, String lname, String username, String email, String gender) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.email = email;
		this.gender = gender;
	}

	/**
	 * Get User's id
	 * 
	 * @return an integer representing User's Id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Get User's firstname
	 * 
	 * @return a string representing User's firstname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * Get User's lastname
	 * 
	 * @return a string representing User's lastname
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * Get User's username
	 * 
	 * @return a string representing User's Username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Get User's email id
	 * 
	 * @return a string representing User's email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Get User's gender
	 * 
	 * @return a string representing User's gender
	 */
	public String getGender() {
		return gender;
	}

}
