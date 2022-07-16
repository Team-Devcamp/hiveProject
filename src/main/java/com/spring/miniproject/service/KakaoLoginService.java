package com.spring.miniproject.service;


public interface KakaoLoginService {
    String getKakaoAccessToken(String code);
    String createKaKaoUser(String token);
}
