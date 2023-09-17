package com.learn.payloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDTO {

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int id;
	@NotEmpty
	@Size(min = 4, message = "User name must have 4 characters")
	private String name;
	@Email(message = "Email address is not valid")
	private String emailId;

	@NotEmpty(message = "Password is not valid")
	@Size(min = 5, message = "Password size should be atleast 5 Character")
	private String password;

	@NotEmpty(message = "About cannot be blank")
	@Size(min = 10, message = "About should have atleast 10 Character")
	private String about;
	
	private Set<RoleDto> roles = new HashSet<>();

	public Set<RoleDto> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleDto> roles) {
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

}
