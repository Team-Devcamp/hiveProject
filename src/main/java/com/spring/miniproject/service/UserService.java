package com.spring.miniproject.service;

import com.spring.miniproject.domain.UserAddressDto;
import com.spring.miniproject.domain.UserDto;
import com.spring.miniproject.domain.UserProfileDto;

import java.util.List;


public interface UserService {

	public int insertUser(UserDto userDto);
	public UserDto selectOneUser(String user_email);
	public int updateUserPassword(UserDto userDto);
	public int deleteOneUser(String user_email);
	public int updateProfileImage(UserProfileDto userProfileDto);
	public int updateImageOrigin(String user_email);
	public int selectUserAddressCnt(int user_id);
	public int selectUserId(String user_email);
	public int insertUserAddress(UserAddressDto userAdressDto);
	public List<UserAddressDto> selectUserAddress(int user_id);
	public int deleteUserAddress(Integer address_id);
	public int updateUserAddress(UserAddressDto userAddressDto);
}
