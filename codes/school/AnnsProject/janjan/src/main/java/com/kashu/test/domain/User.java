package com.kashu.test.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name="TB_USER")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Transient
	private String cpassword;
	
	@Column(name="email")
	private String email;
	
	@Column(name="nickname")
	private String nickname;
	
	@Column(name="realname")
	private String realname;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="birthday")
	private Date birthday;
	
	@Column(name="telephone")
	private String telephone;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="zipcode")
	private String zipcode;
	
	@Column(name="address")
	private String address;
	
	@Column(name="createdTime")
	private Date createdTime;
	
	@Column(name="lastModified")
	private Date lastModified;
	
	@Column(name="errorCounters")
	private Integer errCounters;
	
	@Column(name="enabled")
	private Integer enabled;
	
	public User(){
		
	}
	
	public User(String username,String password,String email){
		this.username = username;
		this.password = password;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	
}
