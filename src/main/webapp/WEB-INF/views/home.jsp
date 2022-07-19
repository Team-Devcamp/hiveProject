<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
	<link rel="stylesheet" href="/css/home/home.css" />
	<title>Home</title>
</head>
<body>

<div class="banner">
	<div class="banner-wrap">
		<div id="carouselExampleIndicators" class="carousel carousel-dark slide" data-bs-ride="carousel">
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
				<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
				<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
			</div>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="<c:url value='/image/home/banner1.jpg'/>" class="d-block w-100" >
				</div>
				<div class="carousel-item">
					<img src="<c:url value='/image/home/banner2.jpg'/>" class="d-block w-100" >
				</div>
				<div class="carousel-item">
					<img src="<c:url value='/image/home/banner3.jpg'/>" class="d-block w-100" >
				</div>
			</div>
			<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
	</div>
</div>





<main class="main">
	<div class="main-wrap">
		<div class="todaylank">
			<div class="title-wrap">
				<h2>TODAY 랭킹</h2>
				<div class="tab-container">
					<ul>
						<li><a href="#">낮은가격순</a></li>
						<li><a href="#">높은가격순</a></li>
						<li><a href="#">할인률순</a></li>
					</ul>
				</div>
			</div>
			<div class="todaylank-items-wrap">
				<c:forEach begin="0" end="7">
				<div class="item">
					<a href="#">
						<img src="<c:url value="/image/home/sample.jpg"/> ">
					</a>
				</div>
				</c:forEach>

			</div>
			<div class="btn-lank">
				<a href="">랭킹 더보기</a>
			</div>
		</div>

		<div class="todaylank">
			<div class="title-wrap">
				<h2>신상 모아보기</h2>
				<div class="tab-container">
					<ul>
						<li><a href="#">낮은가격순</a></li>
						<li><a href="#">높은가격순</a></li>
						<li><a href="#">할인률순</a></li>
					</ul>
				</div>
			</div>
			<div class="todaylank-items-wrap">
				<c:forEach begin="0" end="7">
					<div class="item">
						<a href="#">
							<img src="<c:url value='/image/home/sample.jpg'/> ">
						</a>
					</div>
				</c:forEach>
			</div>

			<div class="btn-lank">
				<a href="">신상 더보기</a>
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
					<a href="#">
						<img src="https://image.brandi.me/home/banner/bannerImage_8_1657264214.jpg">
						<div>
							<h3>공지사항 바로가기</h3>
						</div>
					</a>
				</div>

			</div>

		</div>
</main>

</body>
</html>
