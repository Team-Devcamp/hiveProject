<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page session="true"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <title>categoryList</title>
</head>
<body>
<script>
    let msg = "${msg}";
    if(msg=="CATEGORY_ADD_SUCCESS")
        alert("카테고리가 추가되었습니다.");
    if(msg=="CATEGORY_MODIFY_SUCCESS")
        alert("카테고리가 수정되었습니다.");
</script>
    <div class="wrap">
        <div class="header">헤더입니다</div>
        <div class="main">
            <c:forEach var="categoryDto" items="${categoryList}">
                <div class="category">
                    <div class="category-id">${categoryDto.category_id}</div>
                    <div class="category-name">${categoryDto.category_name}</div>
                    <button class="modifyBtn" onclick="location.href='<c:url value="/category/modify?category_id=${categoryDto.category_id}&category_name=${categoryDto.category_name}"/>'">수정</button>
                    <button class="removeBtn">삭제</button>
                </div>
            </c:forEach>
        </div>
        <button id="addBtn" class="btn-add" onclick="location.href='<c:url value="/category/add"/>'">카테고리 추가</button>


        <div class="footer">푸터입니다</div>
    </div>
    <script>

        $(".removeBtn").click(function(){
            let category_id = $(this).parent().children('.category-id').text();

            $.ajax({
                type:'POST',       // 요청 메서드
                url: '/category/remove?category_id=' + category_id,  // 요청 URI
                success : function(){
                    alert("카테고리가 삭제되었습니다.");
                    location.href='http://localhost:9000/category/list';
                    //location.reload();
                    // $(this).unwrap()
                },
                error   : function(){ alert("카테고리 삭제에 실패했습니다.") } // 에러가 발생했을 때, 호출될 함수
            }); // $.ajax()
        });
    </script>
</body>
</html>
