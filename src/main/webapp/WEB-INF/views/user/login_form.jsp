<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
    <link rel="stylesheet" href="<c:url value='/css/user/login_page.css'/>">
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        $(document).ready(function (){
            let error_msg = "${error_msg}";
            let error_msg_social = "${error_msg_social}";
            $(".login-btn").on("click",function (){
               let user_email = $("input[name=user_email]").val();
               let user_pwd = $("input[name=user_password]").val();

               if(user_email==null || user_email==""){
                   alert("이메일을 입력해주세요.");
                   return;
               }

               if(user_pwd == null || user_pwd == ""){
                   alert("비밀번호를 입력해주세요.");
                   return;
               }

               $("form").submit();

            });
            if(error_msg != null && error_msg != ""){
                alert(error_msg);
            }

            if(error_msg_social != null && error_msg_social != ""){
                alert(error_msg_social);
            }


        });
    </script>
</head>
<body>
    <div class="wrap">
        <div class="content">
            <div class="main-tit">
                <p>안녕하세요<br>
                하이브입니다</p>
            </div>
            <div class="sub-tit">
                하이브, 브랜디, 플레어의 통합회원으로<br>
                로그인이 가능합니다.
            </div>
            <div class="login-form">
                <form action="/login" class="login-input" method="post">
                    <input type="text" name="user_email" class="login-input-form"  placeholder="아이디 입력"><br>
                    <input type="password" name = "user_password" class="login-input-form"  placeholder="비밀번호 입력"><br>
                    <input type="button" class="login-btn" value="로그인">
                </form>
            </div>
            <div class="menu">
                <p><span><a href="<c:url value='/register/findId'/>">아이디 찾기</a></span><span><a href="<c:url value='/register/findPassword'/>">비밀번호 찾기</a></span><span><a href="<c:url value='/register'/>">회원가입</a></span></p>
            </div>
            <div class="social">
                <span>SNS 계정으로 로그인</span>
            </div>
            <div class="icon">
                <span><a href="https://kauth.kakao.com/oauth/authorize?client_id=fb59cb87cd202d9b7383d5d6706f43ac&redirect_uri=http://localhost:9000/login/kakao&response_type=code">
                    <img src="<c:url value='/image/user/kakao.png'/>"></a></span>
                <span><a href="${naver_url}"><img src="<c:url value='/image/user/naver.png'/>"></a></span>
            </div>
        </div>
    </div>
</body>
</html>