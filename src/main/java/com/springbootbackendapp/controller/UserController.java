package com.springbootbackendapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootbackendapp.exception.UserNotFoundException;
import com.springbootbackendapp.model.User;
import com.springbootbackendapp.config.JwtGeneratorInterface;
import com.springbootbackendapp.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private JwtGeneratorInterface jwtGenerator;
	@Autowired
	private UserService userService;

	@Autowired
	private JwtGeneratorInterface jwtGenerator;

//	@Autowired
//	public UserController(UserService userService, JwtGeneratorInterface jwtGenerator) {
//		this.userService = userService;
//		this.jwtGenerator = jwtGenerator;
//	}

	@PostMapping("/register")
	public ResponseEntity<?> postUser(@RequestBody User user) {
		try {
			userService.saveUser(user);
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	public ResponseEntity<?> loginUser(@RequestBody User user) {
		try {
			if (user.getUsername() == null && user.getPassword() == null) {
				throw new UserNotFoundException("Username or Password is empty");
			}
			User userData = userService.getUsernameByPassword(user.getUsername(), user.getPassword());
			if (userData == null) {
				throw new UserNotFoundException("Username or password is invalid");
			}

			return new ResponseEntity<>(jwtGenerator.generateToken(user), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
}
