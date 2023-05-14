package com.spring.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmailFile {
private int file_id; // 파일 번호 
private int email_id; // 보낸 이메일 주소
private String path; //해당 파일이 저장된 경로
private String uuid; // 파일명 
private String file_subject; //정한 파일 이름
private long file_size; // 파일 크기
private Date file_date; // 전송 날짜
@Builder
public EmailFile(int file_id, int email_id,String path, String uuid, String file_subject, long file_size, Date file_date){
	this.file_id = file_id;
	this.email_id= email_id;
	this.path = path;
	this.uuid =uuid;
	this.file_subject =file_subject;
	this.file_size = file_size;
	this.file_date = file_date;
	
	
}

}
