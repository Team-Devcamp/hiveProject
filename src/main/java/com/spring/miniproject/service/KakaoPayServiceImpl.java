package com.spring.miniproject.service;

import com.spring.miniproject.dao.ProductDao;
import com.spring.miniproject.dao.PurchaseDao;
import com.spring.miniproject.dao.PurchaseProductDetailsDao;
import com.spring.miniproject.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Map;

@Service
public class KakaoPayServiceImpl implements KakaoPayService {
    @Autowired
    ProductDao productDao;
    @Autowired
    PurchaseDao purchaseDao;
    @Autowired
    PurchaseProductDetailsDao purchaseProductDetailsDao;

    private static final String HOST = "https://kapi.kakao.com";
    private KakaoPayReadyDto kakaoPayReadyDto;
    private KakaoPayApprovalDto kakaoPayApprovalDto;

    public String kakaoPayReady(HttpSession session) {

        List<PurchaseProductDetailsDto> orderList = (List)session.getAttribute("list");
        String user_email = (String)session.getAttribute("user_email");
        if(user_email==null) user_email="비회원";
        int total_qty=0;
        int total_price = (int)session.getAttribute("total_price");
        String hive="하이브";
        for(PurchaseProductDetailsDto p : orderList) {
            System.out.println("카카오p 서비스 ready = " + p.toString());
                total_qty += p.getQty();
        }//for

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "b0b44fa551e1c216344468e83da400d4");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("partner_order_id", "HIVEABCDE12345");
        params.add("partner_user_id", user_email);
        params.add("item_name", "MINI HIVE"/*+URLEncoder.encode(hive,"utf-8")*/);
        params.add("quantity", String.valueOf(total_qty));
        params.add("total_amount", String.valueOf(total_price));
        params.add("tax_free_amount", "0");
        params.add("approval_url", "http://13.209.80.187/pay/kakaoPaySuccess");
        params.add("cancel_url", "http://13.209.80.187/pay/kakaoPayCancel");
        params.add("fail_url", "http://13.209.80.187/pay/kakaoPayFail");

        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);

        try {
            kakaoPayReadyDto = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyDto.class);

            System.out.println("-----------------------PAY-READY ReadyDto PAYINFO-----------------------");
            System.out.println("kakaoPayReadyDto = " + kakaoPayReadyDto);
            System.out.println("-------------------------------------------------------------------------");

            return kakaoPayReadyDto.getNext_redirect_pc_url();

        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "/pay";
    }

    public KakaoPayApprovalDto kakaoPayInfo(String pg_token, HttpSession session) {

        String user_email = (String)session.getAttribute("user_email");
        if(user_email==null) user_email="비회원";

        System.out.println("KakaoPayInfoDto............................................");
        System.out.println("-----------------------------");

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "b0b44fa551e1c216344468e83da400d4");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("tid", kakaoPayReadyDto.getTid());
        params.add("partner_order_id", "HIVEABCDE12345");
        params.add("partner_user_id", user_email);
        params.add("pg_token", pg_token);
        params.add("total_amount", String.valueOf((int)session.getAttribute("total_price")));

        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        System.out.println("-----------------------SUCCESS RESPONSE PAYINFO-----------------------");
        System.out.println(body);
        System.out.println("----------------------------------------------------------------------");

        try {
            kakaoPayApprovalDto = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoPayApprovalDto.class);
            System.out.println(kakaoPayApprovalDto);
            return kakaoPayApprovalDto;

        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
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
