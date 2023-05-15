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
	
	public UserEmail getUserByEmailaddressAndPassword(String email_address, String password) throws SQLException, Exception {
		
		UserEmail user = mapper.getUserByEmailaddressAndPassword(email_address, password);
		
		if(user == null) {
			throw new Exception("비밀번호가 틀렸거나, 존재하지 않는 메일 정보입니다.");
		}
		
		return user;
	}
	
	
	
}
