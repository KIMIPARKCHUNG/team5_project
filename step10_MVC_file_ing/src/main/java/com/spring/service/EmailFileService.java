package com.spring.service;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.spring.dto.EmailFile;

import com.spring.mapper.EmailFileMapper;

import lombok.extern.slf4j.Slf4j;
@Service
public class EmailFileService {
	
		

		
		@Autowired
		EmailFileMapper emailFileMapper;
		
		// insert - 
		public boolean insertEmailFile(MultipartFile file, int email_id) throws SQLException, Exception {
			System.out.println("service");
			boolean result = false;
			
			if(file == null) {
				throw new Exception("파일 전달 오류 발생");
			}
			
			/* 파일을 저장하는 의미
			   1. DB 파일 정보 저장 - attFile 객체 생성 -> mapper -> db 저장
			   2. server에 파일이 실제로 저장  - multipartFile transferTo()
			 */
			
			String filePath = "C:\\multi\\00.spring";
			String file_subject = file.getOriginalFilename();
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString() + "_" + file_subject;
			long file_size = file.getSize();
			
			EmailFile emailFile = EmailFile.builder()
														.email_id(email_id)
														.file_subject(file_subject)
														.file_size(file_size)
														.path(filePath)
														.uuid(fileName)
														.build();
			System.out.println(email_id);
			int res = 1;
			res = emailFileMapper.insertEmailFile(emailFile);

	
			
			if(res != 0) {
				// 실제 서버에 저장되는 로직 추가!!! (attachmentFile.trasferTo())
				
				file.transferTo(new File(filePath + "\\" + fileName));
				result = true;
			} else {
				throw new Exception("파일 DB 저장 실패");
			}
			
			return result;
		}


		
	

	public List<EmailFile> getEmailFileByEmailId(int email_id) throws SQLException,Exception {
		List<EmailFile> emailFile = null;
			emailFile =	emailFileMapper.getEmailFileByEmailId(email_id);
	System.out.println(emailFile);
	if(emailFile == null) {
		throw new Exception("존재하지 않는 파일");
		}
		
		return emailFile;
	}





	public EmailFile getEmailFileByFileId(int file_id) throws Exception {
		// TODO Auto-generated method stub
		EmailFile emailFile = null;
		emailFile =	emailFileMapper.getEmailFileByFileId(file_id);
System.out.println(emailFile);
if(emailFile == null) {
	throw new Exception("존재하지 않는 파일");
	}
	
	return emailFile;
	}
}
