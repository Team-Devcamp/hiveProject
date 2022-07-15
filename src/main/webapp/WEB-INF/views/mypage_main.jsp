<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>마이페이지</title>
    <link rel="stylesheet" href="<c:url value='/css/user/mypage.css'/>">
</head>
<body>
<div class="wrap">
    <div class="content">
        <header></header>
        <div class="menu">
            <h2>마이 페이지</h2>
            <div class="menu-list">
                <p>쇼핑 정보</p>
                <ul>
                    <a href="#"><li id="pur-history">구매 내역</li></a>
                    <a href="#"><li id="inter-items">관심 상품</li></a>
                </ul>
                <p>내 정보</p>
                <ul>
                    <a href="#"><li id="user-profile-info">프로필 정보</li></a>
                    <a href="#"><li id="user-profile-address">주소록</li></a>
                </ul>
            </div>
            <div class="profile-info">
                <p>프로필 정보</p>
                <p class="line"></p>
                <span><img src = "<c:url value='/image/user/profile_unknown.png'/>"></span>
                <h6 id="profile-id">ch4570</h6>
                <input type="button" id="add-img" value="이미지 등록">
                <input type="button" id="del-img" value="이미지 삭제">
                <p class="line-id"></p>
                <div class="login-profile">
                    <p>로그인 정보</p>
                    <ul>
                        <li>이메일 주소</li>
                        <li>ch***0@naver.com</li>
                        <h6 class="line-login"></h6>
                    </ul>
                    <h6 class="password">비밀번호</h6>
                    <input type="password" id="look-pwd" value="dfadfadsfdaf">
                    <h6 class="line-login-end"></h6>
                </div>
                <div class="user-info">
                    <p>개인정보</p>
                    <h6 id="user-name">이름</h6>
                    <h6 id="user-id">ch4570</h6>
                    <h6 class="info-line"></h6>
                    <h6 id="user-phone">휴대폰번호</h6>
                    <h6 id="user-phone-num">010-8***-*545</h6>
                    <h6 class="info-end-line"></h6>
                </div>
                <div class="out-of-join">
                    <a href="#">회원 탈퇴</a>
                </div>
            </div>
        </div>
        <footer></footer>
    </div>
</div>
</body>
</html>
