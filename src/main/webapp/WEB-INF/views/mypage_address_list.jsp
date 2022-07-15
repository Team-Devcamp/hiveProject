<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>주소록</title>
    <link rel="stylesheet" href="<c:url value='/css/user/mypage_address_list_style.css'/>">
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
                    <p><span id="user-name">김**</span><br>
                        <span id="user-phone">010-8***-*589</span><br>
                        <span id="user-address">(04175)서울 마포구 마포대로 12 (마포동, 한신빌딩) 4층</span>
                        <input type="button" id="modify-btn" value="수정">
                        <input type="button" id="delete-btn" value="삭제"><br>
                    <h6 class="end-line"></h6>
                    </p>
                    <p><span id="user-name">조**</span><br>
                        <span id="user-phone">010-4***-*789</span><br>
                        <span id="user-address">(02575)경기도 고양시 덕양대로 558 백상빌딩</span>
                        <input type="button" id="modify-btn" value="수정">
                        <input type="button" id="delete-btn" value="삭제">
                    <h6 class="end-line"></h6>
                    </p>
                    <p><span id="user-name">박**</span><br>
                        <span id="user-phone">010-8***-*541</span><br>
                        <span id="user-address">(03585)서울 강낭구 강남대로 441</span>
                        <input type="button" id="modify-btn" value="수정">
                        <input type="button" id="delete-btn" value="삭제">
                    <h6 class="end-line"></h6>
                    </p>
                    <p><span id="user-name">박**</span><br>
                        <span id="user-phone">010-8***-*541</span><br>
                        <span id="user-address">(03585)서울 강낭구 강남대로 441</span>
                        <input type="button" id="modify-btn" value="수정">
                        <input type="button" id="delete-btn" value="삭제">
                    <h6 class="end-line"></h6>
                    </p>
                    <p><span id="user-name">박**</span><br>
                        <span id="user-phone">010-8***-*541</span><br>
                        <span id="user-address">(03585)서울 강낭구 강남대로 441</span>
                        <input type="button" id="modify-btn" value="수정">
                        <input type="button" id="delete-btn" value="삭제">
                    <h6 class="end-line"></h6>
                    </p>
                    <p><span id="user-name">박**</span><br>
                        <span id="user-phone">010-8***-*541</span><br>
                        <span id="user-address">(03585)서울 강낭구 강남대로 441</span>
                        <input type="button" id="modify-btn" value="수정">
                        <input type="button" id="delete-btn" value="삭제">
                    <h6 class="end-line"></h6>
                    </p>
                </div>
                <div class="paging">
                    <ul>
                        <a href="#"><li>1</li></a>
                        <a href="#"><li>2</li></a>
                        <a href="#"><li>3</li></a>
                        <a href="#"><li>4</li></a>
                        <a href="#"><li>5</li></a>
                    </ul>
                </div>
            </div>
        </div>
        <footer></footer>
    </div>
</div>
</body>
</html>
