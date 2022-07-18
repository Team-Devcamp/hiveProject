<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="/ckeditor/ckeditor.js"></script>

</head>
<body>
    <form action='<c:url value="/productmanage/product/register"/>' method="post">
        <label for="product-name">상품 이름</label>
        <input id="product-name" name="product_name" type="text">
        <label for="product-title">상품 제목</label>
        <input id="product-title" name="product_title" type="text">
        <label for="product-price">가격</label>
        <input id="product-price" name="product_price" type="text">
        <label for="category-id">카테고리</label>
        <select id="category-id" name="category_id">
            <c:forEach var="categoryDto" items="${categoryList}">
                <option value="${categoryDto.category_id}">${categoryDto.category_name}</option>
            </c:forEach>
        </select>
        <label for="sub-category-id">서브카테고리</label>
        <select id="sub-category-id" name="sub_category_id">
            <c:forEach var="subCategoryDto" items="${subCategoryList}">
                <option value="${subCategoryDto.sub_category_id}">${subCategoryDto.sub_category_name}</option>
            </c:forEach>
        </select>
        <label for="">썸네일</label>
        <input type="file" name="product_thumb_nail" accept="image/*">
        <textarea name="product_info" id="product-info" rows="20" cols="100">에디터</textarea>
        <button id="submit-btn">전송</button>
    </form>



    <script>
        CKEDITOR.replace( 'product-info', {//해당 이름으로 된 textarea에 에디터를 적용
            width:'100%',
            height:'400px',
            filebrowserUploadUrl:  "/productmanage/uploadimage"
        });
    </script>

</body>
</html>
