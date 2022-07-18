package com.spring.miniproject.dao;

import com.spring.miniproject.domain.PageHandlerDto;
import com.spring.miniproject.domain.UserAddressDto;
import com.spring.miniproject.domain.UserDto;
import com.spring.miniproject.domain.UserProfileDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

	@Override
	public int selectUserAddressCnt(int user_id) {
		return sqlSession.selectOne(namespace+"selectUserAddressCnt",user_id);
	}

	@Override
	public int selectUserId(String user_email) {
		return sqlSession.selectOne(namespace+"selectUserId",user_email);
	}

	@Override
	public int insertUserAddress(UserAddressDto userAdressDto) {
		return sqlSession.insert(namespace+"insertUserAddress",userAdressDto);
	}

	@Override
	public List<UserAddressDto> selectUserAddress(int user_id) {
		return sqlSession.selectList(namespace+"selectUserAddress",user_id);
	}

	@Override
	public int deleteUserAddress(Integer address_id) {
		return sqlSession.delete(namespace+"deleteUserAddress",address_id);
	}

	@Override
	public int updateUserAddress(UserAddressDto userAddressDto) {
		return sqlSession.update(namespace+"updateUserAddress",userAddressDto);
	}

	@Override
	public List<UserAddressDto> selectAddressList(PageHandlerDto pageHandlerDto) {
		return sqlSession.selectList(namespace+"selectAddressList",pageHandlerDto);
	}

}
