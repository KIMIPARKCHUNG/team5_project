package com.spring.service;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import com.spring.dto.KSH_AttachmentFile;


import com.spring.mapper.KSH_AttachmentFileMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KSH_AttachmentFileService {
	
	@Autowired
	KSH_AttachmentFileMapper attachmentFileMapper;
	

	
	// insert - 
	public boolean insertAttachmentFile(MultipartFile file, int email_id) throws SQLException, Exception {
	    boolean result = false;

    if (!file.isEmpty()) {
//	        throw new Exception("File is null");

	    String file_subject = file.getOriginalFilename();
	    String uuid = UUID.randomUUID().toString();
	    String path = "C:\\multi\\00.spring\\newFiles\\" + uuid + "_" + file_subject;
	    Long file_size = file.getSize();

	    KSH_AttachmentFile attachmentFile = KSH_AttachmentFile.builder()
	            .email_id(email_id)
	            .path(path)
	            .uuid(uuid)
	            .file_subject(file_subject)
	            .file_size(file_size)
	            .build();

	    int res = attachmentFileMapper.insertAttachmentFile(attachmentFile);

	    if (res != 0) {
	        File dir = new File("C:\\multi\\00.spring\\newFiles\\");
	        if (!dir.exists()) {
	            dir.mkdirs();
	        }
	        file.transferTo(new File(path));
	        result = true;
	    } else {
	        throw new Exception();
	    }
    }
	    return result;
	}


	public KSH_AttachmentFile getAttachmentFileByEmailId(int email_id){
		KSH_AttachmentFile attachmentFile = null;
//		if(deptno == null) {
//			throw Exception("");
//		}
		attachmentFile =attachmentFileMapper.getAttachmentFileByEmailId(email_id);
		return attachmentFile;
	}
	
}