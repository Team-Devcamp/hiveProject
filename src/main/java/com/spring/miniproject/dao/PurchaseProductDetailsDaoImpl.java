package com.spring.miniproject.dao;

import com.spring.miniproject.domain.PurchaseProductDetailsDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class PurchaseProductDetailsDaoImpl implements PurchaseProductDetailsDao{
    @Autowired
    SqlSession session;
    private String namespace = "com.spring.miniproject.dao.PurchaseProductDetailsMapper.";

    @Override
    public void insertPurchaseProduct(Map orderInfoMap) {
        session.insert(namespace+"insertPurchaseProduct",orderInfoMap);
    }

}
