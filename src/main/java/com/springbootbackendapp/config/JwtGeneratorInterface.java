package com.springbootbackendapp.config;

import java.util.Map;

import com.springbootbackendapp.model.User;

public interface JwtGeneratorInterface {

	Map<String, String> generateToken(User user);
}
