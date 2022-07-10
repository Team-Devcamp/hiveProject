package com.spring.miniproject.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "com.spring.miniproject.dao.UserMapper.";
	
	@Override
	public int count() {
		return sqlSession.selectOne(namespace + "count");
	}

}
