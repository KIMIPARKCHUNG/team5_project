package com.spring.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmailFile {
int file_id;
int email_id;
String path;
String uuid;
String file_subject;
int file_size;
Date file_date;
}
