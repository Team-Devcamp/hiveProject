package com.spring.miniproject.dao;

import com.spring.miniproject.domain.PurchaseProductDetailsDto;

import java.util.Map;

public interface PurchaseProductDetailsDao {

    void insertPurchaseProduct(Map orderInfoMap);
}
