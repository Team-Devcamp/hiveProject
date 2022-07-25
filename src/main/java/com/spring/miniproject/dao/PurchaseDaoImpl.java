package com.spring.miniproject.dao;

import com.spring.miniproject.domain.PurchaseDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class PurchaseDaoImpl implements PurchaseDao{
    @Autowired
    SqlSession session;
    private String namespace = "com.spring.miniproject.dao.PurchaseMapper.";

    @Override
    public void insertPurchaseInfo(Map orderInfoMap) {
        session.insert(namespace+"insertPurchase", orderInfoMap);
    }

    @Override
    public PurchaseDto selectPurchaseId(int user_id) {
        return session.selectOne(namespace+"selectPurchase", user_id);
    }
}
