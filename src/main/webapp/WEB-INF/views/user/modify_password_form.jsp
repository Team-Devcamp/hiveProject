<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>비밀번호 변경</title>
    <link rel="stylesheet" href="<c:url value='/css/user/modify_password_style.css'/>">
    <script src="https://kit.fontawesome.com/4c299e10dd.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        $(document).ready(function (){

           $("#submit-btn").on("click",function (){
               var present_pwd = $("#present-pwd").val();
               var modify_pwd = $("#modify-pwd").val();
               var modify_pwd_chk = $("#modify-pwd-check").val();
               var formData = $(".pwd-modify-form").serialize();
               var regexPwd = /^(?=.*[a-zA-Z])(?=.*[!@#$%^~*+=-])(?=.*[0-9]).{8,16}$/;;

               if(present_pwd == null || present_pwd == ""){
                   alert("현재 비밀번호를 입력해주세요.");
                   return;
               }

               if(modify_pwd == null || modify_pwd == ""){
                   alert("변경할 비밀번호를 입력해주세요.");
                   return;
               }

               if(modify_pwd_chk == null || modify_pwd_chk == ""){
                   alert("변경할 비밀번호 확인을 입력해주세요.");
                   return;
               }

               if(modify_pwd != modify_pwd_chk){
                   alert("변경할 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
                   return;
               }

               if(!regexPwd.test(modify_pwd)){
                   alert("비밀번호는 8-16자리의 문자,숫자,특수문자를 모두 포함해서 입력해주시기 바랍니다.");
                   return;
               }

               $.ajax({
                  type: "POST",
                   url : "/mypage/modify/password/save",
                  data: formData,
                   success : function (data){
                      if(data=="success"){
                          alert("비밀번호가 변경되었습니다.");
                          return;
                      }else{
                          alert("비밀번호 변경에 실패하였습니다. 비밀번호가 틀렸거나, \n기존 비밀번호와 변경하려는 비밀번호가 같은지 확인 후 다시 시도 바랍니다.");
                          return;
                      }
                   }

               });
           });

           $("#present-pwd,#modify-pwd,#modify-pwd-check").on("keypress",function (e){
               if(e.keyCode === 13){
                   var present_pwd = $("#present-pwd").val();
                   var modify_pwd = $("#modify-pwd").val();
                   var modify_pwd_chk = $("#modify-pwd-check").val();
                   var formData = $(".pwd-modify-form").serialize();
                   var regexPwd = /^(?=.*[a-zA-Z])(?=.*[!@#$%^~*+=-])(?=.*[0-9]).{8,16}$/;;

                   if(present_pwd == null || present_pwd == ""){
                       alert("현재 비밀번호를 입력해주세요.");
                       return;
                   }

                   if(modify_pwd == null || modify_pwd == ""){
                       alert("변경할 비밀번호를 입력해주세요.");
                       return;
                   }

                   if(modify_pwd_chk == null || modify_pwd_chk == ""){
                       alert("변경할 비밀번호 확인을 입력해주세요.");
                       return;
                   }

                   if(modify_pwd != modify_pwd_chk){
                       alert("변경할 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
                       return;
                   }

                   if(!regexPwd.test(modify_pwd)){
                       alert("비밀번호는 8-16자리의 문자,숫자,특수문자를 모두 포함해서 입력해주시기 바랍니다.");
                       return;
                   }

                   $.ajax({
                       type: "POST",
                       url : "/mypage/modify/password/save",
                       data: formData,
                       success : function (data){
                           if(data=="success"){
                               alert("비밀번호가 변경되었습니다. 새로운 비밀번호로 로그인 해 주시기 바랍니다.");
                               window.opener.location.href = "/";
                               window.close();
                               return;
                           }else{
                               alert("비밀번호 변경에 실패하였습니다. 비밀번호가 틀렸거나, \n기존 비밀번호와 변경하려는 비밀번호가 같은지 확인 후 다시 시도 바랍니다.");
                               return;
                           }
                       }

                   });
               }
           })
        });
    </script>
</head>
<div class="wrap">
    <div class="content">
        <div class="navigator">
            <header class="nav">
                    <div class="tit">
                        <h2>비밀번호 변경</h2>
                </div>
            </header>
        </div>

        <form action="#" class="pwd-modify-form">
            <div class="input-box-id">
                <label class="txt">현재 비밀번호 입력</label><br>
                <input type="password" id="present-pwd" name="present_pwd" placeholder="현재 비밀번호를 입력하세요">
                <label class="txt">변경할 비밀번호 입력</label><br>
                <input type="password" id="modify-pwd" name="modify_pwd" placeholder="변경할 비밀번호를 입력해주세요"><br>
                <label class="txt">변경할 비밀번호 확인</label><br>
                <input type="password" id="modify-pwd-check" placeholder="변경할 비밀번호를 한번 더 입력해주세요"><br>
            </div>
        </form>
        <input type="button" id="submit-btn" value="비밀번호 변경">
    </div>
</div>
</body>
</html>