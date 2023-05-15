package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.spring.dto.Email;

@Mapper
public interface LJH_EmailMapper {


	public Email getEmailbyEmailId(@Param("emailId") int emailId, @Param("email_address") String email_address);

	public void updateIsRead(int emailId);


	public List<Email> getAllEmail(String email_address);

	public void deleteEmailByEmailId(int emailId);

	public List<Email> getAllDeleteEmail(String email_address);

}
