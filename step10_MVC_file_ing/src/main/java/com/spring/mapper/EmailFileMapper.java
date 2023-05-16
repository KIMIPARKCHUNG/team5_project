package com.spring.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;


import com.spring.dto.EmailFile;


@Mapper
public interface EmailFileMapper {
	
	Optional<List<EmailFile>> getEmailFileByEmailId(int email_id) throws SQLException;
	int insertEmailFile(EmailFile emailFile) throws SQLException;
	EmailFile getEmailFileByFileId(int file_id)throws SQLException;
	
}
