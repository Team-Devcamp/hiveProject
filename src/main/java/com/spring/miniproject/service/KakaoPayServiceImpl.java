package com.spring.miniproject.service;

import com.spring.miniproject.dao.ProductDao;
import com.spring.miniproject.dao.PurchaseDao;
import com.spring.miniproject.dao.PurchaseProductDetailsDao;
import com.spring.miniproject.domain.ProductDto;
import com.spring.miniproject.domain.PurchaseDto;
import com.spring.miniproject.domain.PurchaseProductDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class KakaoPayServiceImpl implements KaKaoPayService {
    @Autowired
    ProductDao productDao;
    @Autowired
    PurchaseDao purchaseDao;
    @Autowired
    PurchaseProductDetailsDao purchaseProductDetailsDao;

    public String kakaoPayReady(HttpSession session){

        List<PurchaseProductDetailsDto> orderList = (List)session.getAttribute("list");

        String user_email = (String)session.getAttribute("user_email");
        int total_qty=0;
        int total_price = (int)session.getAttribute("total_price");
        String hive="하이브";

        List<ProductDto> productList = new ArrayList<>();
        for(PurchaseProductDetailsDto p : orderList) {
            System.out.println("p = " + p.toString());
            try {
                productList.add(productDao.selectProduct(p.getProduct_id()));
                total_qty += p.getQty();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }//for

        try{
            URL url = new URL("https://kapi.kakao.com/v1/payment/ready");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization","KakaoAK b0b44fa551e1c216344468e83da400d4");
            conn.setRequestProperty("Content-type","application/x-www-form-urlencoded;charset=utf-8");
            conn.setDoOutput(true);
            String parameter= "cid=TC0ONETIME" +
                    "&partner_order_id=ABCDE12345" +
                    "&partner_user_id=" +user_email+
                    "&item_name=MINI HIVE - "+ URLEncoder.encode(hive,"utf-8")+
                    "&quantity=" +total_qty+
                    "&total_amount=" +total_price+
                    "&vat_amount=200" +
                    "&tax_free_amount=0" +
                    "&approval_url=http://localhost:9000/pay/kakaoPaySuccess" +
                    "&fail_url=http://localhost:9000/pay/kakaoPayFail" +
                    "&cancel_url=http://localhost:9000/pay/kakaoPayCancel";
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
        return "/pay";
    }

    @Override
    public void insertPurchaseInfo(Map orderInfoMap) {
        purchaseDao.insertPurchaseInfo(orderInfoMap);
    }

    @Override
    public PurchaseDto selectPurchaseId(int user_id) {
        return purchaseDao.selectPurchaseId(user_id);
    }

    @Override
    public void insertPurchaseProduct(Map orderInfoMap) {
        List<PurchaseProductDetailsDto> orderList = (List)orderInfoMap.get("orderList");
        for(int i=0; i<orderList.size(); i++){
            PurchaseProductDetailsDto p = orderList.get(i);
            orderInfoMap.put("PurchaseProductDetailsDto",p);
            purchaseProductDetailsDao.insertPurchaseProduct(orderInfoMap);
        }
    }
}
