package com.kashu.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class User {
	
	@NotNull
	@Size(min=6,max=14)
	private String username;
	
	@NotNull
	@Size(min=6,max=14)
	private String password;
	
	@NotNull
	@Size(min=6,max=14)
	private String cpassword;
	
	@NotNull
	@Email
	private String email;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
