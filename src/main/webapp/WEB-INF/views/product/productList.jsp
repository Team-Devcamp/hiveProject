<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page session="true"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>productList</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <link rel="stylesheet" href="/css/common/reset.css">
    <link rel="stylesheet" href="/css/product/productList.css">

</head>
<body>
<div class="wrap">

    <div class="main">
        <div class="categories">
            <p>CATEGORIES</p>
            <p><a href="/product/list">전체</a></p>
            <c:forEach items="${categoryMap}" var="entry">
                <ul>
                    <p>${entry.key}</p>
                    <c:forEach items="${entry.value}" var="subCategoryDto">
                        <li><a href="/product/list?sub_category_id=${subCategoryDto.sub_category_id}">${subCategoryDto.sub_category_name}</a></li>
                    </c:forEach>
                </ul>
            </c:forEach>
        </div>
        <div class="contents">

            <ul class="classification">
                <li>최신순</li>
                <li>판매순</li>
                <li>높은 가격순</li>
                <li>낮은 가격순</li>
                <li>할인율순</li>
            </ul>
            <div class="product-list">
                <c:forEach var="productDto" items="${productList}">
                    <li class="product">
                        <a href="/product/detail?product_id=${productDto.product_id}">
                            <img src="/image/product/thumbnail/${productDto.product_thumb_nail}" alt="상품 이미지">
                        </a>
                        <a href="/product/detail?product_id=${productDto.product_id}">
                            <p>${productDto.product_title} </p>
                        </a>
                        <div class="detail-price">
                            <strong class="current-price">${productDto.product_price}</strong>
                            <span class="discount-rate">50%</span>
                        </div>
                    </li>
                </c:forEach>
            </div>
            <input type="hidden" name="offset" value="${offset}">
            <input type="hidden" name="product_num" value="${product_num}">
            <input type="hidden" name="productCnt" value="${productCnt}">
            <input type="hidden" name="sub_category_id" value="${sub_category_id}">
            <div class="show-more-btn">더 보기</div>
        </div>
    </div>

</div>
    <script>
        // 더 보기 버튼 클릭했을 때
        $(".show-more-btn").on("click", function() {
            let product_num = parseInt($("input[name=product_num]").val());
            let offset = parseInt($("input[name=offset]").val()) + product_num;
            let productCnt = parseInt($("input[name=productCnt]").val());
            let sub_category_id = $("input[name=sub_category_id]").val();

            $.ajax({
                type: 'GET',
                url: '/product/morelist?offset=' + offset + '&product_num=' + product_num + '&sub_category_id=' + sub_category_id,
                headers: {"content-type": "application/json"}, // 요청 헤더
                success: function(result) {
                    let tmp = '';

                    result.forEach(function(product) {
                        tmp += '<li class="product">'
                        tmp += ' <a href="/product/detail?product_id=' + product.product_id + '">'
                        tmp += ' <img src="/image/product/thumbnail/' + product.product_thumb_nail + '" alt="상품 이미지"></a>'
                        tmp += ' <a href="/product/detail?product_id=' + product.product_id + '">'
                        tmp += ' <p>' + product.product_title + '</p></a>'
                        tmp += ' <div class="detail-price">'
                        tmp += ' <strong class="current-price">' + product.product_price + '</strong>'
                        tmp += ' <span class="discount-rate">50%</span>'
                        tmp += ' </div>'
                        tmp += ' </li>'
                    });

                    $(tmp).appendTo(".product-list");

                },
                error : function() {
                    alert("에러 발생");
                }
            })

            $("input[name=offset]").val(offset);
            if (productCnt <= (offset + product_num)) {
                $('.show-more-btn').css("display", "none");
            }
        })
    </script>
</body>
</html>
