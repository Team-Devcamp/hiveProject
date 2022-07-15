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
    <link rel="stylesheet" href="/css/common/reset.css">
    <link rel="stylesheet" href="/css/product/productList.css">

</head>
<body>
<div class="wrap">

    <div class="main">
        <div class="categories">
            <p>CATEGORIES</p>
            <c:forEach items="${categoryMap}" var="entry">
                <ul>
                    <p>${entry.key}</p>
                    <c:forEach items="${entry.value}" var="subCategoryDto">
                        <li>${subCategoryDto.sub_category_name}</li>
                    </c:forEach>
                </ul>
            </c:forEach>
        </div>
        <div class="contents">
            <h3 class="selected-category">선택된 카테고리</h3>

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
                        <a href="#">
                            <img src="" alt="상품 이미지">
                        </a>
                        <a href="#">
                            <p>${productDto.product_title}</p>
                        </a>
                        <div class="detail-price">
                            <strong class="current-price">${productDto.product_price}</strong>
                            <span class="discount-rate">50%</span>
                        </div>
                    </li>
                </c:forEach>

                <li class="product">
                    <a href="#"><img src="img/01.jpg" alt="상품 이미지"></a>
                    <p>남자 여름 무지 라운드 스판 레이어드 반팔 티셔츠</p>
                    <div class="detail-price">
                        <strong class="current-price">10,000원</strong>
                        <span class="discount-rate">50%</span>
                    </div>
                </li>
            </div>
        </div>
    </div>

</div>

</body>
</html>
