package com.spring.miniproject.dao;

import com.spring.miniproject.domain.UserDto;
import com.spring.miniproject.domain.UserProfileDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "com.spring.miniproject.dao.UserMapper.";

	@Override
	public int insertUser(UserDto userDto) {
		return sqlSession.insert(namespace+"insertUser", userDto);
	}

	@Override
	public UserDto selectOneUser(String user_email) {
		return sqlSession.selectOne(namespace+"selectOneUser",user_email);
	}

	@Override
	public int updateUserPassword(UserDto userDto) {
		return sqlSession.update(namespace+"updatePassword",userDto);
	}

	@Override
	public int deleteOneUser(String user_email) {
		return sqlSession.delete(namespace+"deleteOneUser",user_email);
	}

	@Override
	public int updateProfileImage(UserProfileDto userProfileDto) {
		return sqlSession.update(namespace+"updateProfileImage",userProfileDto);
	}

	@Override
	public int updateImageOrigin(String user_email) {
		return sqlSession.update(namespace+"updateImageOrigin",user_email);
	}

}
