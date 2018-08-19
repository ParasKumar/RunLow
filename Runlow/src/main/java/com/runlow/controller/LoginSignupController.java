package com.runlow.controller;

/**
 * This controller class is for all Users to either login or sign-up. So all operations
 * 
 * @author Paras.
 */

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.runlow.constants.RoleConstant;
import com.runlow.model.User;
import com.runlow.service.UserService;

@RestController
public class LoginSignupController {
	@Autowired
	private UserService userService;
	
	/**
	 * This method will create new driver user. This method will be called when the api end point will end with /driver/registration
	 * @param user : the request body of User object
	 * */
	@RequestMapping(value = "/user/driver/registration", method = RequestMethod.POST)
	public User createDriverUser(@RequestBody @Valid User user) {
		User userExists = userService.findByFirstName(user.getFirstName());
		System.out.println("first Name " + user.getFirstName());
		return userService.saveUser(user, RoleConstant.ROLE_DRIVER);
	}
	
	/**
	 * This method will create new passenger user. This method will be called when the api end point will end with /passenger/registration
	 * @param user : the request body of User object
	 * */
	@RequestMapping(value = "/user/passenger/registration", method = RequestMethod.POST)
	public User createPassengerUser(@RequestBody @Valid User user) {
		//User userExists = userService.findByFirstName(user.getFirstName());
		return userService.saveUser(user, RoleConstant.ROLE_PASSENGER);
	}
	
	/**
	 * This method is responsible to login operation
	 * */
	@RequestMapping("/login")
	public User login(@RequestBody @Valid User user) {
		
		return null;
	}
}
