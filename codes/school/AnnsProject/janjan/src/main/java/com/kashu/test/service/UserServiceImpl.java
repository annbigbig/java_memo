package com.kashu.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kashu.test.repository.UserRepository;
import com.kashu.test.domain.User;

//@Service
public class UserServiceImpl implements UserService{
	//@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User user) {
		User u = null;
		try{
		   u = userRepository.save(user);
		}catch(Exception e){
			  e.printStackTrace();
		}
		return u;
	}
	
	@Override
	public User update(User user){
		User u = null;
		try{
			   u = userRepository.update(user);
			}catch(Exception e){
				  e.printStackTrace();
			}
			return u;
	}

	@Override
	public User findByUsername(String username) {
	  User user = null;
	  try{
		   user = userRepository.findByUsername(username);
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	  return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = null;
		try{
		   users = userRepository.getAllUsers();
		}catch(Exception e){
			e.printStackTrace();
		}
		return users;
	}

}
