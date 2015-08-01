package com.kashu.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kashu.domain.TestUser;
import com.kashu.domain.User;

@Repository("userRepository")
@Transactional
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public TestUser findByUsername(String username) {
		
		return null;
	}

	@Override
	public TestUser save(TestUser user) {
		
		return null;
	}

	@Override
	public List<TestUser> getAllUsers() {
		List<TestUser> users = manager.createQuery("Select u From TestUser u", TestUser.class).getResultList();
        return users;
	}

}
