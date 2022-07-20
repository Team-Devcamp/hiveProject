<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <script src="https://cdn.ckeditor.com/ckeditor5/34.2.0/classic/ckeditor.js"></script>
    <link rel="stylesheet" href="/css/event/event_write.css" />
    <title>Title</title>
</head>
<body>

<c:choose>
    <c:when test="${empty eventDto.event_id}">
        <form id="formWrite" name="formWrite" method="post" action="/event/write">
    </c:when>
    <c:when test="${!empty eventDto.event_id}">
        <form id="formWrite" name="formWrite" method="post" action="/event/modify?page=${page}&pageSize=${pageSize}">
    </c:when>
</c:choose>
    <div class="form-wrap">
        <div class="board-header">
            <input type="hidden" name="event_id" value="${eventDto.event_id}">
            <c:if test="${eventDto.event_id==null}">
            <input type="hidden" name="writer" value="${sessionScope.user.user_id }" >
            </c:if>
            <div class="board-header_title">
                <h3 class="label">제목</h3>
                <input type="text" maxlength="25" name="event_title" value="${eventDto.event_title}" placeholder="제목을 입력하세요" required>
            </div>
        </div>
        <div class="board-content">
            <h3 class="label">내용</h3>
            <textarea class="editor" rows="10" maxlength="4000" name="event_content" placeholder="내용을 입력하세요" required>${eventDto.event_content}</textarea>
        </div>
        <div class="board-attach">
            <label for="attach-file">이곳을 클릭해 파일을 업로드 하세요.</label>
            <input id="attach-file" type="file" >
        </div>
        <div class="board-btn">
            <c:choose>
                <c:when test="${empty eventDto.event_id}">
                    <input type="submit" id="save-btn" value="등록" />
                </c:when>
                <c:when test="${!empty eventDto.event_id}">
                    <input type="submit" id="modify-btn" value="수정" />
                </c:when>
            </c:choose>
        </div>
    </div>
</form>

<script>

    $(document).ready(function () {
        $("#save-btn").click(function(){
            const title = document.formWrite.event_title.value;
            // const editorData = editor.getData();
            if(title==""){
                alert("제목을 입력하세요")
                document.formWrite.event_title.focus();
                return;
            }
            // if(content==""){
            //     alert("내용을 입력하세요");
            //     // document.formWrite.event_content.focus();
            //     return;
            // }


            document.formWrite.submit();
        })
    });

    let msg = "${msg}"
    if (msg=="Write Error") alert("이벤트 등록에 실패했습니다. 다시 시도해 주세요.");
    if (msg=="Modify Error") alert("이벤트 수정에 실패했습니다. 다시 시도해 주세요.");

    ClassicEditor
        .create( document.querySelector( '.editor' ) )
        .catch( error => {
            console.error( error );
        } );
</script>

</body>
</html>
