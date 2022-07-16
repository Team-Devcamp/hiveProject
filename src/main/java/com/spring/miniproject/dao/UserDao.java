package com.spring.miniproject.dao;

import com.spring.miniproject.domain.UserDto;
import com.spring.miniproject.domain.UserProfileDto;


public interface UserDao {

	public int insertUser(UserDto userDto);
	public UserDto selectOneUser(String user_email);
	public int updateUserPassword(UserDto userDto);
	public int deleteOneUser(String user_email);
	public int updateProfileImage(UserProfileDto userProfileDto);
	public int updateImageOrigin(String user_email);
}
