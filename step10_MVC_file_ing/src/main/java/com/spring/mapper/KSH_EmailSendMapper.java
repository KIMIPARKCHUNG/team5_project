package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.spring.dto.Email;

@Mapper
public interface KSH_EmailSendMapper {


	public Email getEmailbyEmailId2(@Param("emailId") int emailId, @Param("email_address") String email_address);

	public List<Email> getAllEmail2(String email_address);


}
