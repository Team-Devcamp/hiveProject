<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>FAQ</title>
    <link href="<c:url value='/css/faq/faq.css'/>" rel="stylesheet"/>
</head>
<body>
<%-- Header --%>

<div class="faq">
    <div class="faq-content">
        <div class="faq-title">
            <h2>취소/환불/교환 관련</h2>
        </div>
        <ul>
            <li><a href="#">주문을 취소하고 싶어요!</a></li>
            <li><a href="#">상품을 환불하고 싶어요!</a></li>
            <li><a href="#">상품을 교환하고 싶어요!</a></li>
            <li><a href="#">교환/반품시 택배비가 발송되나요?</a></li>
            <li><a href="#">환불은 언제 되나요?</a></li>
        </ul>
    </div>
    <div class="faq-content">
        <div class="faq-title">
            <h2>주문/결제/배송 관련</h2>
        </div>
        <ul>
            <li><a href="#">현금영수증 발급은 어떻게 하나요?</a></li>
            <li><a href="#">배송은 어떻게 진행되나요?</a></li>
            <li><a href="#">주문내역을 확인하고 싶언요!</a></li>
            <li><a href="#">교환/반품시 택배비가 발생되나요?</a></li>
            <li><a href="#">환불은 언제 되나요?</a></li>
        </ul>
    </div>
    <div class="faq-content">
        <div class="faq-title">
            <h2>회원정보 관련</h2>
        </div>
        <ul>
            <li><a href="#">회원탈퇴는 어떻게 하나요?</a></li>
            <li><a href="#">비밀번호를 잊어버렸어요!</a></li>
            <li><a href="#">비밀번호를 변경하고 싶어요!</a></li>
            <li><a href="#">로그인이 안돼요!</a></li>
            <li><a href="#">개인정보를 변경하고 싶어요!</a></li>
        </ul>
    </div>
</div>

<%-- Footer --%>
</body>
</html>
