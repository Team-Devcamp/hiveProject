package com.spring.miniproject.service;

import com.github.scribejava.core.builder.api.DefaultApi20;

public class NaverLoginService extends DefaultApi20 {

    protected NaverLoginService() {
    }

    private static class InstanceHolder {
        private static final NaverLoginService INSTANCE = new NaverLoginService();
    }

    public static NaverLoginService instance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public String getAccessTokenEndpoint() {
        return "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code";
    }

    @Override
    protected String getAuthorizationBaseUrl() {
        return "https://nid.naver.com/oauth2.0/authorize";
    }
}
