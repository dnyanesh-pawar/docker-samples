/**
 * 
 */
package com.example.springboot.userapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springboot.userapp.data.entity.User;

/**
 * @author dpawar
 *
 */
public interface UserRepository extends CrudRepository<User, Integer> {

}
