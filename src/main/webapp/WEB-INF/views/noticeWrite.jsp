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
            <h3>공지사항 등록</h3>
        </div>
        <div class="small-page-title">
            * 쇼핑몰과 관련된 공지사항을 등록해주세요.
        </div>
    </div>

    <form action="" method="post" id="form">
        <div class="write-content">
            <div class="input-title">제목</div>
            <div class="write-title">
                <input type="hidden" name="writer" value="${sessionScope.user_email}">
                <input type="text" name="notice_title" placeholder="제목을 입력하세요.">
            </div>
            <div class="input-content">내용</div>
            <div class="write-detail">
                <textarea name="notice_content" placeholder="내용을 입력하세요."></textarea>
            </div>
        </div>
        <div class="button">
            <button class="btn btn_insert">등록하기</button>
        </div>
    </form>
    <div class="button">
        <button class="btn" onclick="location.href='/notice/list'">돌아가기</button>
    </div>
</section>

<%-- Footer --%>

<script type="text/javascript">
    $(function () {
        $(".btn_insert").click(function () {
            if (!confirm('정말 등록하시겠습니까?')) return false;
            let form = $("#form");
            form.attr("action", "<c:url value='/notice/insert'/>");
            form.submit();
        });
    });
</script>

</body>
</html>
