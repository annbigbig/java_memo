package com.kashu.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kashu.domain.User;

@Repository("userRepository")
public class UserRepositoryImpl extends GenericDaoImpl<User> implements UserRepository{
	 
}
