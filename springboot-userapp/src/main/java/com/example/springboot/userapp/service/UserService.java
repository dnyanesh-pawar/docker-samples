/**
 * 
 */
package com.example.springboot.userapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.userapp.data.entity.User;
import com.example.springboot.userapp.data.vo.Registration;
import com.example.springboot.userapp.repository.UserRepository;

/**
 * @author dpawar
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * 
	 * @param userVO
	 */
	public Registration registerUser(Registration registration) {
		User user = new User();
		user.setUserId(registration.getUserId());
		user.setName(registration.getName());
		user.setEmail(registration.getEmail());
		userRepository.save(user);
		return registration;
	}

	/**
	 * 
	 * @param userID
	 * @return
	 */
	public User getUser(int userID) {
		return userRepository.findOne(userID);
	}

}
