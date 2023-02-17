package com.springbootbackendapp.service;

import java.util.List;

import com.springbootbackendapp.model.User;

public interface UserService {

	User createUser(User user);

	User updateUser(User user, Integer id);

	User getUserById(Integer id);

	List<User> getAllUsers();

	void deleteUser(Integer id);
}
