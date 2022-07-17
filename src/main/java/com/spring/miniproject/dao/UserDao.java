package com.spring.miniproject.dao;

import com.spring.miniproject.domain.UserDto;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;


public interface UserDao {

	public int insertUser(UserDto userDto);
	public UserDto selectOneUser(String user_email);
	public int updateUserPassword(UserDto userDto);
	public int deleteOneUser(String user_email);
}
