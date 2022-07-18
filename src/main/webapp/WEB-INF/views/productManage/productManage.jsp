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
<script>
    let msg = "${msg}";
    if(msg=="DEL_ERR")  alert("삭제되었거나 없는 상품입니다.");
    if(msg=="REG_ERR")  alert("상품 등록에 실패했습니다.");
    if(msg=="DEL_OK")   alert("상품이 삭제되었습니다.");
    if(msg=="REG_OK")   alert("상품이 등록되었습니다.");
</script>
<div class="wrap">

    <div class="main">
        <div class="product-list">
            <c:forEach var="productDto" items="${productList}">
                <form class="product-wrap" data-product-id="${productDto.product_id}">
                    <div class="product">
                        <div class="product-id" data-product-id="${productDto.product_id}"><p>상품 번호 : ${productDto.product_id} </p></div>
                        <div class="product-name"><p>상품 이름 : ${productDto.product_name} </p></div>
                        <div class="product-title"><p>상품 타이틀 : ${productDto.product_title} </p></div>
                        <div class="product-price"><p>상품 가격 : ${productDto.product_price} </p></div>
                        <div class="category-id"><p>상위 카테고리 : ${productDto.category_id} </p></div>
                        <div class="sub-category-id"><p>하위 카테고리 : ${productDto.sub_category_id} </p></div>
                    </div>
                    <button class="modify-product-btn">상품 수정</button>
                    <button class="delete-product-btn">상품 삭제</button>
                </form>
            </c:forEach>
        </div>
        <div class="product-options">

            <div id="product-option-form">
                <div class="product-option-list"></div>
                <div class="add-option">
                    <label for="product-id">상품번호</label>
                    <input id="product-id" name="product_id" type="text" placeholder="상품 번호를 입력하세요.">
                    <label for="option-name">상위옵션</label>
                    <input id="option-name" name="option_name" type="text" placeholder="상위옵션을 입력하세요">
                    <button id="add-option-btn" type="button">등록</button>
                </div>
                <div id="product-option-modify-form" style="display: none;">
                    <label for="modify-product-id">상품번호</label>
                    <input id="modify-product-id" name="product_id" type="text" readonly>
                    <label for="modify-option-id">상위옵션 번호</label>
                    <input id="modify-option-id" name="option_id" type="text" readonly>
                    <label for="modify-option-name">상위 옵션</label>
                    <input id="modify-option-name" name="option_name" type="text">
                    <button id="submit-modify-option-btn" type="button">수정 완료</button>
                </div>
            </div>
            <div id="product-option-detail-form">
                <div class="product-option-detail-list"></div>
                <div class="add-detail-option">
                    <label for="">상품번호</label>
                    <input class="product-id" name="product_id" type="text" placeholder="상품 번호를 입력하세요.">
                    <label for="">상위옵션 번호</label>
                    <input class="option-id" name="option_id" type="text" placeholder="상위옵션 번호를 입력하세요">
                    <label for="">하위옵션</label>
                    <input class="option-detail-name" name="option_detail_name" type="text" placeholder="하위옵션을 입력하세요">
                    <button id="add-option-detail-btn" type="button">등록</button>
                </div>
                <div id="product-option-detail-modify-form" style="display: none;">
                    <label for="">상품번호</label>
                    <input class="modify-product-id" name="product_id" type="text" readonly>
                    <label for="">상위옵션 번호</label>
                    <input class="modify-option-id" name="option_id" type="text" readonly>
                    <label for="">하위옵션 번호</label>
                    <input class="modify-option-detail-id" name="option_detail_id" type="text" readonly>
                    <label for="">하위옵션</label>
                    <input class="modify-option-detail-name" name="option_detail_name" type="text" placeholder="하위옵션을 입력하세요">
                    <button id="submit-modify-option-detail-btn" type="button">수정 완료</button>
                </div>
            </div>
        </div>
    </div>

