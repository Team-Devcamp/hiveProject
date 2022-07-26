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
    <title>Title</title>
</head>
<body>


<script>
    if(${not empty user_email}) {

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
</script>


</body>
</html>
