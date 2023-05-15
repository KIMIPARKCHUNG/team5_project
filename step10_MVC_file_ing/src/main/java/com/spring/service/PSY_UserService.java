package com.spring.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.UserEmail;
import com.spring.mapper.PSY_UserMapper;

@Service
public class PSY_UserService {
	
	@Autowired
	PSY_UserMapper mapper;
	
	// insertUser - UserEmail
	public boolean insertUser(UserEmail newUser) throws SQLException, Exception {
		boolean result = false;
		
		int res = mapper.insertUser(newUser);
		
		if(res != 0) {
			result = true;
		} else {
			throw new Exception("회원가입에 실패했습니다. 다시 시도해주세요.");
		}
		
		return result;
	}
	
	// getUserByEmailaddressAndPassword - UserEmail
	public UserEmail getUserByEmail_addressAndPassword(String email_address, String password) throws SQLException, Exception {
		
		UserEmail user = mapper.getUserByEmail_addressAndPassword(email_address, password);
		
		if(user == null) {
			System.out.println("로그인 에러");
		}
		
		return user;
	}

	// getUserByEmail_address - UserEmail
	public UserEmail getUserByEmail_address(String email_address) throws SQLException, Exception {
		
		UserEmail user = mapper.getUserByEmail_address(email_address);
		System.out.println(user + "-service");
		if(user == null) {
			System.out.println("존재하지 않는 메일 주소");
		}
		
		return user;
	}
	
	
}
