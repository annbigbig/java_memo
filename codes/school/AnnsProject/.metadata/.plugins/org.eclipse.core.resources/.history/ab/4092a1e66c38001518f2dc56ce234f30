package com.kashu.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kashu.test.repository.UserRepository;
import com.kashu.test.domain.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}

}
