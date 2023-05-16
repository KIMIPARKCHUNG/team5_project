package com.spring.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;


import com.spring.dto.EmailFile;
import com.spring.dto.KSH_AttachmentFile;

@Mapper
public interface KSH_AttachmentFileMapper {
	
	EmailFile getAttachmentFileByFileNo(int fileNo) throws SQLException;

	int insertAttachmentFile(KSH_AttachmentFile attachmentFile) throws SQLException;
	KSH_AttachmentFile getAttachmentFileByEmailId(int email_id);

	
}
