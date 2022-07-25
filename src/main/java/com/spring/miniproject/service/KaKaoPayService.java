package com.spring.miniproject.service;

import com.spring.miniproject.domain.PurchaseDto;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface KaKaoPayService {
    public String kakaoPayReady(HttpSession session);

    public void insertPurchaseInfo(Map orderInfoMap);

    public PurchaseDto selectPurchaseId(int user_id);

    public void insertPurchaseProduct(Map orderInfoMap);
}
