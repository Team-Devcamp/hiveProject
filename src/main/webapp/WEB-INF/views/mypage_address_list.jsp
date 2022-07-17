<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>주소록</title>
    <link rel="stylesheet" href="<c:url value='/css/user/mypage_address_list_style.css'/>">
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
                    <c:forEach items="${address_list}" var="list">
                        <p><span id="user-name">${list.receiver_name}</span><br>
                            <span id="user-phone">${list.receiver_phone}</span><br>
                            <span id="user-address">(${list.zipcode})${list.address} ${list.address_detail}</span>
                            <a href="<c:url value='/mypage/address/modify?address_id=${list.address_id}'/>"><input type="button" id="modify-btn" value="수정"></a>
                            <a href="<c:url value='/mypage/address/delete?address_id=${list.address_id}'/>"><input type="button" id="delete-btn" value="삭제"><br></a>
                        <h6 class="end-line"></h6>
                        </p>
                    </c:forEach>
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
