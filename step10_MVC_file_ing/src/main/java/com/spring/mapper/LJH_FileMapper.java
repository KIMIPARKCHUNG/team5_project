package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.dto.Email;
import com.spring.dto.EmailFile;

@Mapper
public interface LJH_FileMapper {

	List<EmailFile> getFilebyEmailId(int emailId);
	
}
