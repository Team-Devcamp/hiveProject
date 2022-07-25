package com.spring.miniproject.dao;

import com.spring.miniproject.domain.PurchaseDto;

import java.util.Map;

public interface PurchaseDao {
    public void insertPurchaseInfo(Map orderInfoMap);

    PurchaseDto selectPurchaseId(int user_id);
}
