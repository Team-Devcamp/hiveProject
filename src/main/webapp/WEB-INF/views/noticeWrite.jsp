<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>공지사항 작성</title>
    <link href="<c:url value='/css/notice/noticeWrite.css'/>" rel="stylesheet"/>
</head>
<body>
<%-- Header --%>

<section class="notice">
    <div class="page-title">
        <div class="container">
            <h3>공지사항 등록</h3>
        </div>
    </div>

    <div class="write-content">
        <div class="write-title">
            <input type="text" placeholder="제목을 입력하세요.">
        </div>
        <div class="write-detail">
            <textarea placeholder="내용을 입력하세요."></textarea>
        </div>
    </div>

</section>

<div class="button">
    <button class="btn" onclick="location.href='/notice/write'">등록하기</button>
    <button class="btn" onclick=history.back()>돌아가기</button>
</div>

<%-- Footer --%>
</body>
</html>
