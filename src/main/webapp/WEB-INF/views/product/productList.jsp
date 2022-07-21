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
        </div>
    </div>

</div>

</body>
</html>
