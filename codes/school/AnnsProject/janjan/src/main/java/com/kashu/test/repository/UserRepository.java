package com.kashu.test.repository;

import java.util.List;

import com.kashu.test.domain.User;

public interface UserRepository {
  User findByUsername(String username);
	
	 User save(User user);
	 
	 User update(User user);
	
	List<User> getAllUsers();
}
