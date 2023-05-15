DROP TABLE scott.user_email cascade constraint;
DROP TABLE scott.email cascade constraint;
DROP TABLE scott.email_file cascade constraint;
DROP SEQUENCE seq_email_id;
DROP SEQUENCE seq_file_id;

-- USER_EMAIL 테이블

CREATE TABLE scott.user_email (
    email_address VARCHAR2(20 BYTE) primary key,
    mem_name      VARCHAR2(20 BYTE) NOT NULL,
    password      VARCHAR2(20 BYTE) NOT NULL
);

-- EMAIL 테이블

CREATE TABLE scott.email (
    email_id      NUMBER primary key,
    sender_id     VARCHAR2(20 BYTE),
    recipient_id  VARCHAR2(20 BYTE),
    email_subject VARCHAR2(20 BYTE) NOT NULL,
    body          VARCHAR2(4000 BYTE) NOT NULL,
    is_read       CHAR(1 BYTE) NOT NULL,
    is_delete     CHAR(1 BYTE) NOT NULL,
    file_exist    CHAR(1 BYTE) NOT NULL,
    send_date     DATE NOT NULL
    
);

ALTER TABLE scott.email
    ADD CONSTRAINT email_user_email_fk FOREIGN KEY ( sender_id )
        REFERENCES scott.user_email ( email_address )
    NOT DEFERRABLE;

ALTER TABLE scott.email
    ADD CONSTRAINT email_user_email_fkv1 FOREIGN KEY ( recipient_id )
        REFERENCES scott.user_email ( email_address )
    NOT DEFERRABLE;
    
-- EMAIL_FILE 테이블

CREATE TABLE scott.email_file (
    file_id      NUMBER primary key,
    email_id     NUMBER,
    path         VARCHAR2(250 BYTE) NOT NULL,
    uuid         VARCHAR2(250 BYTE) NOT NULL,
    file_subject VARCHAR2(250 BYTE) NOT NULL,
    file_size    NUMBER NOT NULL,
    file_date    DATE NOT NULL
);

ALTER TABLE scott.email_file
    ADD CONSTRAINT email_file_email_fk FOREIGN KEY ( email_id )
        REFERENCES scott.email ( email_id )
    NOT DEFERRABLE;
    
-- 시퀀스
CREATE SEQUENCE seq_email_id
	START WITH 1
	INCREMENT BY 1;
    
CREATE SEQUENCE seq_file_id
	START WITH 1
	INCREMENT BY 1;
    
commit;
select * from email;