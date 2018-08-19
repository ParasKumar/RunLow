package com.runlow.controller;

/**
 * This controller class is for Driver User. So all operations of Drivers are supposed to be start with /driver/ prefix.
 * eg. To create a rating record, probable url end point might be /driver/create/rating
 * 
 * @author Paras.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/driver/*")
public class DriverController {

}
