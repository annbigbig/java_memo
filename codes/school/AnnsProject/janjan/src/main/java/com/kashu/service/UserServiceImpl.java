package com.kashu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kashu.domain.User;
import com.kashu.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User create(User user) {
		return userRepository.create(user);
	}

	@Override
	public User update(User user) {
		return userRepository.update(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.find(username);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.listAll();
	}

}
