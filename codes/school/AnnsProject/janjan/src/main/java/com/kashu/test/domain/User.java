package com.kashu.test.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

//@Entity
//@Table (name="TB_USERS")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	//@Id
	//@Column(name="username")
	private String username;
	
	//@Column(name="password")
	private String password;
	
	//@Transient
	private String cpassword;
	
	//@Column(name="email")
	private String email;
	
	//@Column(name="nickname")
	private String nickname;
	
	//@Column(name="realname")
	private String realname;
	
	//@Column(name="gender")
	private String gender;
	
	//@Column(name="birthday")
	private Date birthday;
	
	//@Column(name="telephone")
	private String telephone;
	
	//@Column(name="mobile")
	private String mobile;
	
	//@Column(name="zipcode")
	private String zipcode;
	
	//@Column(name="address")
	private String address;
	
	//@Column(name="createdTime")
	private Date createdTime;
	
	//@Column(name="lastModified")
	private Date lastModified;
	
	//@Column(name="errorCounters",columnDefinition = "TINYINT")
	private Integer errorCounters;
	
	//@Column(name="enabled",columnDefinition = "TINYINT")
	//@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean enabled;
	
	//@ElementCollection
	//@CollectionTable(name = "Role", joinColumns = @JoinColumn(name = "ROLE"))
	//@OneToMany(fetch = FetchType.EAGER, mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true)
	@OneToMany(fetch = FetchType.EAGER, mappedBy="user", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Role> roles = new ArrayList<Role>();
	//private Set<Role> roles = new HashSet<Role>();
	
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
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void addRole(Role role){
		role.setUser(this);
		roles.add(role);
	}
	
	/*
	public void removeRole(Role role){
		//look here
		//http://stackoverflow.com/questions/19494541/i-am-trying-to-remove-item-from-list-but-i-am-gettin-concurrent-modification-exc
		//http://www.iteye.com/topic/124788
		String roleNameToBeRemoved = role.getROLE();
		Iterator<Role> it = getRoles().iterator();
		while(it.hasNext()){
			Role roleTemp = it.next();
			if(roleTemp.getROLE().equals(roleNameToBeRemoved)){
				//roleTemp.setUser(this);
				it.remove();
			}
		}
		*/
	
	public void removeRole(Role role){
		role.setUser(null);
		roles.remove(role);
		//http://www.iteye.com/topic/124788

	}
	
}
