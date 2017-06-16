/**
 * 
 */
package com.example.springboot.userapp.consumer.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.springboot.userapp.consumer.data.vo.User;

/**
 * @author dpawar
 *
 */
@RestController
public class UserAppConsumerController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<User> req = new HttpEntity<>(user, headers);
		ResponseEntity<User> res = restTemplate.exchange("http://userapp/registerUser", HttpMethod.POST, req,
				User.class);
		return new ResponseEntity<>(res.getBody(), HttpStatus.OK);
	}

	@RequestMapping(value="/getUser",method=RequestMethod.GET)
	public ResponseEntity<User> getUser(@RequestParam int userID) {
		return restTemplate.getForEntity("http://userapp/getUser?userID=" + userID, User.class);
	}

}
