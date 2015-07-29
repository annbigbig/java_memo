package com.kashu.test.domain;

import java.util.Date;

public class Member {
	private String membername = "";
	private String password = "";
	private String cpassword = "";
	private String email = "";
	private Date birthday;
	private Integer testint;
	private Double testdouble;
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
