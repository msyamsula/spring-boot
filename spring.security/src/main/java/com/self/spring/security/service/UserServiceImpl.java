package com.self.spring.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.self.spring.security.entity.Role;
import com.self.spring.security.entity.User;
import com.self.spring.security.exception.UserNotFound;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	private SessionFactory sessionFactory;

	public UserServiceImpl() {
	}
	
	// these two methods is necessary
	// public UserDetails is to tell spring security about user and roles mapping
	// pivate collection extends grant authority is a helper function to map user roles
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// get user
		User user = this.getByName(username);
		if (user == null) {
			throw new UsernameNotFoundException("not found");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public User getById(Integer id) {
		String queryString = String.format("from User u where u.id=%d", id);
		Session session = sessionFactory.getCurrentSession();
		
		List<User> users = session.createQuery(queryString, User.class).getResultList();
		
		if (users.size() == 0) {
			// if not found throw to UserException
			String message = String.format("Customer id %d not found", id);				
			throw new UserNotFound(message);
		}
		
//		System.out.println(users);
		
		return users.get(0);
	}
	
	@Override
	@Transactional
	public User getByName(String username) {
		String queryString = String.format("from User u where u.name='%s'", username);
		Session session = sessionFactory.getCurrentSession();
		
//		List<User> users = session.createQuery(queryString).getResultList();
//		System.out.println(users);
		User user = session.createQuery(queryString, User.class).getSingleResult();
		
		if (user == null) {
			return null;
		}
		
//		List<Role> roles = user.getRoles();
		
//		for(Role role : roles) {
//			System.out.println(role.getName());
//		}
		
		return user;
	}

	@Override
	@Transactional
	public List<User> getAll() {
		String queryString = String.format("from User");
		Session session = sessionFactory.getCurrentSession();
		
		List<User> users = session.createQuery(queryString, User.class).getResultList();
		
		return users;
	}

	@Override
	@Transactional
	public void removeRole(String name, String role) {
		Session session = sessionFactory.getCurrentSession();
		
		String properRole = String.format("ROLE_%S", role.toUpperCase());
		User user = this.getByName(name);
		
		List<Role> newRoles = new ArrayList<Role>();
		
		List<Role> roles = user.getRoles();
		
		for(Role r : roles) {
			System.out.println(r.getName());
			System.out.println(properRole);
			System.out.println((r.getName().equals(properRole)));
			if (r.getName().equals(properRole)) {
				continue;
			}
//			System.out.println(r.getName());
			newRoles.add(r);
		}
		
		user.setRoles(newRoles);
		
		session.save(user);
	}

}
