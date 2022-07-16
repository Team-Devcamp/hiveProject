<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page session="true"%>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>productManage</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <link rel="stylesheet" href="/css/common/reset.css">

</head>
<body>
<div class="wrap">

    <div class="main">
        <div class="products">
            상품들
        </div>
        <div class="product-options">
            <div id="product-option-form">
                <div class="product-option-list"></div>
                <div class="add-option">
                    <label for="product-id">상품번호</label>
                    <input id="product-id" name="product_id" type="text" placeholder="상품 번호를 입력하세요.">
                    <label for="option-name">상품 상위옵션</label>
                    <input id="option-name" name="option_name" type="text" placeholder="상위옵션을 입력하세요">
                    <button id="add-option-btn" type="button">등록</button>
                </div>
                <div id="product-option-modify-form" style="display: none;">
                    <label for="modify-product-id">상품번호</label>
                    <input id="modify-product-id" name="product_id" type="text" readonly placeholder="상품 번호를 입력하세요.">
                    <label for="modify-option-name">상품 상위옵션</label>
                    <input id="modify-option-name" name="option_name" type="text" placeholder="상위옵션을 입력하세요">
                    <button id="submit-modify-option-btn" type="button">수정 완료</button>
                </div>
            </div>
        </div>
    </div>

</div>
<script>
    // list에 담긴 객체들을 하나씩 꺼내서 html 태그에 담는 메서드(담기만 함)
    let toHtml = function(options) {
        let tmp = "<ul>";

        // product_id, option_id, option_name

        options.forEach(function(option) {
            tmp += '<li data-product-id=' + option.product_id
            tmp += ' data-option-id=' + option.option_id
            tmp += ' data-option-name=' + option.option_name + '>'

            tmp += ' <div class="product-id"><p>상품 번호 ' + option.product_id + '</p></div>'
            tmp += ' <div class="option-id"><p>상위옵션 번호 ' + option.option_id + '</p></div>'
            tmp += ' <div class="option-name"><p>상위옵션 이름 ' + option.option_name + '</p></div>'
            tmp += '<button class="modify-option-btn">수정</button>'
            tmp += '<button class="delete-option-btn">삭제</button>'

            tmp += '</li>'
        })

        return tmp + "</ul>";
    }

    // 서버에서 상품 상위옵션 리스트를 가져와서 태그에 담아 화면에 나타내는 메서드
    let showProductOptionList = function() {
        $.ajax({
            type:'GET',       // 요청 메서드
            url: '/productmanage/productoption/list',  // 요청 URI
            success : function(result){
                $('.product-option-list').html(toHtml(result)); // 서버로부터 응답이 도착하면 호출될 함수
            },
            error   : function(){ alert("상품 상위옵션 불러오기 실패") } // 에러가 발생했을 때, 호출될 함수
        }); // $.ajax()
    }

    // 상위옵션 추가 버튼 클릭했을 때
    $("#add-option-btn").click(function(){
        let option_name = $("input[name=option_name]").val();
        let product_id = $("input[name=product_id]").val();

        if(option_name.trim()=='') {
            alert("추가할 상위옵션을 입력하세요.");
            $("input[name=option_name]").focus();
            return;
        }

        $.ajax({
            type:'POST',       // 요청 메서드
            url: '/productmanage/productoption/add',
            headers : { "content-type": "application/json"}, // 요청 헤더
            data : JSON.stringify({product_id:product_id, option_name:option_name}),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
            success : function(result){
                $("input[name=option_name]").val('');
                $("input[name=product_id]").val('');

                alert(result);
                showProductOptionList();
            },
            error   : function() {
                alert("상위옵션 등록 에러");
            } // 에러가 발생했을 때, 호출될 함수


        }); // $.ajax()

    });

    // 상위옵션 수정 버튼 눌렀을 때
    $(".product-option-list").on("click", ".modify-option-btn", function() {
        let option_id = $(this).parent().attr("data-option-id");
        let product_id = $(this).parent().attr("data-product-id");
        let option_name = $(this).parent().attr("data-option-name");
        let modForm = $("#product-option-modify-form").css("display");

        // 이미 수정버튼을 누른 상태이면 다시 수정 form 숨기기
        if(modForm=="block") {
            $("#product-option-modify-form").css("display", "none");
            return;
        }
        // 1. form의 위치를 수정 버튼 바로 아래로 옮긴다.
        $("#product-option-modify-form").appendTo($(this).parent());

        // 2. form을 나타내고
        $("#product-option-modify-form").css("display", "block");

        // 3. product_id와 option_name을 input에 뿌려주기
        $("input[id=modify-product-id]").val(product_id);
        $("input[id=modify-option-name]").val(option_name);

        // 4. 수정 완료버튼에 option_id 전달한다.
        $("#submit-modify-option-btn").attr("data-option-id", option_id);


    });

    // 수정완료 버튼 눌렀을 때
    $("#submit-modify-option-btn").on("click", function () {
        let option_id = $(this).attr("data-option-id");
        // let product_id = $("input[id=modify-product-id]").val();
        let option_name = $("input[id=modify-option-name]").val();

        if(option_name.trim()=='') {
            alert("수정할 상위옵션을 입력하세요.");
            $("input[id=modify-option-name]").focus();
            return;
        }

        $.ajax({
            type:'POST',
            url: '/productmanage/productoption/modify',
            headers: {"content-type" : "application/json"}, // 요청 헤더
            data : JSON.stringify({option_id:option_id, option_name:option_name}), // 서버로 전송할 데이터, stringify()로 직렬화 필요.
            success : function(result) {
                alert(result);
                showProductOptionList();
            },
            error : function() {
                alert("상품 상위옵션 수정 에러")
            }
        }); // $.ajax()

        $("#product-option-modify-form").css("display", "none")
        $("input[id=modify-product-id]").val('');
        $("input[id=modify-option-name]").val('');
        $("#product-option-modify-form").appendTo("body");
    });

    // 상위옵션 삭제 버튼 눌렀을 때
    $(".product-option-list").on("click", ".delete-option-btn", function() {
        let option_id = $(this).parent().attr("data-option-id");

        $.ajax({
            type:'POST',       // 요청 메서드
            url: '/productmanage/productoption/delete?option_id='+ option_id,  // 요청 URI
            success : function(result){
                alert(result);
                showProductOptionList();
            },
            error   : function(){ alert("상품 상위옵션 삭제 에러") } // 에러가 발생했을 때, 호출될 함수
        }); // $.ajax()
    });

    // 메인 메서드
    $(document).ready(function() {
        showProductOptionList();

    });

</script>
</body>
</html>
