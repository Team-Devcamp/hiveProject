<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="/css/home/search.css" />
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <title>Title</title>
</head>
<body>

    <div class="search-result">

        <div class="result-cnt">
            <span>상품 검색결과 (${resultCnt}건)</span>
        </div>

        <div class="result-item">
            <c:forEach var="productDto" items="${list}">
                <div class="result-item-link">
                    <a href="/product/detail?product_id=${productDto.product_id}">
                        <div class="item-thumb">
                            ${productDto.product_thumb_nail}
                        </div>
                        <div class="result-item__info">
                            <span>${productDto.product_title}</span>
                            <span>${productDto.product_price}</span>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
        <div class="more-btn">
            <button class="more-btn__btn">더보기</button>
        </div>
    </div>

<script>
    $(function(){
        $(".result-item-link").slice(0, 20).show();
        if($(".result-item-link:hidden").length == 0){
            $(".more-btn__btn").addClass('none-active');
        }
        $(".more-btn__btn").click(function(e){
            e.preventDefault();
            $(".result-item-link:hidden").slice(0, 20).show();
            if($(".result-item-link:hidden").length == 0){
                $(".more-btn__btn").addClass('none-active');
            }
        });
    });
</script>
</body>
</html>
