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
    <link rel="stylesheet" href="/css/common/reset.css">

</head>
<body>

    <div class="wrap">

        <div class="main">
            <div class="category-list"></div>
            <div class="input-category-form">
                <label for="input-category-name">추가할 카테고리</label>
                <input id="input-category-name" name="category_name" type="text">
                <button id="add-category-btn">카테고리 추가</button>
            </div>

            <div class="sub-category-list"></div>
            <div class="input-sub-category-form">
                <label for="input-category-id">해당 카테고리 번호</label>
                <input id="input-category-id" name="category_id" type="text">
                <label for="input-sub-category-name">추가할 서브 카테고리</label>
                <input id="input-sub-category-name" name="sub_category_name" type="text">
                <button id="add-sub-category-btn">서브 카테고리 추가</button>
            </div>

            <div id="modify-category-form" style="display: none;">
                <label for="modify-category-id">카테고리 번호</label>
                <input id="modify-category-id" name="category_id" type="text" readonly>
                <label for="modify-category-name">카테고리</label>
                <input id="modify-category-name" name="category_name" type="text" placeholder="카테고리를 입력하세요">
                <button id="submit-modify-category-btn" type="button">수정 완료</button>
            </div>

            <div id="modify-sub-category-form" style="display: none;">
                <label for="modify-sub-category-id">서브카테고리 번호</label>
                <input id="modify-sub-category-id" name="sub_category_id" type="text" readonly>
                <label for="modify-category-name-for-sub">카테고리</label>
                <input id="modify-category-name-for-sub" name="category_name" type="text" readonly>
                <label for="modify-sub-category-name">서브카테고리</label>
                <input id="modify-sub-category-name" name="sub_category_name" type="text" placeholder="서브카테고리를 입력하세요">
                <button id="submit-modify-sub-category-btn" type="button">수정 완료</button>
            </div>
        </div>


    </div>
    <script>
        // category list에 담긴 객체들을 하나씩 꺼내서 html 태그에 담는 메서드(담기만 함)
        let CategorytoHtml = function(categories) {
            let tmp = "<ul>";

            categories.forEach(function(category) {
                tmp += '<li data-category-id=' + category.category_id
                tmp += ' data-category-name=' + category.category_name + '>'

                tmp += ' <p>카테고리 번호 : <span class="category-id">' + category.category_id + '</span></p>'
                tmp += ' <p>카테고리 : <span class="category-name">' + category.category_name + '</span></p>'
                tmp += ' <button class="modify-category-btn">수정</button>'
                tmp += ' <button class="delete-category-btn">삭제</button>'

                tmp += '</li>'
            });

            return tmp + "</ul>";
        }
        // 서버에서 category List를 가져와서 태그에 담아 화면에 나타내는 메서드
        let showCategoryList = function() {
            $.ajax({
                type:'GET',       // 요청 메서드
                url: '/category/categorylist',  // 요청 URI
                success : function(result){
                    $('.category-list').html(CategorytoHtml(result)); // 서버로부터 응답이 도착하면 호출될 함수
                },
                error   : function(){ alert("서브 카테고리 리스트 불러오기 실패") } // 에러가 발생했을 때, 호출될 함수
            }); // $.ajax()
        }

        // sub_category List에 담긴 객체들을 하나씩 꺼내서 html 태그에 담는 메서드(담기만 함)
        let subCategorytoHtml = function(sub_categories) {
            let tmp = "<ul>";

            sub_categories.forEach(function(sub_category) {
                tmp += '<li data-sub-category-id=' + sub_category.sub_category_id
                tmp += ' data-category-id=' + sub_category.category_id
                tmp += ' data-sub-category-name=' + sub_category.sub_category_name + '>'

                tmp += ' <p>서브 카테고리 번호 : <span class="sub_category-id">' + sub_category.sub_category_id + '</span></p>'
                tmp += ' <p>카테고리 번호 : <span class="category-id">' + sub_category.category_id + '</span></p>'
                tmp += ' <p>서브 카테고리 이름 : <span class="sub-category-name">' + sub_category.sub_category_name + '</span></p>'
                tmp += ' <button class="modify-sub-category-btn">수정</button>'
                tmp += ' <button class="delete-sub-category-btn">삭제</button>'

                tmp += '</li>'
            });

            return tmp + "</ul>";
        }
        // 서버에서 서브 카테고리 리스트를 가져와서 태그에 담아 화면에 나타내는 메서드
        let showSubCategoryList = function() {
            $.ajax({
                type:'GET',       // 요청 메서드
                url: '/category/subcategorylist',  // 요청 URI
                success : function(result){
                    $('.sub-category-list').html(subCategorytoHtml(result)); // 서버로부터 응답이 도착하면 호출될 함수
                },
                error   : function(){ alert("서브 카테고리 리스트 불러오기 실패") } // 에러가 발생했을 때, 호출될 함수
            }); // $.ajax()
        }

        /* 카테고리 */
        // 카테고리 추가 버튼 눌렀을 때
        $("#add-category-btn").click(function() {
            let category_name = $("input[name=category_name]").val();

            if(category_name.trim()=='') {
                alert("추가할 카테고리를 입력하세요.");
                $("input[name=category_name]").focus();
                return;
            }

            $.ajax({
                type: 'POST', // POST 요청
                url: '/category/add',
                headers: {"content-type": "application/json"}, // 요청 헤더
                data: JSON.stringify({category_name:category_name}), // 전송할 데이터(직렬화)
                success: function(result) {
                    alert(result);
                    $("input[name=category_name]").val('');

                    showCategoryList();
                },
                error: function() {
                    alert("카테고리 등록 에러");
                }
            });
        });

        // 카테고리 수정 버튼 눌렀을 때
        $(".category-list").on("click", ".modify-category-btn", function() {
            let category_id = $(this).parent().attr("data-category-id");
            let category_name = $(this).parent().attr("data-category-name");
            let modForm = $("#modify-category-form").css("display");

            // 이미 카테고리 수정 버튼을 누른 상태이면 다시 수정 form을 숨기기
            if(modForm=="block") {
                $("#modify-category-form").css("display", "none");
                return;
            }

            // 1. form의 위치를 수정 버튼 바로 아래로 옮긴다.
            $("#modify-category-form").appendTo($(this).parent());

            // 2. form을 나타내고
            $("#modify-category-form").css("display", "block");

            // 3. category_id와 category_name을 input에 뿌려주기
            $("input[id=modify-category-id]").val(category_id);
            $("input[id=modify-category-name]").val(category_name);

            // 4. 수정 완료버튼에 category_id를 전달한다.
            $("#submit-modify-category-btn").attr("data-category-id", category_id);

        });

        // 수정 완료 버튼 눌렀을 때
        $("#submit-modify-category-btn").on("click", function () {
            let category_id = $(this).attr("data-category-id");
            let category_name = $("input[id=modify-category-name]").val();

            if(category_name.trim()=='') {
                alert("수정할 카테고리를 입력하세요.");
                $("input[id=modify-category-name]").focus();
                return;
            }

            $.ajax({
                type:'POST',
                url: '/category/modify',
                headers: {"content-type" : "application/json"}, // 요청 헤더
                data: JSON.stringify({category_id:category_id, category_name:category_name}),
                success: function(result) {
                    alert("카테고리 수정 완료");
                    showCategoryList();
                },
                error: function() {
                    alert("카테고리 수정 에러");
                }
            }); // ajax
        });

        // 카테고리 삭제 버튼 눌렀을 때
        $(".category-list").on("click", ".delete-category-btn", function() {
            let category_id = $(this).parent().attr("data-category-id");

            $.ajax({
                type:'POST',
                url: '/category/delete',
                headers: {"content-type" : "application/json"}, // 요청 헤더
                data: category_id,
                success: function(result) {
                    alert("카테고리 삭제 완료");
                    showCategoryList();
                },
                error: function() {
                    alert("카테고리 삭제 에러");
                }
            }); // ajax
        });

        /* 서브 카테고리 */


        // 서브 카테고리 추가 버튼 눌렀을 때
        $("#add-sub-category-btn").click(function() {
            let sub_category_name = $("input[name=sub_category_name]").val();
            let category_id = $("input[name=category_id]").val();

            if(sub_category_name.trim()=='') {
                alert("추가할 카테고리를 입력하세요.");
                $("input[name=sub_category_name]").focus();
                return;
            }

            $.ajax({
                type: 'POST', // POST 요청
                url: '/category/addsub',
                headers: {"content-type": "application/json"}, // 요청 헤더
                data: JSON.stringify({category_id:category_id, sub_category_name:sub_category_name}), // 전송할 데이터(직렬화)
                success: function(result) {
                    alert(result);
                    $("input[name=sub_category_name]").val('');

                    showSubCategoryList();
                },
                error: function() {
                    alert("서브카테고리 등록 에러");
                }
            });
        });

        // 서브카테고리 수정 버튼 눌렀을 때
        $(".sub-category-list").on("click", ".modify-sub-category-btn", function() {
            let sub_category_id = $(this).parent().attr("data-sub-category-id");
            let sub_category_name = $(this).parent().attr("data-sub-category-name");
            let category_id = $(this).parent().attr("data-category-id");
            let modForm = $("#modify-sub-category-form").css("display");

            // 이미 카테고리 수정 버튼을 누른 상태이면 다시 수정 form을 숨기기
            if(modForm=="block") {
                $("#modify-sub-category-form").css("display", "none");
                return;
            }

            // 1. form의 위치를 수정 버튼 바로 아래로 옮긴다.
            $("#modify-sub-category-form").appendTo($(this).parent());

            // 2. form을 나타내고
            $("#modify-sub-category-form").css("display", "block");

            // 3. category_id와 category_name을 input에 뿌려주기
            $("input[id=modify-sub-category-id]").val(sub_category_id);
            $("input[id=modify-category-name-for-sub]").val(category_id);
            $("input[id=modify-sub-category-name]").val(sub_category_name);

            // 4. 수정 완료버튼에 sub_category_id를 전달한다.
            $("#submit-modify-sub-category-btn").attr("data-sub-category-id", sub_category_id);

        });

        // 수정 완료 버튼 눌렀을 때
        $("#submit-modify-sub-category-btn").on("click", function () {
            let sub_category_id = $(this).attr("data-sub-category-id");
            let sub_category_name = $("input[id=modify-sub-category-name]").val();

            if(sub_category_name.trim()=='') {
                alert("수정할 카테고리를 입력하세요.");
                $("input[id=modify-sub-category-name]").focus();
                return;
            }

            $.ajax({
                type:'POST',
                url: '/category/modifysub',
                headers: {"content-type" : "application/json"}, // 요청 헤더
                data: JSON.stringify({sub_category_id:sub_category_id, sub_category_name:sub_category_name}),
                success: function(result) {
                    alert("서브카테고리 수정 완료");
                    showSubCategoryList();
                },
                error: function() {
                    alert("서브카테고리 수정 에러");
                }
            }); // ajax
        });

        // 카테고리 삭제 버튼 눌렀을 때
        $(".sub-category-list").on("click", ".delete-sub-category-btn", function() {
            let sub_category_id = $(this).parent().attr("data-sub-category-id");
            let sub_category_name = $(this).parent().attr("data-sub-category-name");
            let category_id = $(this).parent().attr("data-category-id");

            $.ajax({
                type:'POST',
                url: '/category/deletesub',
                headers: {"content-type" : "application/json"}, // 요청 헤더
                data: sub_category_id,
                success: function(result) {
                    alert("카테고리 삭제 완료");
                    showSubCategoryList();
                },
                error: function() {
                    alert("카테고리 삭제 에러");
                }
            }); // ajax
        });

        // 메인 메서드
        $(document).ready(function() {
            showCategoryList();
            showSubCategoryList();
        });

    </script>
</body>
</html>
