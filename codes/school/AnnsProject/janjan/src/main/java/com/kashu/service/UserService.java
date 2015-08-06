package com.kashu.service;

import java.util.List;

import com.kashu.domain.User;

public interface UserService {
		User create(User user);
		User update(User user);
		User refresh(User user);
		User findByUsername(String username);
		List<User> getAllUsers();
}
