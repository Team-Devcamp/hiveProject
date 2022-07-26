<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
	<link rel="stylesheet" href="/css/home/home.css" />
	<title>Home</title>
</head>
<body>

<div id="slider">
	<img class="slider__item" src="<c:url value='/image/home/banner2.jpg'/>">
	<img class="slider__item" src="<c:url value='/image/home/banner3.jpg'/>">
	<img class="slider__item" src="<c:url value='/image/home/banner4.jpg'/>">
	<img class="slider__item" src="<c:url value='/image/home/banner5.jpg'/>">
	<img class="slider__item" src="<c:url value='/image/home/banner1.jpg'/>">
</div>


<main class="main-home">
	<div class="main-wrap">
		<div class="todaylank">
			<div class="title-wrap">
				<h2>인기 상품</h2>
				<div class="tab-container">
				</div>
			</div>
			<div class="todaylank-items-wrap">
				<c:forEach begin="0" end="7" var="productDto" items="${popularlist}">
					<div class="item">
						<a href="/product/detail?product_id=${productDto.product_id}">
							<div class="thumb-nail">
								<img src="/image/product/thumbnail/${productDto.product_thumb_nail}"/>
							</div>
							<div class="item-info">
								<span>${productDto.product_title}</span>
								<span>${productDto.product_price}</span>
							</div>
						</a>
					</div>
				</c:forEach>

			</div>
			<div class="btn-lank">
				<a href=""><span>인기상품 더보기</span><i class="fa-solid fa-chevron-right"></i></a>
			</div>
		</div>

		<div class="todaylank">
			<div class="title-wrap">
				<h2>신상 모아보기</h2>
				<div class="tab-container">
				</div>
			</div>
			<div class="todaylank-items-wrap">
				<c:forEach begin="0" end="7" var="productDto" items="${latestlist}">
					<div class="item">
						<a href="/product/detail?product_id=${productDto.product_id}">
							<div class="thumb-nail">
								<img src="/image/product/thumbnail/${productDto.product_thumb_nail}"/>
							</div>
							<div class="item-info">
								<span>${productDto.product_title}</span>
								<span>${productDto.product_price}</span>
							</div>
						</a>
					</div>
				</c:forEach>
			</div>

			<div class="btn-lank">
				<a href=""><span>신상 더보기</span><i class="fa-solid fa-chevron-right"></i></a>
			</div>
		</div>

		<div class="event">
			<div class="event-wrap">
				<div class="event-link">
					<a href="/event/list">
						<img src="<c:url value='/image/home/event_link.gif'/> ">
						<div>
							<h3>이벤트 바로가기</h3>
						</div>
					</a>
				</div>
				<div class="event-link">
					<div class="info-nav">
						<a href="#"><i class="fa-solid fa-cart-shopping"></i><span>장바구니 바로가기</span></a>
						<a href="/notice/list"><i class="fa-solid fa-circle-exclamation"></i><span>공지사항 바로가기</span></a>
						<a href="/faq"><i class="fa-solid fa-circle-info"></i><span>자주묻는 질문</span></a>
						<a href="/product/list"><i class="fa-solid fa-store"></i><span>스토어 바로가기</span></a>
					</div>
				</div>

			</div>

		</div>
		<script	type="text/javascript" src="/script/home/carousel.js"></script>
</main>

</body>
</html>
