<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>마이페이지</title>
    <link rel="stylesheet" href="<c:url value='/css/user/mypage.css'/>">
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>

    <script>
        $(document).ready(function (){
            var user_email = "${userDto.user_email}";
            var image_path = $("#user_profile").attr("src");

            $("#user-profile-address").mouseover(function (){$(this).css({"color":"black","font-weight":"bold"})});
            $("#user-profile-address").mouseout(function (){$(this).css("color","rgb(207, 210, 215)")});
            $("#pur-history").mouseover(function (){$(this).css({"color":"black","font-weight":"bold"})});
            $("#pur-history").mouseout(function (){$(this).css("color","rgb(207, 210, 215)")});
            $("#inter-items").mouseover(function (){$(this).css({"color":"black","font-weight":"bold"})});
            $("#inter-items").mouseout(function (){$(this).css("color","rgb(207, 210, 215)")});
            $("#user-profile-info").mouseover(function (){$(this).css({"color":"black","font-weight":"bold"})});
            $("#user-profile-info").mouseout(function (){$(this).css("color","rgb(207, 210, 215)")});
            $("#add-img").mouseover(function (){$(this).css({"color":"black","font-weight":"bold"})});
            $("#add-img").mouseout(function (){$(this).css("font-weight","normal")});
            $("#del-img").mouseover(function (){$(this).css({"color":"black","font-weight":"bold"})});
            $("#del-img").mouseout(function (){$(this).css("font-weight","normal")});
            $("#change-pwd").mouseover(function (){$(this).css({"color":"black","font-weight":"bold"})});
            $("#change-pwd").mouseout(function (){$(this).css("font-weight","normal")});
            $("#join-out").mouseover(function (){$(this).css({"color":"black","font-weight":"bold"})});
            $("#join-out").mouseout(function (){$(this).css({"color":"rgb(207, 210, 215)","font-weight":"normal"})});
            $("#logout-btn").mouseover(function (){$(this).css({"color":"black","font-weight":"bold"})});
            $("#logout-btn").mouseout(function (){$(this).css({"color":"rgb(207, 210, 215)","font-weight":"normal"})});

            $("#change-pwd").on("click",function (){
                var popup = window.open('/mypage/modify/password', '비밀번호 변경', 'width=700px,height=800px,scrollbars=yes');
            });

            $("#logout-btn").on("click",function (){
               var question = confirm("로그아웃 하시겠습니까?")
               if(question){
                   location.href = "/logout";
                   alert("로그아웃 되었습니다.");
               }
            });

            $("#join-out").on("click",function (){
               var question = confirm("정말 탈퇴하시겠습니까?");

               if(question){
                   $.ajax({
                       type:"GET",
                       url:"/register/delete",
                       data: {user_email:user_email},
                       cache : false,
                       success:function(data) {
                           if (data == "success") {
                               alert("회원탈퇴가 성공적으로 처리되었습니다.");
                               location.href = "<c:url value='/'/>"
                               return;
                           }else{
                               alert("회원탈퇴가 실패하였습니다.");
                           }
                       }
                   });
               }else{
                    return;
               }
            });

            $("#add-img").on("click",function (){
                var popup = window.open('/mypage/image/add', '프로필 이미지 등록', 'width=700px,height=800px,scrollbars=yes');
            });

            $("#del-img").on("click",function (){
                if(image_path=="" || image_path==null || image_path=="/image/user/profile_unknown.png"){
                    alert("등록된 이미지가 없습니다.");
                    return;
                }
                var question = confirm("이미지를 삭제하시겠습니까?");
                if(question){
                    $.ajax({
                        type: "POST",
                        url : "/mypage/image/delete",
                        data : {user_email:user_email},
                        success: function(data){
                            if(data=="success"){
                                alert("프로필 이미지가 삭제되었습니다.");
                                location.href = "/mypage";
                            }else{
                                alert("삭제에 실패했습니다.");
                            }
                        }
                    });
                }

            });
        });
    </script>
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
                    <a href="<c:url value='/mypage/purchase'/>"><li id="pur-history">구매 내역</li></a>
                    <a href="#" onclick="alert('준비중입니다.')"><li id="inter-items">관심 상품</li></a>
                </ul>
                <p>내 정보</p>
                <ul>
                    <a href="<c:url value='/mypage'/>"><li id="user-profile-info">프로필 정보</li></a>
                    <a href="<c:url value='/mypage/address/list'/>"><li id="user-profile-address">주소록</li></a>
                </ul>
            </div>
            <div class="profile-info">
                <p>프로필 정보</p>
                <p class="line"></p>
                <span><img src = "<c:url value='${userDto.profile_image}'/>" id="user_profile"></span>
                <h6 id="profile-id">${userDto.user_name}</h6>
                <input type="button" id="add-img" value="이미지 등록">
                <input type="button" id="del-img" value="이미지 삭제">
                <p class="line-id"></p>
                <div class="login-profile">
                    <p>로그인 정보</p>
                    <ul>
                        <li>이메일 주소</li>
                        <li>${userDto.user_email}</li>
                        <h6 class="line-login"></h6>
                    </ul>
                    <h6 class="password">비밀번호</h6>
                    <input type="password" id="look-pwd" value="**********"><input type="button" value="비밀번호 변경" id="change-pwd">
                    <h6 class="line-login-end"></h6>
                </div>
                <div class="user-info">
                    <p>개인정보</p>
                    <h6 id="user-name">이름</h6>
                    <h6 id="user-id">${userDto.user_name}</h6>
                    <h6 class="info-line"></h6>
                    <h6 id="user-phone">휴대폰번호</h6>
                    <h6 id="user-phone-num">${userDto.user_phone}</h6>
                    <h6 class="info-end-line"></h6>
                </div>
                <div class="out-of-join">
                    <a href="#" id="join-out">회원 탈퇴</a>
                    <a href="#" id="logout-btn">로그아웃</a>
                </div>
            </div>
        </div>
        <footer></footer>
    </div>
</div>
</body>
</html>
