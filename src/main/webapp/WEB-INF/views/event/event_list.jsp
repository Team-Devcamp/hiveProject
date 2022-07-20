<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <link rel="stylesheet" href="/css/event/event_list.css" />
    <title>Title</title>
</head>
<body>

<main class="main-event">

    <div class="event-list">

        <c:choose>
            <c:when test="${empty list}">
                <div class="no-event">
                    <span class="no-list">현재 진행중인 이벤트가 없습니다.</span>
                </div>
            </c:when>
            <c:when test="${!empty list}">
                <div class="grid-event">
                    <c:forEach var="eventDto" items="${list}">
                        <a class="event-link" href="<c:url value='/event/read?event_id=${eventDto.event_id}&page=${page}&pageSize=${pageSize}'/> ">
                                ${eventDto.event_id}
                                ${eventDto.event_title}
                                ${eventDto.writer}
                                ${eventDto.view_cnt}
                                ${eventDto.write_date}
                            <div> Thumbnail </div>
                        </a>
                    </c:forEach>
                </div>
            </c:when>
        </c:choose>
    </div>

    <div class="page-nav">
        <c:if test="${ph.showPrev}">
            <a href="<c:url value='/event/list?page=${ph.beginPage-1}&pageSize=${ph.pageSize}' />"><i class="fa-solid fa-angle-left"></i></a>
        </c:if>
        <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
            <a href="<c:url value='/event/list?page=${i}&pageSize=${ph.pageSize}' />">${i}</a>
        </c:forEach>
        <c:if test="${ph.showNext}">
            <a href="<c:url value='/event/list?page=${ph.endPage+1}&pageSize=${ph.pageSize}' />"><i class="fa-solid fa-angle-right"></i></a>
        </c:if>
    </div>

</main>
<script>
    let msg = "${msg}"
    if (msg=="Delete Success") alert("삭제 처리 되었습니다.");
    if (msg=="Delete Error") alert("삭제에 실패 했습니다.");
    if (msg=="write Success") alert("이벤트가 등록 되었습니다.");
    if (msg=="Load Error") alert("삭제되었거나 없는 게시글 입니다.");
</script>

</body>
</html>
