package com.spring.miniproject.service;

import com.spring.miniproject.domain.UserDto;
import com.spring.miniproject.domain.UserProfileDto;
import org.springframework.stereotype.Service;


public interface UserService {

	public int insertUser(UserDto userDto);
	public UserDto selectOneUser(String user_email);
	public int updateUserPassword(UserDto userDto);
	public int deleteOneUser(String user_email);
	public int updateProfileImage(UserProfileDto userProfileDto);
	public int updateImageOrigin(String user_email);
}
