package com.spring.miniproject.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class KakaoLoginServiceImpl implements KakaoLoginService {

    @Override
    public String getKakaoAccessToken(String code){
        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();


            conn.setRequestMethod("POST");
            conn.setDoOutput(true);


            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=fb59cb87cd202d9b7383d5d6706f43ac"); // REST_API_KEY 입력
            sb.append("&redirect_uri=http://localhost:9000/login/kakao");  // 인가코드 받은 redirect_uri 입력
            sb.append("&code="+code);
            bw.write(sb.toString());
            bw.flush();


            int responseCode = conn.getResponseCode();


            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while((line = br.readLine()) !=null){
                result += line;
            }


            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return access_Token;
    }


    @Override
    public String createKaKaoUser(String token){
        String reqURL = "https://kapi.kakao.com/v2/user/me";
        String email = "";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Authorization","Bearer "+token);

            int responseCode = conn.getResponseCode();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while((line = br.readLine()) != null){
                result += line;
            }



            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            JsonObject userInfo = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
            try {
                email = userInfo.get("email").getAsString();
            } catch (Exception e) {
                return null;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return email;
    }

}