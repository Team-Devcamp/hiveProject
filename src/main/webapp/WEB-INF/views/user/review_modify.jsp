<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value='/css/user/review_modify_style.css'/>">
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script>

        $(document).ready(function (){

            var user_email = "${sessionScope.user_email}";
            $('#profile-img').change(function(){
                setImageFromFile(this, '#preview-img');
            });

            $('#submit-btn').on("click",function (){
                var formData = new FormData($(".review-modify-form")[0]);
                formData.append("file",$("#profile-img")[0].files[0]);
                let img  = $('#profile-img').val();
                let content = $('#review-content').val();
                if(content== null || content == ''){
                    alert("리뷰 내용이 비어있습니다.");
                    return;
                }
                if(!img){
                    alert("이미지를 첨부하고 다시 시도바랍니다.");
                    return;
                }else{
                    $.ajax({
                        type: "POST",
                        url : "/mypage/purchase/review/modify",
                        data : formData,
                        contentType: false,
                        processData: false,
                        cache : false,
                        success: function(data){
                            if(data=="success"){
                                alert("리뷰가 수정되었습니다.");
                                window.close();
                                opener.location.href = "/mypage/purchase";
                            }else{
                                alert("리뷰 수정에 실패했습니다.");
                            }
                        }
                    });
                }

            });



        });

        function setImageFromFile(input, expression) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();
                reader.onload = function (e) {
                    $(expression).attr('src', e.target.result);
                }
                reader.readAsDataURL(input.files[0]);
            }
        }
    </script>
</head>
<body>
<div class="wrap">
    <div class="content">
        <div class="navigator">
            <header class="nav">
                <div class="tit">
                    <h2>리뷰 수정</h2>
                </div>
            </header>
            <form action="#" class="review-modify-form" method="post" enctype="multipart/form-data">
                <div class="input-box-id">
                    <label class="txt">상품 이름</label><br>
                    <label class="txt">리뷰 내용</label><br>
                    <input type="text" name="review_content" id="review-content">
                    <label class="txt">등록할 이미지</label><br>
                    <input type="file" class="profile-img" id="profile-img" name="file">
                    <input type="hidden" readonly="readonly" value="${param.user_id}" name="user_id">
                    <input type="hidden" readonly="readonly" value="${param.product_id}" name="product_id">
                    <input type="hidden" readonly="readonly" value="${param.purchase_id}" name="purchase_id">
                    <input type="hidden" readonly="readonly" value="${sessionScope.user_email}" name="user_email">
                    <div class="preview">
                        <img src="" id="preview-img" width="500px" height="400px">
                    </div>
                    <input type="button" class="submit-btn" id="submit-btn" value="등록">
                </div>
            </form>
        </div>
    </div>

</div>
</body>
</html>