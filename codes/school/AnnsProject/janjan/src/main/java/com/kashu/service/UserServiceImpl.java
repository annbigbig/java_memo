package com.kashu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kashu.domain.Role;
import com.kashu.domain.User;
import com.kashu.repository.UserRepository;

@Service
//@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User create(User user) {
		User result = null;
		try{
		  result = userRepository.create(user);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public User update(User user) {
		User result = null;
		try{
		  result = userRepository.update(user);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public User delete(User user){
		User result = user;
		try{
			  userRepository.delete(user.getId());
			}catch(Exception e){
				result = null;
				e.printStackTrace();
			}
		return result;
	}
	

	public User findByUsername(String username) {
		User result = null;
		try{
			result = userRepository.findByUsername(username);
		}catch(Exception e){
			e.printStackTrace();
		}
	  return result;
	}
	
 @Override
	public User findById(Long id){
		return userRepository.find(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.listAll();
	}

}
