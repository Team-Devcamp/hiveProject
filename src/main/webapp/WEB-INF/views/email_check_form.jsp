<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>이메일 인증</title>
    <link rel="stylesheet" href="<c:url value='/css/user/email_check_form_style.css'/>">
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        $(document).ready(function (){
            var code = "";
            var user_email = opener.$("#user_email").val();
            $("#user-email").val(user_email);

            $("#user-email").on("propertychange change keyup paste input",function (){
                user_email = $(this).val();
            });

            $("#email-chk-btn").on("click",function(){
                    $.ajax({
                        type:"GET",
                        url:"/register/emailCheck",
                        data: {user_email:user_email},
                        cache : false,
                        success:function(data){
                            if(data == "error"){
                                alert("이메일 주소가 올바르지 않습니다. 유효한 이메일 주소를 입력해주세요.");
                                $("#user-email").attr("autofocus",true);
                                return;
                            }else if(data=="overlap"){
                                alert("이미 가입된 이메일 입니다. 로그인 해주세요.");
                                return;
                            } else{
                                alert("인증번호 발송이 완료되었습니다.");
                                code = data;
                            }
                        }
                });
            });

            $(".submit-btn").on("click",function (){
                var resultCode = $(".mail-id").val();
                if(code!=resultCode){
                    alert("인증번호가 다릅니다.");
                    return;
                }else{
                    alert("정상적으로 인증되었습니다!");
                    $(opener.document).find("#check-email").val("true");
                    $(opener.document).find("#user_email").val(user_email);
                    $(opener.document).find("#user_email").attr("readonly",true);
                    window.close();
                }
            });
        });
    </script>
</head>
<body>
<div class="wrap">
    <div class="content">
        <div class="navigator">
            <header class="nav">
                <div class="tit">
                    <h2>이메일 인증</h2>
                </div>
            </header>
        </div>
        <form action="#" class="email-chk-form">
            <div class="input-box-id">
                <label class="txt">가입 시 입력한 이메일 주소</label><br>
                <input type="text" id="user-email" class="user-email" placeholder="예) hive@hive.com">
                <input type="hidden" id="user-email-check" value="false">
                <input type="button" class="email-chk-btn" id="email-chk-btn" value="인증 요청">
                <input type="text" class="mail-id" placeholder="인증번호 입력"><br>
            </div>
        </form>
        <input type="button" class="submit-btn" id="submit-btn" value="이메일 인증확인">
    </div>
</div>
</div>
</body>
</html>