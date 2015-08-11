package com.kashu.repository;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kashu.domain.User;

@Repository("userRepository")
@Transactional
public class UserRepositoryImpl extends GenericDaoImpl<User> implements UserRepository{

	@Override
	public User findByUsername(String username) {
		
		Query query = this.manager.createQuery("select u FROM User u where u.username= :username");
        query.setParameter("username", username);
        List<User> users = query.getResultList();
        if (users != null && users.size() == 1) {
            return users.get(0);
            }
        return null;
	}
	 
}
