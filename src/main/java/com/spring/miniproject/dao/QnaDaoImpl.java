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
    public int insertQna(QnaDto dto) throws Exception{
        return sqlSession.insert(namespace+"insertQna",dto);
    }

    @Override//본인 게시물 삭제 //map(product_id,qna_id,writer)
    public int deleteQna(Map<String, Object> map) throws Exception{
        return sqlSession.delete(namespace+"deleteQna",map);
    }

    @Override //해당 상품 qna리스트
    public List<QnaDto> selectQnaList(Map<String,Integer> map) throws Exception{
        return sqlSession.selectList(namespace + "selectQnaList", map);
    }

    @Override // 내 qna 게시물하나 선택 map(product_id, qna_id, writer)
    public QnaDto selectQna(Map map) throws Exception{
        return sqlSession.selectOne(namespace+"selectQna", map);
    }

    @Override
    public int countQna(Integer product_id) throws Exception{

        System.out.println();
        System.out.println("%n다오product_id = " + product_id);

        return sqlSession.selectOne(namespace + "countQna",product_id);
    }










}
