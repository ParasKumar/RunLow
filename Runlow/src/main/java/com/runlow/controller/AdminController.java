package com.runlow.controller;
/**
 * This controller class is for Admin User. So all operations of admin are supposed to be start with /admin/ prefix.
 * eg. To create vehicle record, probably url end point might be /admin/create/vehicles
 * 
 * @author Paras.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/*")
public class AdminController {
	
	@RequestMapping("/hello")
	public String helloAdmin() {
		return "Welcome Admin";
	}

}
