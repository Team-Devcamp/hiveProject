<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>주소록</title>
    <link rel="stylesheet" href="<c:url value='/css/user/mypage_purchase_style.css'/>">
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
                <p>작성 가능한 리뷰</p><hr>
                <c:forEach begin="1" end="4" step="1">
                <div class="deliver-contents">
                        <div id="product-img"><p><img src="<c:url value='/image/product/product_detail/profile_image.png'/>" width="100px;" height="100px"></p>
                    <div id="purchase-detail">
                    <p>
                        <span id="pur-confirm">010-2222-2222</span><br>
                        <span id="pur-detail">[호환] 테팔 TY6547KM 호환 에어포스360 고밀도 공기청정필터C [당일배송]</span><br>
                            <a href="#" onclick="window.open('<c:url value='/mypage/purchase/review'/>', '리뷰 등록', 'width=700px,height=1200px,scrollbars=yes');">
                                <input type="button" id="modify-btn" value="리뷰작성"></a>
                        <h6 id="end-line"></h6>
                        </p>
                    </div>
                    </div>
                    </div>
                </c:forEach>
                <div class="paging">
                    <ul>
                        <c:if test="${paging.preView eq 'true'}">
                            <a href="<c:url value="/mypage/address/list?page=${paging.beginPage-1}"/>">&lt;</a>
                        </c:if>
                        <c:forEach var="i" begin="1" end="5">
                            <a href="#"><li>${i}</li></a>
                        </c:forEach>
                        <c:if test="${paging.nextView eq 'true'}">
                            <a href="<c:url value="/mypage/address/list?page=${paging.endPage+1}"/>">&gt;</a>
                        </c:if>
                    </ul>
                </div>
                </div>


            </div>
        </div>
        <footer></footer>
    </div>
</div>
</body>
</html>
