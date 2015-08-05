package com.kashu.test.repository;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kashu.test.domain.Role;
import com.kashu.test.domain.User;

//@Repository("userRepository")
//@Transactional
public class UserRepositoryImpl implements UserRepository {
	//@PersistenceContext
	private EntityManager manager;

	@Override
	public User findByUsername(String username) {
		return manager.find(User.class, username);
	}

	@Override
	public User save(User user) {
		//try{
		  manager.persist(user);
		//}catch(Exception e){
			//user = null;
			//e.printStackTrace();
			//System.out.println(e.getMessage());
		//}
		return user;
	}
	
	@Override
	public User update(User user){
		//manager.getEntityManagerFactory().getCache().evictAll();
		//manager.merge(user);
		//manager.refresh(user);
		//manager.flush();
		//manager.getTransaction().begin();
		//User managedUser = manager.find(User.class, user.getUsername());  //working1
		//managedUser.removeRole(new Role("ROLE_ADMIN"));
		/*
		Iterator<Role> it = managedUser.getRoles().iterator();
		while(it.hasNext()){
			if(it.next().getROLE().equals("ROLE_ADMIN")){
				it.remove();
			}
		}
		*/
		/*
		for(Role r : managedUser.getRoles()){
			if(r.getROLE().equals("ROLE_ADMIN")){
				managedUser.removeRole(r);
			}
		}
		*/
		//managedUser.getRoles().clear();
		/*
		for(Role r : managedUser.getRoles()){
			if(r.getROLE().equals("ROLE_ADMIN")){
				managedUser.removeRole(r);
			}
		}
		*/
		
		//manager.getTransaction().commit();
		//managedUser.setAddress("我家就在士東路333號");  //working2
		//manager.getTransaction().commit();
		//manager.flush();  //working3
		//manager.merge(managedUser);
		//The contains method can check if a specified entity object is in the persistence context
		//if(manager.contains(user)){
			//System.out.println("manager.flush(user) was called ...");
			//manager.flush();
		//}else{
			//System.out.println("manager.merge(user) was called ...");
			manager.merge(user);
		//}
		//return managedUser; //working4
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		 List<User> users = manager.createQuery("Select u From User u", User.class).getResultList();
    return users;
	}

}
