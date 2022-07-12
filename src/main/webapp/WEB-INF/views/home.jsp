<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
	<title>Home</title>
</head>
<body>

<div class="banner">
	<div class="banner-wrap">
		<img src="https://image.brandi.me/home/banner/bannerImage_16_1657294537.jpg">
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
							<img src="<c:url value="/image/home/sample.jpg"/> ">
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
					<a href="#">
						<img src="https://image.brandi.me/home/banner/bannerImage_7_1657264214.jpg">
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
