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
    <title>addCategory</title>
    <link rel="stylesheet" href="/css/common/reset.css">

</head>
<body>
<script>
    let msg = "${msg}";
    if(msg=="CATEGORY_ADD_ERR")
        alert("카테고리 추가에 실패하였습니다. 다시 시도해 주세요.");
    if(msg=="CATEGORY_MODIFY_ERR")
        alert("카테고리 수정에 실패하였습니다. 다시 시도해 주세요.")
</script>
<div class="wrap">

    <div class="main">
        <p>${categoryDto.category_id} 카테고리를 ${mode=="new" ? "추가" : "수정"}하는 화면입니다.</p>
        <form id="form" action="" method="">
            <input id="category-id" name="category_id" type="hidden" value="${categoryDto.category_id}">
            <input id="category-name" name="category_name" type="text" value="${categoryDto.category_name}">
            ${mode=="new" ? '<button type="button" id="addBtn">추가하기</button>' : '<button type="button" id="modBtn">수정하기</button>'}

        </form>
    </div>

</div>
<script>
    let formCheck = function() {
        let form = document.getElementById("form");
        if(form.category_name.value=="") {
            alert("카테고리를 입력해 주세요.");
            form.category_name.focus();
            return false;
        }
        return true;
    }

    $(document).ready(function() {

        $("#addBtn").on("click", function() {

            let form = $("#form");
            form.attr("action", "<c:url value='/category/add'/>");
            form.attr("method", "post");

            if(formCheck()) {
                form.submit();
            }
        });

        $("#modBtn").on("click", function() {

            let form = $("#form");
            form.attr("action", "<c:url value='/category/modify'/>");
            form.attr("method", "post");

            if(formCheck()) {
                form.submit();
            }
        });

    });
</script>
</body>
</html>
