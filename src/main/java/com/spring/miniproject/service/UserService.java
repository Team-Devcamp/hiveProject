package com.spring.miniproject.service;

import com.spring.miniproject.domain.UserDto;
import org.springframework.stereotype.Service;


public interface UserService {

	public int insertUser(UserDto userDto);
	public UserDto selectOneUser(String user_email);
	public int updateUserPassword(UserDto userDto);
	public int deleteOneUser(String user_email);
}
