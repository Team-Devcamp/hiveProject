<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <link rel="stylesheet" href="/css/event/event_board.css" />
    <title>Title</title>
</head>
<body>
    <div class="event-board-wrap">
        <div class="event-board">
            <div class="board-header">
                <h1 class="board-title">${eventDto.event_title}</h1>
                <div class="header-info">
                    <span>조회수 ${eventDto.view_cnt}</span>
                    <span>등록일 <fmt:formatDate value="${eventDto.write_date}" pattern="yyyy-MM-dd" /></span>
                </div>
            </div>
            <div class="board-content">
                ${eventDto.event_content}
            </div>
            <div class="board-footer">
                <form class="hidden-form" id="form">
                    <input type="hidden" name="event_id" value="${eventDto.event_id}">
                    <input type="hidden" name="event_title" value="${eventDto.event_title}" readonly>
                    <input type="hidden" name="writer" value="${eventDto.writer}" readonly>
                    <textarea name="content" cols="10" rows="10" readonly hidden>${eventDto.event_content}</textarea>
                    <button type="button" id="listBtn" class="list-btn">목록으로 돌아가기</button>
                    <button type="button" id="modifyBtn" class="modify-btn">수정</button>
                    <button type="button" id="removeBtn" class="remove-btn">삭제</button>
                </form>
            </div>
        </div>
    </div>

</body>
<script>
    $(document).ready(function () {
        $('#listBtn').on("click", function () {
            location.href = "<c:url value='/event/list?page=${page}&pageSize=${pageSize}' />";
        });

        $('#removeBtn').on("click", function () {
            if(!confirm("삭제한 글은 복구할 수 없습니다. 해당 글을 삭제 하시겠습니까?")) return;
            let form = $('#form');
            form.attr("action", "<c:url value='/event/remove?page=${page}&pageSize=${pageSize}' />");
            form.attr("method", "post");
            form.submit();
        });

        $('#modifyBtn').on("click", function () {
            location.href = "<c:url value='/event/write?event_id=${eventDto.event_id}&page=${page}&pageSize=${pageSize}' />";
        });
    });

    let msg = "${msg}"
    if (msg=="Modify Success") alert("게시물이 수정되었습니다.");
</script>
</html>
