package com.spring.miniproject.service;

import com.spring.miniproject.domain.PurchaseProductDetailDto;

import java.util.List;

public interface KaKaoPayService {
    public String kakaoPayReady(List<PurchaseProductDetailDto> list);
}
