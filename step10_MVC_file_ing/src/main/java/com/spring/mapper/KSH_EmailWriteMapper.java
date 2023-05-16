package com.spring.mapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import com.spring.dto.Email;

@Mapper
public interface KSH_EmailWriteMapper {
	
	// List
	public List<Email> getAllEmail();
	
	// insert - Dept
	public int insertEmail(Email email) throws SQLException;
	
	
}
