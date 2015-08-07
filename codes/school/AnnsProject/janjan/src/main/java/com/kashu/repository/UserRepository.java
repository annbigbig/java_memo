package com.kashu.repository;

import com.kashu.domain.User;

public interface UserRepository extends GenericDao<User>{
	 User findByUsername(String username);
}
