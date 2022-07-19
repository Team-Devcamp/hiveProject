<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<title>주소록</title>
<link rel="stylesheet" href="<c:url value='/css/user/mypage_address_style.css'/>">
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script>
    $(document).ready(function (){

        $("#user-profile-address").mouseover(function (){$(this).css({"color":"black","font-weight":"bold"})});
        $("#user-profile-address").mouseout(function (){$(this).css("color","rgb(207, 210, 215)")});
        $("#pur-history").mouseover(function (){$(this).css({"color":"black","font-weight":"bold"})});
        $("#pur-history").mouseout(function (){$(this).css("color","rgb(207, 210, 215)")});
        $("#inter-items").mouseover(function (){$(this).css({"color":"black","font-weight":"bold"})});
        $("#inter-items").mouseout(function (){$(this).css("color","rgb(207, 210, 215)")});
        $("#user-profile-info").mouseover(function (){$(this).css({"color":"black","font-weight":"bold"})});
        $("#user-profile-info").mouseout(function (){$(this).css("color","rgb(207, 210, 215)")});

        $("#add-address").on("click",function (){
            var popup = window.open('/mypage/address/insert', '배송지 입력', 'width=700px,height=800px,scrollbars=yes');
        }) ;
        $("#add-address-btn").on("click",function (){
            var popup = window.open('/mypage/address/insert', '배송지 입력', 'width=700px,height=800px,scrollbars=yes');
        }) ;

        var success_msg = "${success_msg}";
        var error_msg = "${error_msg}";

        if(success_msg != null && success_msg != ""){
            alert(success_msg);
        }
        if(error_msg != null && error_msg != ""){
            alert(error_msg);
        }
    });
</script>
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
                    <a href="#"><li id="pur-history">구매 내역</li></a>
                    <a href="#"><li id="inter-items">관심 상품</li></a>
                </ul>
                <p>내 정보</p>
                <ul>
                    <a href="<c:url value='/mypage'/>"><li id="user-profile-info">프로필 정보</li></a>
                    <a href="<c:url value='/mypage/address/list'/>"><li id="user-profile-address">주소록</li></a>
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
