package com.kashu.domain;

import java.util.Date;

public class User {
	
	private String username;
	private String password;
	private String cpassword;
	private String email;
	private String nickname;
	private String realname;
	private String gender;
	private Date birthday;
	private Integer testint;
	private Double testdouble;
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getTestint() {
		return testint;
	}
	public void setTestint(Integer testint) {
		this.testint = testint;
	}
	public Double getTestdouble() {
		return testdouble;
	}
	public void setTestdouble(Double testdouble) {
		this.testdouble = testdouble;
	}
	
}
