package com.spring.miniproject.service;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

public class NaverLoginBO{
    private final static String CLIENT_ID = "siyGBmbQBhnKc99yudd2";
    private final static String CLIENT_SECRET = "nNaaEHEaA1";
    private final static String REDIRECT_URI = "http://localhost:9000/login/naver";

    //프로필 조회 URL
    private final static String PROFILE_API_URL = "https://openapi.naver.com/v1/nid/me";


    public String generateState() {

        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }

    public String getAuthorizationUrl(HttpSession session) {

        String state = generateState();
        session.setAttribute("state", state);

        OAuth20Service oauthService = new ServiceBuilder()
                .apiKey(CLIENT_ID)
                .apiSecret(CLIENT_SECRET)
                .callback(REDIRECT_URI)
                .state(state)
                .build(NaverLoginService.instance());

        return oauthService.getAuthorizationUrl();
    }



    public OAuth2AccessToken getAccessToken(HttpSession session, String code, String state) throws IOException{

        String sessionState = (String)session.getAttribute("state");
        if(StringUtils.equals(sessionState, state)){

            OAuth20Service oauthService = new ServiceBuilder()
                    .apiKey(CLIENT_ID)
                    .apiSecret(CLIENT_SECRET)
                    .callback(REDIRECT_URI)
                    .state(state)
                    .build(NaverLoginService.instance());

            OAuth2AccessToken accessToken = oauthService.getAccessToken(code);
            return accessToken;
        }
        return null;
    }


    public String getUserProfile(OAuth2AccessToken oauthToken) throws IOException{

        OAuth20Service oauthService =new ServiceBuilder()
                .apiKey(CLIENT_ID)
                .apiSecret(CLIENT_SECRET)
                .callback(REDIRECT_URI).build(NaverLoginService.instance());

        OAuthRequest request = new OAuthRequest(Verb.GET, PROFILE_API_URL, oauthService);
        oauthService.signRequest(oauthToken, request);
        Response response = request.send();
        return response.getBody();
    }

}
