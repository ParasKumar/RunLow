package com.runlow.controller;

import org.springframework.http.ResponseEntity;

/**
 * This controller class is for Passenger User. So all operations of Passengers are supposed to be start with /passenger/ prefix.
 * eg. To create a booking record probable url end point might be /passenger/create/booking
 * 
 * @author Paras.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passenger/*")
public class PassengerController {
	
	public ResponseEntity<String> book() {
		return null;
	}
}
