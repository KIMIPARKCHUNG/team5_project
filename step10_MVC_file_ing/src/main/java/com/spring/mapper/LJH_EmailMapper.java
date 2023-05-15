package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.dto.Email;

@Mapper
public interface LJH_EmailMapper {


	public Email getEmailbyEmailId(int emailId);

	public void updateIsRead(int emailId);

	public List<Email> getAllEmail();
}
