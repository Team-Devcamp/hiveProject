<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>공지사항</title>
    <link href="<c:url value='/css/notice/noticeList.css'/>" rel="stylesheet"/>
</head>
<body>
<%-- Header --%>

<section class="notice">
    <div class="page-title">
        <div class="container">
            <h3>공지사항</h3>
        </div>
    </div>

    <!-- board seach area -->
    <div id="board-search">
        <div class="container">
            <div class="search-window">
                <form action="">
                    <div class="search-wrap">
                        <label for="search" class="blind">공지사항 내용 검색</label>
                        <input id="search" type="search" name="" placeholder="검색어를 입력해주세요." value="">
                        <button type="submit" class="btn btn-dark">검색</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- board list area -->
    <div id="board-list">
        <div class="container">
            <table class="board-table">
                <thead>
                <tr>
                    <th scope="col" class="th-num">번호</th>
                    <th scope="col" class="th-title">제목</th>
                    <th scope="col" class="th-date">등록일</th>
                    <th scope="col" class="th-cnt">조회수</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="notice" items="${list}" varStatus="i">
                    <tr>
                        <td>${ph.totalCnt - (ph.page-1)*ph.pageSize - i.index}</td>
                        <th>
                            <a href="/notice/detail?notice_id=${notice.notice_id}">${notice.notice_title}</a>
                        </th>
                        <td><fmt:formatDate value="${notice.write_date}" pattern="yyyy-MM-dd"/></td>
                        <td>${notice.view_cnt}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="paging">
        <c:if test="${ph.showPrev}">
            <a href="<c:url value='/notice/list?page=${ph.beginPage-1}&pageSize=${ph.pageSize}'/>">&lt;</a>
        </c:if>
        <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
            <a class="current" href="<c:url value='/notice/list?page=${i}&pageSize=${ph.pageSize}'/>">${i}</a>
        </c:forEach>
        <c:if test="${ph.showNext}">
            <a href="<c:url value='/notice/list?page=${ph.endPage+1}&pageSize=${ph.pageSize}'/>">&gt;</a>
        </c:if>
    </div>
</section>

<div class="notice-write">
    <button class="write-btn" onclick="location.href='/notice/write'">공지 등록하기</button>
</div>

<%-- Footer --%>
</body>
</html>
