package com.kashu.test.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Entity
@Table (name="TB_USERS")
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
	
	@Column(name="errorCounters",columnDefinition = "TINYINT")
	private Integer errorCounters;
	
	@Column(name="enabled",columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean enabled;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="user",cascade = CascadeType.ALL)
	private Set<Role> roles;
	
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Integer getErrorCounters() {
		return errorCounters;
	}

	public void setErrorCounters(Integer errorCounters) {
		this.errorCounters = errorCounters;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
