<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Renee
  Date: 2022-07-22
  Time: 오전 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MINI HIVE 결제 성공</title>
    <link rel="stylesheet" href="/css/common/reset.css">
    <style>
        kakao-pay-success-wrap{
            font-family: "Helvetica Neue", "Noto Sans KR", sans-serif;
            font-weight: 400;
            background: #d7d4f0;
        }
        .paySuccessInfo{
            margin:100px;
            font-size: 16px;
        }
        .paySuccessInfo .tit{
            border-left: 2px solid black;
        }
        .paySuccessInfo h2{
            font-size: 1.2em;
            font-weight: 500;
            margin-left:20px;
            margin-bottom: 50px;
        }
        .table-paySuccessInfo td{ border-bottom: 1px solid #cfd1cf;
            padding: 15px 10px;
            width: 150px;
        }
        .table-paySuccessInfo .btn{
            text-align: center;
            border-bottom: none;
        }
        #paySuccessBtn{
            background: #1c1c1c;
            color : white;
            padding: 5px 15px;
            margin-top: 20px;
        }
    </style>
</head>
<body>

<div class="kakao-pay-success-wrap">
    <div class="paySuccessInfo">
        <div class="tit"><h2>카카오페이 결제가 </br> 정상적으로 완료되었습니다.</h2></div>

        <table class="table-paySuccessInfo">
            <tr>
                <td colspan="2">MINI HIVE 결제정보</td>
            </tr>
            <tr>
                <td>결제일자</td>
                <td>${info.approved_at}</td>
            </tr>
            <tr>
                <td>주문번호</td>
                <td>${info.partner_order_id}</td>
            </tr>
            <tr>
                <td>결제번호</td>
                <td>${payInfo.tid}</td>
            </tr>
            <tr>
                <td>상품명</td>
                <td>${info.item_name}</td>
            </tr>
            <tr>
                <td>결제금액</td>
                <td>${info.amount.total}</td>
            </tr>
            <tr>
                <td class="btn" colspan="2">
                    <button type="button" id="paySuccessBtn">확인</button>
                </td>
            </tr>
        </table>
    </div>
</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

    $('#paySuccessBtn').on('click',function(){

        if(${not empty sessionScope.user_email}) {

            if (confirm("상품이 정상적으로 주문되었습니다.\n주문 내역으로 이동하시겠습니까?")) {
                window.close();
                opener.window.location.href = "/mypage/purchase";
            } else {
                alert("구매해주셔서 감사합니다.");
                window.close();
            }
        }
        else{
            alert("구매해주셔서 감사합니다.");
            window.close();
        }
    });

</script>

</body>
</html>
