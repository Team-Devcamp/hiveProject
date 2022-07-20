<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>공지사항</title>
    <link href="<c:url value='/css/notice/noticeWrite.css'/>" rel="stylesheet"/>
</head>
<body>
<%-- Header --%>

<section class="notice">
    <div class="page-title">
        <div class="container">
            <h3>공지사항 수정</h3>
        </div>
        <div class="small-page-title">
            * 공지사항을 수정해주세요.
        </div>
    </div>

    <form method="post">
        <div class="write-content">
            <div class="input-title">제목</div>
            <div class="write-title">
                <input type="text" name="notice_title" value="${data.notice_title}" placeholder="제목을 입력하세요.">
            </div>
            <div class="input-content">내용</div>
            <div class="write-detail">
                <textarea name="notice_content" placeholder="내용을 입력하세요.">${data.notice_content}</textarea>
            </div>
        </div>
        <div class="button">
            <button class="btn" type="submit">수정하기</button>
        </div>
    </form>
    <div class="button">
        <button class="btn" onclick=history.back();>돌아가기</button>
    </div>
</section>

<%-- Footer --%>

<script type="text/javascript">
    $(function () {
        $(".btn").click(function () {
            let result = confirm('정말 수정하시겠습니까?');
            if (result) {
                location.replace("/notice/update?notice_id=${data.notice_id}");
            } else {

            }
        })
    });
</script>
</body>
</html>
