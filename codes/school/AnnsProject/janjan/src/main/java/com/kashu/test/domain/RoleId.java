package com.kashu.test.domain;

import java.io.Serializable;

public class RoleId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String user;
	private String ROLE;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getROLE() {
		return ROLE;
	}
	public void setROLE(String ROLE) {
		this.ROLE = ROLE;
	}
	
}
