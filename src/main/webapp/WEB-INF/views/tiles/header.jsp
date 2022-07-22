<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <div class="header-inner">
      <h1 class="site-name">
        <a href="/">HIVE</a>
      </h1>
      <form class="form-search" action="/search">
        <div>
          <input class="search-input" name="keyword" type="search" />
          <button class="search-btn" type="submit">
            <i class="fa-solid fa-magnifying-glass"></i>
          </button>
        </div>
      </form>
      <div class="nav-mine">
        <a class="btn-cart" href="#">
          <i class="fa-solid fa-cart-shopping"></i>

        </a>
        <a class="btn-mypage" href="/mypage">
          <i class="fa-regular fa-user"></i>
          <c:choose>
            <c:when test="${empty sessionScope.user_email}">
              <span class="status-badge">OFF</span>
            </c:when>
            <c:when test="${sessionScope.user_email == 'admin@hive.co.kr'}">
              <span class="status-badge">ADMIN</span>
            </c:when>
            <c:when test="${!empty sessionScope.user_email}">
              <span class="status-badge">ON</span>
            </c:when>
          </c:choose>



        </a>
      </div>
    </div>
    <nav class="nav">
      <div class="nav-inner">
        <a href="/">홈</a>
        <a href="/product/list">스토어</a>
        <a href="/event/list">이벤트</a>
        <a href="/notice/list">공지사항</a>
        <c:if test="${sessionScope.user_email == 'admin@hive.co.kr'}">
          <a href="/productmanage/register">상품등록</a>
          <a href="/event/write">이벤트등록</a>
          <a href="/productmanage">관리자</a>
        </c:if>
      </div>
    </nav>
  </body>
</html>
