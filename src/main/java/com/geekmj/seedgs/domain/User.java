package com.geekmj.seedgs.domain;

import java.io.Serializable;

public class User implements Serializable {
	
	private Integer userId;
	private String name;
	private String email;
	private String password;
	
	private static final long serialVersionUID = 1L;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserid() {
		return userId;
	}

	public void setUserid(Integer userid) {
		this.userId = userid;
	}
		
}
