/**
 * 
 */
package com.self.spring.security.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.self.spring.security.entity.User;

public interface UserService extends UserDetailsService {

	User getById(Integer id);

	User getByName(String name);

	List<User> getAll();

	void removeRole(String name, String role);

}
