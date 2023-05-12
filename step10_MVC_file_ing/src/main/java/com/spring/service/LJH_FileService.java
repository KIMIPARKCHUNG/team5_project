package com.spring.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.Email;
import com.spring.dto.EmailFile;
import com.spring.mapper.LJH_EmailMapper;
import com.spring.mapper.LJH_FileMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LJH_FileService {
	@Autowired
	LJH_FileMapper mapper;
	
	@Autowired
	SqlSession sqlSession;

	public List<EmailFile> getFilebyEmailId(int emailId) {
		return mapper.getFilebyEmailId(emailId);
	}
}
