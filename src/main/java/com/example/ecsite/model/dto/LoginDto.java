package com.example.ecsite.model.dto;

import com.example.ecsite.model.entity.User;

import lombok.Data;

// お客様サイトのログイン機能
@Data
public class LoginDto {
	
	private long id;
	private String userName;
	private String password;
	private String fullName;

	public LoginDto() {
		
	}
	
	public LoginDto(User user) {
		this.id = user.getId();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.fullName = user.getFullName();
	}
	
	public LoginDto(long id, String userName, String password, String fullName) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
	}
	
}
