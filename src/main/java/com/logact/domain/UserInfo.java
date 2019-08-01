package com.logact.domain;

import java.util.Date;

public class UserInfo {
	private Integer id;
	private String username;
	private String password;
	private String gender;
	private Date create_time;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date createTime) {
		this.create_time = createTime;
	}
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", password=" + password + ", gender=" + gender + ", createTime="
				+ create_time + "]";
	}
	
}
