package com.kashu.test.service;

import java.util.List;

import com.kashu.test.domain.User;

public interface UserService {
	User save(User user);
	User update(User user);
	User findByUsername(String username);
	List<User> getAllUsers();
}
