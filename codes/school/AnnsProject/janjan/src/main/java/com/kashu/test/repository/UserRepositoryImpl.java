package com.kashu.test.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.kashu.test.domain.User;

@Repository("userRepository")
@Transactional
public class UserRepositoryImpl implements UserRepository {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public User findByUsername(String username) {
		
		return null;
	}

	@Override
	public User save(User user) {
		manager.persist(user);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		 List<User> users = manager.createQuery("Select u From User u", User.class).getResultList();
    return users;
	}

}
