package com.springbootbackendapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootbackendapp.exception.UserNotFoundException;
import com.springbootbackendapp.model.User;
import com.springbootbackendapp.repository.UserRepository;
import com.springbootbackendapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public User getUsernameByPassword(String username, String password) throws UserNotFoundException {
		User user = userRepository.findByUsernameAndPassword(username, password);
		if (user == null) {
			throw new UserNotFoundException("Invalid id and password");
		}
		return user;
	}
}