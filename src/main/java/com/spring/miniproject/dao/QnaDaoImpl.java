package com.spring.miniproject.dao;

import com.spring.miniproject.domain.QnaDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class QnaDaoImpl implements QnaDao {
    @Autowired
    SqlSession sqlSession;
    private String namespace = "com.spring.miniproject.dao.QnaMapper.";

    @Override
    public void insertQna(QnaDto dto) {

        sqlSession.insert(namespace+"insertQna",dto);
    }

    @Override
    public void deleteQna(Map<String, Object> map) {

        sqlSession.delete(namespace+"deleteQna",map);
    }

    @Override
    public List<QnaDto> selectQnaList(Integer product_id) {

        return sqlSession.selectList(namespace + "selectQnaList", product_id);
    }

    @Override
    public int countQna() {

        return sqlSession.selectOne(namespace + "countQna");
    }



}
