/**
 * 
 */
package com.example.springboot.userapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.userapp.data.entity.User;
import com.example.springboot.userapp.data.vo.Registration;
import com.example.springboot.userapp.service.UserService;

/**
 * @author dpawar
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ResponseEntity<Registration> registerUser(@RequestBody Registration registration) {
		return new ResponseEntity<>(userService.registerUser(registration), HttpStatus.OK);
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@RequestParam Integer userID) {
		return new ResponseEntity<>(userService.getUser(userID), HttpStatus.OK);
	}

}
