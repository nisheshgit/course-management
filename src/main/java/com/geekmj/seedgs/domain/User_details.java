package com.geekmj.seedgs.domain;

import java.io.Serializable;
import java.sql.Time;

//
//@lombok.Getter
//@lombok.Setter
//@lombok.AllArgsConstructor
//@lombok.ToString

//@lombok.Data
public class User_details implements Serializable {
	
	private Long userId;
	private String Name;
	private Integer age;
	private String role;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	private static final long serialVersionUID = 1L;
		
}
