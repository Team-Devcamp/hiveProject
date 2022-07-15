package com.spring.miniproject.service;

import com.spring.miniproject.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.miniproject.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public int insertUser(UserDto userDto) {
		return userDao.insertUser(userDto);
	}

	@Override
	public UserDto selectOneUser(String user_email) {
		return userDao.selectOneUser(user_email);
	}

	@Override
	public int updateUserPassword(UserDto userDto) {
		return userDao.updateUserPassword(userDto);
	}

	@Override
	public int deleteOneUser(String user_email) {
		return userDao.deleteOneUser(user_email);
	}
}

