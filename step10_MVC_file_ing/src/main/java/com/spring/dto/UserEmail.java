package com.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserEmail {
	private String email_address;
	private String mem_name;
	private String password;
	
	public UserEmail(String email_address,String mem_name) {
		this.email_address = email_address;
		this.mem_name = mem_name;
	}
	
}
