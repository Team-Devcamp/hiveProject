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
      <form class="form-search" action="">
        <div>
          <input class="search-input" type="search" />
          <button class="search-btn" type="submit">
            <i class="fa-solid fa-magnifying-glass"></i>
          </button>
        </div>
      </form>
      <div class="nav-mine">
        <a class="btn-cart" href="#">
          <i class="fa-solid fa-cart-shopping"></i>
        </a>
        <a class="btn-mypage" href="#">
          <i class="fa-regular fa-user"></i>
        </a>
      </div>
    </div>
    <nav class="nav">
      <div class="nav-inner">
        <a href="/">홈</a>
        <a href="/product/list">스토어</a>
        <a href="/event/list">이벤트</a>
        <a href="#">공지사항</a>
        <a href="#">상품등록</a>
        <a href="/event/write">이벤트등록</a>
      </div>
    </nav>
  </body>
</html>
