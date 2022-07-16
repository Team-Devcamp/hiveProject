<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>아이디 찾기</title>
    <link rel="stylesheet" href="<c:url value='/css/user/find_id_style.css'/>">
    <script src="https://kit.fontawesome.com/4c299e10dd.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="wrap">
    <div class="content">
        <div class="navigator">
            <header class="nav">
                <div class="arrow">
                    <a href="#">
                        <i class="fa-solid fa-chevron-left"></i>
                    </a>
                    <div class="tit">
                        <h2>아이디 찾기</h2>
                    </div>
                </div>
            </header>
        </div>
        <div class="input-box">
            <div class="txt">
                가입 시 입력한 이메일
            </div>
            <form action="#" class="find-id-form">
                <input type="text" placeholder="이메일 주소">
                <input type="button" class="id-check-btn" id="id-check-btn" value="인증 요청">
            </form>
        </div>
        <input type="button" class="submit-btn" id="submit-btn" value="아이디 확인">
    </div>
</div>
</body>
</html>
