<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>주소 찾기</title>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <link rel="stylesheet" href="<c:url value='/css/user/insert_address_style.css'/>">
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        function submit(){
            var user_phone = $("#user-phone").val();
            var user_name = $("#user-name").val();
            var address = $("#address").val();
            var address_detail = $("#detail-address").val();
            var post_number = $("#post-number").val();
            var phone_pattern = /01[016789]-[^0][0-9]{2,3}-[0-9]{3,4}/;
            var formValues = $("form[name=user-address-form]").serialize();

            if(user_name == null || user_name == ""){
                alert("이름을 입력해주시기 바랍니다.");
                return;
            }

            if(user_phone == null || user_phone == ""){
                alert("휴대폰 번호를 입력해 주시기 바랍니다.");
                return;
            }

            if(!phone_pattern.test(user_phone)){
                alert("올바른 휴대폰 번호 형식이 아닙니다.");
                return;
            }

            if(post_number == null || post_number == ""){
                alert("우편번호를 입력해주시기 바랍니다.");
                return;
            }

            if(address == null || address == ""){
                alert("주소를 입력해주시기 바랍니다.");
                return;
            }

            if(address_detail == null || address_detail == ""){
                alert("상세주소를 입력해주시기 바랍니다.");
                return;
            }

            $.ajax({
                url : '/mypage/address/save',
                type : 'POST',
                data : formValues,
                datatype : 'json',
                success: function (data){
                    if(data=='success'){
                        alert('등록에 성공했습니다.');
                        window.close();
                        opener.location.href = '/mypage/address/list';
                    }else{
                        alert('등록에 실패했습니다.');
                    }
                }
            });
        }
        $(document).ready(function (){
            $("#submit-btn").click(function (){
                submit();
            });
            $("#user-name,#user-phone,#post-number,#address,#detail-address").on("keypress",function (e){
               if(e.keyCode === 13){
                   submit();
               }
            });
        });

        function findAddress(){
            new daum.Postcode({
                oncomplete: function (data) {
                    var post_number = data.zonecode;
                    var address = "";
                    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                        address = data.roadAddress;
                    } else { // 사용자가 지번 주소를 선택했을 경우(J)
                        address = data.jibunAddress;
                    }

                    document.getElementById("post-number").value = post_number;
                    document.getElementById("address").value = address;
                }
            }).open();
        }
    </script>
<</head>
<body>
<div class="wrap">
    <div class="content">
        <div class="navigator">
            <header class="nav">
                <div class="arrow">
                    <div class="tit">
                        <h2>배송지 등록</h2>
                    </div>
                </div>
            </header>
        </div>
        <div class="input-box">
            <form name="user-address-form" action="#" method="post">
            <input tyte="text" placeholder="이름" id="user-name" name="user_name">
            <input type="text" placeholder="010-0000-0000 형식으로 입력해주세요" id="user-phone" name="user_phone">
            <input type="text" placeholder="우편번호" id="post-number" name="post_number" readonly="readonly">
            <input type="text" placeholder="주소" id="address" name="address" readonly="readonly">
            <input type="text" placeholder="상세 주소" id="detail-address" name="detail_address">
            <input type="button" class="find-post" id="find-post" value="우편번호 찾기" onclick="findAddress()">
            </form>
        </div>
        <input type="button" class="submit-btn" id="submit-btn" value="배송지 등록">
    </div>
</div>
</body>
</html>
