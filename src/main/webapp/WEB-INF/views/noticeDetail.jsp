<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>공지사항 작성</title>
    <link href="<c:url value='/css/notice/noticeDetail.css'/>" rel="stylesheet"/>
</head>
<body>
<%-- Header --%>


<section class="section">
    <table>
        <tr>
            <th>${data.notice_id}</th>
            <th>${data.notice_title}</th>
            <th><fmt:formatDate value="${data.write_date}" pattern="yyyy-MM-dd"/></th>
        </tr>
        <td colspan="3">${data.notice_content}</td>
    </table>
</section>

<div class="button">
    <button class="btn" onclick="location.href='/notice/update'">수정하기</button>
    <button class="btn" onclick="location.href='/notice/delete'">삭제하기</button>
    <button class="btn" onclick="location.href='/notice/list'">돌아가기</button>
</div>

<%-- Footer --%>
</body>
</html>
