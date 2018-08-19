package com.runlow.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller class handles booking related operations for both driver and passener 
 * */
@RestController
@RequestMapping("/booking/*")
public class BookingController {
	@RequestMapping("/search/driver/{user_current_latitude}/{user_current_longitude}")
	public void searchDriver(@PathVariable("user_current_latitude") String userCurrentLatitude, @PathVariable("user_current_longitude") String userCurrentLongitude) {
		// find the list of all drivers who are near to current user who is searching driver for booking
		
	}
	
	@RequestMapping("/driver/confirm_booking/{user_id}")
	public void confirmBookinglFromDriverSide(@PathVariable("user_id") String userId) {
		
	}
	
	@RequestMapping("/driver/cancel_booking/{user_id}/{booking_id}/{cancel_reason}")
	public void cancelBookingFromDriverSide(@PathVariable("user_id") String userId, @PathVariable("booking_id") String bookingId, @PathVariable("cancel_reason") String cancelReason) {
		
		
	}
	
	@RequestMapping("/passenger/confirm_booking/{user_id}")
	public void confirmBookingFromPassengerSide(@PathVariable("user_id") String userId) {
		
	}
	
	@RequestMapping("/passenger/cancel_booking/{user_id}/{booking_id}/{cancel_reason}")
	public void cancelBookingFromPassengerSide(@PathVariable("user_id") String userId, @PathVariable("booking_id") String bookingId, @PathVariable("cancel_reason") String cancelReason) {
		
	}
}
