package com.spring.miniproject.service;

import com.spring.miniproject.dao.QnaDao;
import com.spring.miniproject.domain.QnaDto;
import com.spring.miniproject.domain.QnaPaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QnaServiceImpl implements QnaService {
    @Autowired
    private QnaDao qnaDao;
    @Autowired
    private QnaPaging qnaPaging;

    @Override
    public int insertQna(QnaDto dto) throws Exception{
        return qnaDao.insertQna(dto);
    }

    @Override
    public int deleteQna(int product_id, int qna_id, String writer) throws Exception{
        Map<String, Object> map = new HashMap<>();
        map.put("product_id", product_id);
        map.put("qna_id", qna_id);
        map.put("writer",writer);

        return qnaDao.deleteQna(map);
    }

    @Override
    public Map<String, Object> selectQnaList(Integer product_id, String pg) throws Exception{

        //세션
        //String user_email = (String)session.getAttribute("user_email");

        //페이징처리
        int endNum = Integer.parseInt(pg) * 4;
        int startNum = endNum - 4;

        //상품에대한 리스트, 페이징 시작,끝 번호
        Map<String, Integer> listMap = new HashMap<String, Integer>();
        listMap.put("product_id",product_id);
        listMap.put("startNum", startNum);
        listMap.put("endNum", endNum);

        //qna리스트
        List<QnaDto> list = qnaDao.selectQnaList(listMap);

        //페이징처리
        int qnaCount = qnaDao.countQna(product_id);//총글수
        qnaPaging.setCurrentPage(Integer.parseInt(pg));
        qnaPaging.setPageBlock(3);
        qnaPaging.setPageSize(5);
        qnaPaging.setCountQna(qnaCount);
        qnaPaging.makePagingHTML();

        Map<String, Object> map = new HashMap<>();

        map.put("list",list);
        map.put("qnaPaging",qnaPaging);
//        map.put("user_email",user_email);

        return map;
    }

    @Override
    public QnaDto selectQna(Integer product_id, Integer qna_id) throws Exception{
        Map map = new HashMap();
        map.put("product_id", product_id);
        map.put("qna_id", qna_id);

        return qnaDao.selectQna(map);
    }

    @Override
    public int countQna(Integer product_id) throws Exception{
        return qnaDao.countQna(product_id);
    }

}
