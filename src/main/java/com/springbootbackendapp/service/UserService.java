package com.springbootbackendapp.service;

import org.springframework.stereotype.Service;

import com.springbootbackendapp.exception.UserNotFoundException;
import com.springbootbackendapp.model.User;

@Service
public interface UserService {

	public void saveUser(User user);

	public User getUsernameByPassword(String username, String password) throws UserNotFoundException;
}
