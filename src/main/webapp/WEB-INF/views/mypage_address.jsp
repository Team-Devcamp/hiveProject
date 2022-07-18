<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<title>주소록</title>
<link rel="stylesheet" href="<c:url value='/css/user/mypage_address_style.css'/>">
</head>
<body>
<header></header>
<div class="wrap">
    <div class="content">
        <header></header>
        <div class="menu">
            <h2>마이 페이지</h2>
            <div class="menu-list">
                <p>쇼핑 정보</p>
                <ul>
                    <a href="#"><li>구매 내역</li></a>
                    <a href="#"><li>관심 상품</li></a>
                </ul>
                <p>내 정보</p>
                <ul>
                    <a href="#"><li>프로필 정보</li></a>
                    <a href="#"><li>주소록</li></a>
                </ul>
            </div>
            <div class="profile-info">
                <p>주소록<input type="button" id="add-address" value="+새 배송지 추가"></p>
                <div class="deliver-contents">
                    <p>배송지 정보가 없습니다.<br> 새 배송지를 등록해주세요</p>
                    <input type="button" id="add-address-btn" value="새 배송지 추가"></p>
                </div>
            </div>
        </div>
        <footer></footer>
    </div>
</div>
</body>
</html>
