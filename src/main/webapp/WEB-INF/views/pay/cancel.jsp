<%--
  Created by IntelliJ IDEA.
  User: Renee
  Date: 2022-07-22
  Time: 오전 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>CANCEL</h2><br>
<h3>결제가 취소되었습니다.</h3><br>
<button type="button" id="cancelBtn">창 닫기</button>


<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
    $('#cancelBtn').on('click',function(){
        window.close();
    });
</script>
</body>
</html>