</div>
<script>
    // list에 담긴 option객체들을 하나씩 꺼내서 html 태그에 담는 메서드(담기만 함)
    let optionToHtml = function(options) {
        let tmp = '';

        options.forEach(function(option) {
            tmp += '<div class="option-wrap"> '
            tmp += '<div class="option" data-product-id=' + option.product_id
            tmp += ' data-option-id=' + option.option_id
            tmp += ' data-option-name=' + option.option_name + '>'

            tmp += ' <div class="product-id"><p>상품 번호 ' + option.product_id + '</p></div>'
            tmp += ' <div class="option-id"><p>상위옵션 번호 ' + option.option_id + '</p></div>'
            tmp += ' <div class="option-name"><p>상위옵션 이름 ' + option.option_name + '</p></div>'
            tmp += '</div>'
            tmp += '<button class="modify-option-btn">수정</button>'
            tmp += '<button class="delete-option-btn">삭제</button>'
            tmp += '</div>'
        })

        return tmp;
    }

    // list에 담긴 option-detail 객체를 하나씩 꺼내서 html 태그에 담는 메서드(담기만 함)
    let optionDetailToHtml = function(options) {
        let tmp = '';
        options.forEach(function(option) {
            tmp += '<div class="option-detail-wrap"> '
            tmp += '<div class="option-detail" data-product-id=' + option.product_id
            tmp += ' data-option-id=' + option.option_id
            tmp += ' data-option-detail-id=' + option.option_detail_id
            tmp += ' data-option-detail-name=' + option.option_detail_name + '>'

            tmp += ' <div class="product-id"><p>상품 번호 ' + option.product_id + '</p></div>'
            tmp += ' <div class="option-id"><p>상위옵션 번호 ' + option.option_id + '</p></div>'
            tmp += ' <div class="option-detail-id"><p>하위옵션 번호 ' + option.option_detail_id + '</p></div>'
            tmp += ' <div class="option-detail-name"><p>하위옵션 이름 ' + option.option_detail_name + '</p></div>'
            tmp += '</div>'
            tmp += '<button class="modify-option-detail-btn">수정</button>'
            tmp += '<button class="delete-option-detail-btn">삭제</button>'
            tmp += '</div>'
        })

        return tmp;
    }

    //
    let productStockToHtml = function(options) {
        let tmp = '';
        options.forEach(function(option) {
            tmp += '<div class="product-stock-wrap"> '
            tmp += '<div class="product-stok" data-product-id=' + option.product_id
            tmp += ' data-option-id=' + option.option_id
            tmp += ' data-option-detail-id=' + option.option_detail_id
            tmp += ' data-option-detail-name=' + option.option_detail_name + '>'

            tmp += ' <div class="product-id"><p>상품 번호 ' + option.product_id + '</p></div>'
            tmp += ' <div class="option-id"><p>상위옵션 번호 ' + option.option_id + '</p></div>'
            tmp += ' <div class="option-detail-id"><p>하위옵션 번호 ' + option.option_detail_id + '</p></div>'
            tmp += ' <div class="option-detail-name"><p>하위옵션 이름 ' + option.option_detail_name + '</p></div>'
            tmp += '</div>'
            tmp += '<button class="modify-option-detail-btn">수정</button>'
            tmp += '<button class="delete-option-detail-btn">삭제</button>'
            tmp += '</div>'
        })

        return tmp;
    }

    // 서버에서 상품 상위옵션 리스트를 가져와서 태그에 담아 화면에 나타내는 메서드
    let showProductOptionList = function(product_id) {
        $.ajax({
            type:'GET',       // 요청 메서드
            url: '/productmanage/productoption/list?product_id=' + product_id,  // 요청 URI
            success : function(result){
                $('.product-option-list').html(optionToHtml(result)); // 서버로부터 응답이 도착하면 호출될 함수
            },
            error   : function(){ alert("상품 상위옵션 불러오기 실패") } // 에러가 발생했을 때, 호출될 함수
        }); // $.ajax()
    }

    // 서버에서 상품 하위옵션 리스트를 가져와서 태그에 담아 화면에 나타내는 메서드
    let showProductOptionDetailList = function (product_id, option_id) {
        $.ajax({
            type: 'GET',
            url: '/productmanage/productoptiondetail?product_id=' + product_id + '&option_id=' + option_id,
            success : function (result) {
                $('.product-option-detail-list').html(optionDetailToHtml(result));
            },
            error: function () {
                alert("하위옵션 리스트 불러오기 실패");
            }
        })
    }
    // 상품 삭제 버튼 클릭했을 때
    $(".delete-product-btn").click(function(){
        let product_id = $(this).parent().attr("data-product-id");

        if(!confirm("정말로 삭제하시겠습니까?")) return;
        let form = $(".product-wrap");
        form.attr("action", "/productmanage/product/delete?product_id=" + product_id);
        form.attr("method", "post");
        form.submit();
    })

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
                showProductOptionList(product_id);
                alert(result);

            },
            error   : function() {
                alert("상위옵션 등록 에러");
            } // 에러가 발생했을 때, 호출될 함수


        }); // $.ajax()

    });

    // 상위옵션 수정 버튼 눌렀을 때
    $(".product-option-list").on("click", ".modify-option-btn", function() {
        let option_id = $(this).parent().children().attr("data-option-id")
        let product_id = $(this).parent().children().attr("data-product-id");
        let option_name = $(this).parent().children().attr("data-option-name");
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
        $("input[id=modify-option-id]").val(option_id);
        $("input[id=modify-option-name]").val(option_name);

        // 4. 수정 완료버튼에 option_id 전달한다.
        $("#submit-modify-option-btn").attr("data-option-id", option_id);


    });

    // 수정완료 버튼 눌렀을 때
    $("#submit-modify-option-btn").on("click", function () {
        let option_id = $(this).attr("data-option-id");
        let product_id = $("input[id=modify-product-id]").val();
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
                showProductOptionList(product_id);
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
        let option_id = $(this).parent().children().attr("data-option-id");
        let product_id = $(this).parent().children().attr("data-product-id");

        $.ajax({
            type:'POST',       // 요청 메서드
            url: '/productmanage/productoption/delete?option_id='+ option_id,  // 요청 URI
            success : function(result){
                alert(result);
                showProductOptionList(product_id);
            },
            error   : function(){ alert("상품 상위옵션 삭제 에러") } // 에러가 발생했을 때, 호출될 함수
        }); // $.ajax()
    });

    // 하위 옵션 등록버튼 클릭했을 때
    $("#add-option-detail-btn").click(function(){
        let option_id = $("input[class=option-id]").val();
        let product_id = $("input[class=product-id]").val();
        let option_detail_name = $("input[class=option-detail-name]").val();

        if(option_detail_name.trim()=='') {
            alert("추가할 상위옵션을 입력하세요.");
            $("input[class=option-detail-name]").focus();
            return;
        }

        $.ajax({
            type:'POST',       // 요청 메서드
            url: '/productmanage/productoptiondetail/add',
            headers : { "content-type": "application/json"}, // 요청 헤더
            data : JSON.stringify({product_id:product_id, option_id:option_id, option_detail_name:option_detail_name}),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
            success : function(result){

                $("input[class=option-id]").val('');
                $("input[class=product-id]").val('');
                $("input[class=option-detail-name]").val('');
                showProductOptionDetailList(product_id, option_id);
                alert(result);

            },
            error   : function() {
                alert("하위옵션 등록 에러");
            } // 에러가 발생했을 때, 호출될 함수


        }); // $.ajax()
    });

    // 하위옵션 수정 버튼 눌렀을 때
    $(".product-option-detail-list").on("click", ".modify-option-detail-btn", function() {
        let option_id = $(this).parent().children().attr("data-option-id");
        let product_id = $(this).parent().children().attr("data-product-id");
        let option_detail_id = $(this).parent().children().attr("data-option-detail-id");
        let option_detail_name = $(this).parent().children().attr("data-option-detail-name");
        let modForm = $("#product-option-detail-modify-form").css("display");

        // 이미 수정버튼을 누른 상태이면 다시 수정 form 숨기기
        if(modForm=="block") {
            $("#product-option-detail-modify-form").css("display", "none");
            return;
        }
        // 1. form의 위치를 수정 버튼 바로 아래로 옮긴다.
        $("#product-option-detail-modify-form").appendTo($(this).parent());

        // 2. form을 나타내고
        $("#product-option-detail-modify-form").css("display", "block");

        // 3. product_id와 option_name을 input에 뿌려주기
        $("input[class=modify-product-id]").val(product_id);
        $("input[class=modify-option-id]").val(option_id);
        $("input[class=modify-option-detail-id]").val(option_detail_id);
        $("input[class=modify-option-detail-name]").val(option_detail_name);

    });

    // 하위옵션 수정완료 버튼 눌렀을 때
    $("#submit-modify-option-detail-btn").on("click", function () {
        let product_id = $("input[class=modify-product-id]").val();
        let option_id = $("input[class=modify-option-id]").val();
        let option_detail_id = $("input[class=modify-option-detail-id]").val();
        let option_detail_name = $("input[class=modify-option-detail-name]").val();

        console.log(option_detail_id, option_detail_name)

        if(option_detail_name.trim()=='') {
            alert("수정할 하위옵션을 입력하세요.");
            $("input[class=modify-option-detail-name]").focus();
            return;
        }

        $.ajax({
            type:'POST',
            url: '/productmanage/productoptiondetail/modify',
            headers: {"content-type" : "application/json"}, // 요청 헤더
            data : JSON.stringify({
                option_detail_id:option_detail_id, option_detail_name:option_detail_name}), // 서버로 전송할 데이터, stringify()로 직렬화 필요.
            success : function(result) {
                alert(result);
                showProductOptionDetailList(product_id, option_id);
            },
            error : function() {
                alert("상품 상위옵션 수정 에러")
            }

        });

        $("#product-option-detail-modify-form").css("display", "none")
        $("#product-option-detail-modify-form").appendTo("body");
    });

    // 상품하위옵션 삭제버튼 눌렀을 때
    $(".product-option-detail-list").on("click", ".delete-option-detail-btn", function() {
        let option_detail_id = $(this).parent().children().attr("data-option-detail-id");
        let product_id = $(this).parent().children().attr("data-product-id");
        let option_id = $(this).parent().children().attr("data-option-id");

        $.ajax({
            type: 'POST',
            url: '/productmanage/productoptiondetail/delete?option_detail_id=' + option_detail_id,
            headers: {"content-type" : "application/json"}, // 요청 헤더
            success : function (result) {
                alert(result);
                showProductOptionDetailList(product_id, option_id);
            },
            error : function () {
                alert("상품 하위옵션 삭제 실패");
            }
        });
    });




   // 특정 상품 클릭했을 때 등록된 상위옵션을 보여주는 이벤트
    $(".product").on("click", function () {
        let product_id = $(this).children('div:eq(0)').attr("data-product-id");
        showProductOptionList(product_id);

    })
    // 특정 상위옵션 클릭했을 때 등록된 하위옵션을 보여주는 이벤트
    $(".product-option-list").on("click", ".option", function() {
        let product_id = $(this).attr("data-product-id");
        let option_id = $(this).attr("data-option-id");

        showProductOptionDetailList(product_id, option_id);
    });

    // 특정 하위옵션 클릭했을 때 등록된 재고를 보여주는 이벤트
    $(".product-option-detail-list").on("click", ".option-detail", function() {
        let product_id = $(this).attr("data-product-id");
        let option_id = $(this).attr("data-option-id");

        showProductStock(product_id, option_id);
    });

    // 메인 메서드
    $(document).ready(function() {

    });

</script>
</body>
</html>
