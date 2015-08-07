package com.kashu.test.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Entity
//@Table(name="TB_ROLES")
//@IdClass(value=RoleId.class)
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//@Id
	//@ManyToOne
	//@JoinColumn(name = "username", referencedColumnName = "username")
	private User user;
	
	//@Id
	//@Column(name="ROLE")
	private String ROLE;
	
	public Role(){
		
	}
	
	public Role(String ROLE){
		this.ROLE = ROLE;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getROLE() {
		return ROLE;
	}
	public void setROLE(String ROLE) {
		this.ROLE = ROLE;
	}
	
}
