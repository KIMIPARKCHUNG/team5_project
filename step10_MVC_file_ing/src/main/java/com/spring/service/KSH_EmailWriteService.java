package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.Dept;
import com.spring.dto.Email;
import com.spring.dto.EmailFile;
import com.spring.mapper.KSH_EmailWriteMapper;
import com.spring.mapper.LJH_EmailMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KSH_EmailWriteService {
	@Autowired
	KSH_EmailWriteMapper mapper;
	
	@Autowired
	SqlSession sqlSession;
	
	//EmailList
	public List<Email> getAllEmail() {
		return mapper.getAllEmail();
	}

	public boolean insertEmail(Email email) throws SQLException, Exception {
		boolean result = false;
		int res = mapper.insertEmail(email);
		if(res != 0) {
			result = true;
		} else {
			throw new Exception();
		}
		
		return result;
	}

}
