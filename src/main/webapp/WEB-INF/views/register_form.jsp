<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.net.URLDecoder"%>
<html>
<head>
    <meta charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="stylesheet" href="<c:url value='/css/user/register_form_style.css'/>">
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        $(document).ready(function(){
            var auth_check = "${param.email_check}".trim();
            var email_check = "${email_check}".trim();
            if(auth_check=="true"){
                $("#check_email").val("true");
            }
            if(email_check=="true"){
                $("#check_email").val("true");
            }
            $("#register-btn-join").on("click",function (){
                let register_form = $("#register-form").val();
                let user_email = $("input[name=user_email]").val();
                let user_pwd = $("input[name=user_password]").val();
                let user_pwd_chk = $("input[name=user_pwd_check]").val();
                let user_name = $("input[name=user_name]").val();
                let user_birth = $("input[name=user_birth]").val();
                let user_phone = $("input[name=user_phone]").val();
                let check_email = $("input[name=check_email]").val();

                if(user_email=="" || user_email == null){
                    alert("이메일을 입력해주세요");
                    return;
                }

                if(user_pwd=="" || user_pwd == null){
                    alert("비밀번호를 입력해주세요");
                    return;
                }

                if(user_pwd_chk=="" || user_pwd_chk == null){
                    alert("비밀번호 확인을 입력해주세요");
                    return;
                }

                if(user_name=="" || user_name == null){
                    alert("이름을 입력해주세요");
                    return;
                }

                if(user_birth =="" || user_birth == null){
                    alert("생일을 입력해주세요");
                    return;
                }

                if(user_phone =="" || user_phone == null){
                    alert("휴대폰번호를 입력해주세요");
                    return;
                }

                if(user_pwd != user_pwd_chk){
                    alert("비밀번호와 비밀번호확인이 다릅니다.");
                    return;
                }

                if(check_email=="false"){
                    alert("이메일 인증을 진행해주세요!");
                    return;
                }

                $("form").submit();
            });

            $(".email-check-btn").on("click", function (){
                let user_email = $("input[name=user_email]").val();
                if(user_email=="" || user_email==null) {
                    alert("이메일을 입력 후 인증을 진행해 주시기 바랍니다.");
                    return;
                }
                var popup = window.open('/register/mailCheckPop', '이메일 인증', 'width=700px,height=800px,scrollbars=yes');
            });

        });
    </script>
</head>
<body>
<div class="wrap">
    <div class="content">
        <div class="main-tit">
            <p>회원가입</p>
        </div>
        <div class="register-form">
            <form:form action="/register" class="register-input" id="register-form" method="post" modelAttribute="userDto">
                <div class="register-email">
                    <form:label path="user_email" cssClass="input-register">이메일 주소</form:label>
                    <form:input path="user_email" cssClass="register-input-form" id="user_email" placeholder=" 예) hive@hive.com" value="${param.user_email}" readonly="${param.user_email == null ? false : true}"/><br>
                    <form:errors path="user_email" cssClass="error-msg"></form:errors>
                    <input type="button" class="email-check-btn" value="이메일 인증"><br>
                    <input type="hidden" id="check_email" name="check_email" value="false" readonly="readonly">
                    <form:label path="user_password" class="input-register">비밀번호</form:label>
                    <form:password path="user_password"  cssClass= "register-input-form"  id="user_password" placeholder="영문,숫자,특수문자 혼합 8-16자"/><br>
                    <form:errors path="user_password" cssClass="error-msg"></form:errors>
                    <label class="input-register">비밀번호 확인</label>
                    <input type="password" class= "register-input-form"  name="user_pwd_check"/><br>
                    <form:label path="user_name" cssClass="input-register">이름</form:label>
                    <form:input path="user_name"  cssClass= "register-input-form" id="user_name"/><br>
                    <form:errors path="user_name" cssClass="error-msg"></form:errors>
                    <form:label path="user_birth" cssClass="input-register">생일</form:label>
                    <form:input path="user_birth" cssClass= "register-input-form" id="user_birth" placeholder="1994-02-22 와 같은 형식으로 입력해주세요"/><br>
                    <form:errors path="user_birth" cssClass="error-msg"></form:errors>
                    <form:label path="user_phone" cssClass="input-register">휴대폰 번호</form:label>
                    <form:input path="user_phone" cssClass= "register-input-form" id="user_phone" placeholder="010-3444-2343 와 같은 형식으로 입력해주세요"/><br>
                    <form:errors path="user_phone" cssClass="error-msg"></form:errors>
                    <input type="button" class="register-btn" id="register-btn-join" value="가입하기">
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
