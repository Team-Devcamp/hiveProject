package com.spring.miniproject.service;

import com.spring.miniproject.domain.PurchaseProductDetailDto;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
public class KakaoPayServiceImpl implements KaKaoPayService {

    public String kakaoPayReady(List<PurchaseProductDetailDto> list){

        for(PurchaseProductDetailDto p : list){
            System.out.println("p = " + p.toString());
        }

        try{
            URL url = new URL("https://kapi.kakao.com/v1/payment/ready");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization","KakaoAK b0b44fa551e1c216344468e83da400d4");
            conn.setRequestProperty("Content-type","application/x-www-form-urlencoded;charset=utf-8");
            conn.setDoOutput(true);
            String parameter= "cid=TC0ONETIME" +
                    "&partner_order_id=partner_order_id" +
                    "&partner_user_id=partner_user_id" +
                    "&item_name=#####" +
                    "&quantity=1" +
                    "&total_amount=2200" +
                    "&vat_amount=200" +
                    "&tax_free_amount=0" +
                    "&approval_url=http://localhost:9000/pay/success" +
                    "&fail_url=http://localhost:9000/pay/fail" +
                    "&cancel_url=http://localhost:9000/pay/cancel";
            OutputStream outputStream = conn.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeBytes(parameter);
            dataOutputStream.close();

            int result = conn.getResponseCode();

            InputStream inputStream;

            if(result==200){
                inputStream = conn.getInputStream();
            }else{
                inputStream = conn.getErrorStream();
            }
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            return bufferedReader.readLine();

        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        return "";
    }
}
