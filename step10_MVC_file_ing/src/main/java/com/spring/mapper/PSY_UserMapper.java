package com.spring.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.spring.dto.UserEmail;

@Mapper
public interface PSY_UserMapper {
	
	// getAllUsers
	public List<UserEmail> getAllUsers() throws SQLException;
	
	//getUserByMem_name - UserEmail 객체 (password제외)
	public UserEmail getUserByMem_name(String mem_name) throws SQLException;
	
	//getUserByEmail_address - UserEmail 객체 (password포함 / 로그인 용도)
	public UserEmail getUserByEmailaddressAndPassword(@Param("email_address") String email_address
													 ,@Param("password") String password) throws SQLException;
	
	//getUserByEmailaddress - UserEmail 객체 (password제외)
	public UserEmail getUserByEmailaddress(String email_address) throws SQLException;
	
	// insertUser - UserEmail
	public int insertUser(UserEmail newUser) throws SQLException;
	
	// updateMem_nameAndPassword - UserEmail
	public int updateMem_nameAndPassword(UserEmail modifiedUser) throws SQLException; 

	// deleteUserByUserEmail - UserEmail
	public int deleteDeptByDeptno(String email_address) throws SQLException;
	
	
}
