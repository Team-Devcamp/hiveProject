package com.spring.miniproject.service;

public interface FindPasswordService {
    String mailCheck(String user_email);
    String tempPassword();
    String sendNewPassword(String user_email,String password);
}
