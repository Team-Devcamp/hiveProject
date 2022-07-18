<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value='/css/user/profile_image_upload_style.css'/>">
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script>

        $(document).ready(function (){
            var image_path = opener.$("#user_profile").attr("src");
            if(!image_path || image_path != "/image/user/profile_unknown.png"){
                alert("이미지가 이미 등록되어 있습니다.\n변경을 원하실 경우 삭제 후 등록하여 주시기 바랍니다.");
                window.close();
                return;
            }


            var user_email = "${sessionScope.user_email}";
            $('#profile-img').change(function(){
                setImageFromFile(this, '#preview-img');
            });

            $('#submit-btn').on("click",function (){
                var formData = new FormData($(".email-chk-form")[0]);
                formData.append("file",$("#profile-img")[0].files[0]);
                let img  = $('#profile-img').val();
                if(!img){
                    alert("이미지를 첨부하고 다시 시도바랍니다.");
                }else{
                    $.ajax({
                        type: "POST",
                        url : "/mypage/image/upload",
                        data : formData,
                        contentType: false,
                        processData: false,
                        cache : false,
                        success: function(data){
                            if(data=="success"){
                                alert("이미지가 등록되었습니다.");
                                window.close();
                                opener.location.href = "/mypage";
                            }else{
                                alert("이미지 등록을 실패했습니다.");
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
                    <h2>프로필 이미지 등록</h2>
                </div>
            </header>
            <form action="<c:url value='/mypage/image/upload'/>" class="email-chk-form" method="post" enctype="multipart/form-data">
                <div class="input-box-id">
                    <label class="txt">등록할 이미지</label><br>
                    <input type="file" class="profile-img" id="profile-img" name="file">
                    <input type="hidden" readonly="readonly" value="${sessionScope.user_email}" name="user_email">
                    <div class="preview">
                        <img src="" id="preview-img" width="500px" height="300px">
                    </div>
                    <input type="button" class="submit-btn" id="submit-btn" value="등록">
                </div>
            </form>
        </div>
    </div>

</div>
</body>
</html>