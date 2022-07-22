<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>비밀번호로 찾기</title>
    <link rel="stylesheet" href="<c:url value='/css/user/find_id_style.css'/>">
    <script src="https://kit.fontawesome.com/4c299e10dd.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        function submit(){
            var user_name = $("#user-name").val();
            var user_phone = $("#user-phone").val();
            var formData = $(".email-chk-form").serialize();
            var regPhone = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;

            if(user_name == null || user_name == ""){
                alert("이름을 입력해주세요.");
                return;
            }

            if(user_phone == null || user_phone == ""){
                alert("휴대폰 번호를 입력해주세요.");
                return;
            }

            if(!regPhone.test(user_phone)){
                alert("잘못된 휴대폰 번호 형식입니다 010-8888-8888과 같이 입력해주세요.");
                return;
            }

            $.ajax({
                type: "POST",
                url : "/register/findId/save",
                data: formData,
                success : function (data){
                    if(data=="fail"){
                        alert("존재하지 않는 회원입니다. 확인 후 다시 시도하여 주시기 바랍니다.");
                        return;
                    }else{
                        $("#result").text("회원님의 이메일은 " + data + " 입니다.");
                    }
                }

            });
        }
        $(document).ready(function (){
           $("#submit-btn").on("click",function (){
               submit();
           });

           $("#user-name,#user-phone").on("keypress",function (e){
              if(e.keyCode === 13){
                  submit();
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
                        <h2>아이디 찾기</h2>
                    </div>
                </div>
            </header>
        </div>

        <form action="#" class="email-chk-form">
            <div class="input-box-id">
                <label class="txt">회원 이름 입력</label><br>
                <input type="text" id="user-name" name="user_name" placeholder="가입 시 입력한 이름 입력">
                <label class="txt">회원 휴대폰번호 입력</label><br>
                <input type="text" id="user-phone" name="user_phone" placeholder="가입시 입력한 휴대폰 번호 입력 예) 010-8888-8888"><br>
                <div id="result"></div>
            </div>
        </form>
        <input type="button" id="submit-btn" value="아이디 찾기">
    </div>
</div>
</body>
</html>