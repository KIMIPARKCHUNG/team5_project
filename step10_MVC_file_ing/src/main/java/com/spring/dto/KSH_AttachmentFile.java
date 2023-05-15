package com.spring.dto;

import java.sql.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class KSH_AttachmentFile {
    private int file_id;
    private int email_id;
    private String path;
    private String uuid;
    private String file_subject;
    private Long file_size;
    private Date file_date;
}

