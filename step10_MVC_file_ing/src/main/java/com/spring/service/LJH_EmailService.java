package com.spring.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.Email;
import com.spring.dto.EmailFile;
import com.spring.mapper.LJH_EmailMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LJH_EmailService {
	@Autowired
	LJH_EmailMapper mapper;
	
	@Autowired
	SqlSession sqlSession;
	
	//EmailList
	public List<Email> getAllEmail() {
//		System.out.println("mapper");
		List<Email> emailList =  mapper.getAllEmail();
		
		return emailList;
	}

	public Email getEmailbyEmailId(int emailId) {
		return mapper.getEmailbyEmailId(emailId);
	}

	public void updateIsRead(int emailId) {
		mapper.updateIsRead(emailId);	
	}

	public void deleteEmailByEmailId(int emailId) {
		mapper.deleteEmailByEmailId(emailId);
		
	}

	public List<Email> getAllDeleteEmail() {
		return mapper.getAllDeleteEmail();
	}
}
