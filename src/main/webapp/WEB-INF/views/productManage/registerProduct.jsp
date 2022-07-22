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
<<<<<<< HEAD
    <link rel="stylesheet" href="/css/common/reset.css">
    <link rel="stylesheet" href="/css/product_manage/registerProduct.css">
=======
>>>>>>> parent of 3e26390 ([Feature] 상품 등록시 썸네일 업로드 구현, 스토어에서 상품 썸네일 이미지 출력되도록 url설정)

</head>
<body>
    <script>
        let msg = "${msg}";
        if(msg=="MOD_ERR")  alert("상품 수정에 실패했습니다. 다시 시도해주세요.");
    </script>
    <h2>상품 등록</h2>
    <form id="register-form" action='' method="POST">

        <div id="input-wrap">
            <input id="product-id" name="product_id" type="hidden" value="${productDto.product_id}">
            <label for="product-name">상품 이름</label>
            <input id="product-name" name="product_name" type="text" value="${productDto.product_name}">
            <label for="product-title">상품 제목</label>
            <input id="product-title" name="product_title" type="text" value="${productDto.product_title}">
            <label for="product-price">가격</label>
            <input id="product-price" name="product_price" type="text" value="${productDto.product_price}">
            <label for="category-id">카테고리</label>
            <select id="category-id" name="category_id">
                <c:forEach var="categoryDto" items="${categoryList}">
                    <option value="${categoryDto.category_id}" ${categoryDto.category_id == productDto.category_id ? "selected" : ""}>${categoryDto.category_name}</option>
                </c:forEach>
            </select>
            <label for="sub-category-id">서브카테고리</label>
            <select id="sub-category-id" name="sub_category_id">
                <c:forEach var="subCategoryDto" items="${subCategoryList}">
                    <option value="${subCategoryDto.sub_category_id}" ${subCategoryDto.sub_category_id == productDto.sub_category_id ? "selected" : ""}>${subCategoryDto.sub_category_name}</option>
                </c:forEach>
            </select>
        </div>

        <textarea name="product_info" id="product-info" rows="20" cols="100">${productDto.product_info}</textarea>
        <div id="thumbnail-wrap">
            <label for="">썸네일</label>
            <input type="file" id="fileItem" name="" accept="image/*" multiple>
        </div>
        <div id="uploadResult">
        </div>
        <button id="submit-btn" ${mode=="new" ? "" : 'style="display: none;"'}>상품 등록</button>
        <button id="modify-btn" ${mode!="new" ? "" : 'style="display: none;"'}>상품 수정</button>
    </form>

    <script>
        CKEDITOR.replace( 'product-info', {//해당 이름으로 된 textarea에 에디터를 적용
            width:'86%',
            height:'600px',
            filebrowserUploadUrl:  "/upload_image"
        });

        /* 이미지 업로드 */
        $("input[type='file']").on("change", function(e){

            /* 이미지 존재시 삭제 */
            if($(".imgDeleteBtn").length > 0){
                deleteFile();
            }

            let formData = new FormData();
            let fileInput = $('input[id="fileItem"]');
            let fileList = fileInput[0].files;
            let fileObj = fileList[0];

            if(!fileCheck(fileObj.name, fileObj.size)){
                return false;
            }

            for(let i = 0; i < fileList.length; i++){
                formData.append("uploadFile", fileList[i]);
            }

            $.ajax({
                url: '/productmanage/upload_thumbnail',
                processData : false,
                contentType : false,
                data : formData,
                type : 'POST',
                dataType : 'json',
                success : function (result) {
                    console.log(result);
                    showUploadImage(result);
                },
                error : function(result) {
                    alert("이미지 파일이 아닙니다.");
                }
            });
        });

        let regex = new RegExp("(.*?)\.(jpg|png|JPG|PNG)$");
        let maxSize = 1048576; //1MB

        function fileCheck(fileName, fileSize){

            if(fileSize >= maxSize){
                alert("파일 사이즈 초과");
                return false;
            }

            if(!regex.test(fileName)){
                alert("해당 종류의 파일은 업로드할 수 없습니다.");
                return false;
            }

            return true;

        }

        /* 이미지 출력 */
        function showUploadImage(uploadResultArr){

            /* 전달받은 데이터 검증 */
            if(!uploadResultArr || uploadResultArr.length == 0){return}

            let uploadResult = $("#uploadResult");

            let obj = uploadResultArr[0];

            let str = "";
            // obj.uploadPath.replace(/\\/g, '/') +
            let fileCallPath = ("thumb_" + obj.uuid + "_" + obj.fileName);

            str += "<div id='result_card'>";
            str += "<img src='/productmanage/display_thumbnail?fileName=" + fileCallPath +"'>";
            str += "<div class='imgDeleteBtn' data-file='" + fileCallPath + "'>x</div>";
            str += "<input type='hidden' name='product_thumb_nail' value='"+ fileCallPath +"'>";

            str += "</div>";

            uploadResult.append(str);

        }

        /* 파일 삭제 메서드 */
        function deleteFile(){

            let targetFile = $(".imgDeleteBtn").data("file");

            let targetDiv = $("#result_card");

            $.ajax({
                url: '/delete_thumbnail',
                data : {fileName : targetFile},
                dataType : 'text',
                type : 'POST',
                success : function(result){
                    console.log(result);
                    targetDiv.remove();
                    $("input[type='file']").val("");
                },
                error : function(result){
                    console.log(result);
                    alert("파일을 삭제하지 못하였습니다.");
                }
            });

        }
        /* 이미지 삭제 버튼 클릭했을 때 */
        $("#uploadResult").on("click", ".imgDeleteBtn", function(e){

            deleteFile();

        });

        // 상품 등록 버튼 클릭했을 때
        $("#submit-btn").on("click", function(){
            let form = $("#register-form");
            form.attr("action", "/productmanage/register");
            form.submit();
        })

        // 상품 수정 버튼 클릭했을 때
        $("#modify-btn").on("click", function(){
            let form = $("#register-form");
            form.attr("action", "/productmanage/submitmod");
            form.submit();
        })

    </script>

</body>
</html>
