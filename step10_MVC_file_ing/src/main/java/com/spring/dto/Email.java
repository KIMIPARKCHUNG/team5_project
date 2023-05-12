package com.spring.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Email {
	private int emial_id;
	private String sender_id;
	private String recipient_id;
	private String email_subject;
	private String body;
	private char is_read;
	private char is_delete;
	private Date send_date;
	
}
