<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>비밀번호로 찾기</title>
    <link rel="stylesheet" href="<c:url value='/css/user/find_pwd_style.css'/>">
    <script src="https://kit.fontawesome.com/4c299e10dd.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        $(document).ready(function (){
            var code = "";
            var user_email = "";
           $("#pwd-chk-btn").on("click",function (){
               user_email = $("#user-email").val();
             if(user_email == null || user_email == ""){
                 alert("이메일을 입력해 주세요!");
             }else{

                     $.ajax({
                         type:"GET",
                         url:"/register/findPassword/check",
                         data: {user_email:user_email},
                         cache : false,
                         success:function(data) {
                             if (data == "error") {
                                 alert("유효하지 않은 이메일 입니다.");
                                 return;
                             }else if(data=="fail"){
                                 alert("존재하지 않는 이메일 입니다.");
                                 return;
                             }else{
                                 alert("인증번호 발송이 완료되었습니다.");
                                 code = data;
                             }
                         }
                     });

             }
           });

           $(".submit-btn").on("click",function (){
               var auth_code = $(".pwd-auth").val();
               if(code!=auth_code){
                   alert("인증번호가 일치하지 않습니다.");
               }else{
                   $.ajax({
                       type:"GET",
                       url:"/register/findPassword/save",
                       data: {user_email:user_email},
                       cache : false,
                       success:function(data) {
                           if (data == "error") {
                               alert("오류가 발생하였습니다.");
                               return;
                           }else{
                               alert("새로운 비밀번호를 메일로 발송하였습니다. 메일을 확인 후 다시 로그인해주시기 바랍니다.");
                           }
                       }
                   });
               }
           });

        });
    </script>
</head>
<div class="wrap">
    <div class="content">
        <div class="navigator">
            <header class="nav">
                <div class="arrow">
                    <a href="<c:url value='/login'/>">
                        <i class="fa-solid fa-chevron-left"></i>
                    </a>
                    <div class="tit">
                        <h2>비밀번호 찾기</h2>
                    </div>
            </header>
        </div>

        <form action="#" class="email-chk-form">
            <div class="input-box-id">
                <label class="txt">가입 시 입력한 이메일 주소</label><br>
                <input type="text" class="user-email" id="user-email" placeholder="가입 시 입력한 이메일 주소">
                <input type="button" class="pwd-chk-btn" id="pwd-chk-btn" value="인증 요청">
                <input type="text" class="pwd-auth" placeholder="인증번호 입력"><br>

            </div>
        </form>
        <input type="button" class="submit-btn" id="submit-btn" value="이메일 인증확인">
    </div>
</div>
</body>
</html>