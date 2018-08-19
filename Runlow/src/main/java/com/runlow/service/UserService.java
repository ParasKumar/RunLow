package com.runlow.service;

import java.util.List;

import com.runlow.model.User;

public interface UserService {
	public User findByFirstName(String firstName);
	public User saveUser(User user, String role);
	public List<User> getAllUsers();
}
