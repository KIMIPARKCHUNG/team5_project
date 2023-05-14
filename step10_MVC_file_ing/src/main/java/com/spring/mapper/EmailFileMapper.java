package com.spring.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.AttachmentFile;
import com.spring.dto.EmailFile;

@Mapper
public interface EmailFileMapper {
	
	EmailFile getEmailFileByEmailId(int email_id) throws SQLException;
	int insertEmailFile(EmailFile emailFile) throws SQLException;
	
}
