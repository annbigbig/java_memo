package com.kashu.repository;

import com.kashu.domain.User;

public interface UserRepository {

	User findByUsername(String username);
	
	User save(User user);
	
}
