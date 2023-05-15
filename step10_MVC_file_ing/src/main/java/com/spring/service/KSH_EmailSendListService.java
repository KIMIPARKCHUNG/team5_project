package com.spring.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.Email;
import com.spring.dto.EmailFile;
import com.spring.mapper.KSH_EmailSendMapper;
import com.spring.mapper.LJH_EmailMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KSH_EmailSendListService {
	@Autowired
	KSH_EmailSendMapper mapper;
	
	@Autowired
	SqlSession sqlSession;
	
	//EmailList
	public List<Email> getAllEmail(String email_address) {
//		System.out.println("mapper");
		List<Email> emailList =  mapper.getAllEmail2(email_address);
		
		return emailList;
	}

	public Email getEmailbyEmailId2(int emailId, String email_address) {
		return mapper.getEmailbyEmailId2(emailId, email_address);
	}

}
