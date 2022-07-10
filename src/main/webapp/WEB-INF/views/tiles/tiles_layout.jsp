<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>miniproject</title>
    <link rel="stylesheet" href="css/common/tiles_layout.css" />
</head>
<body>

	<div class="wrap">

		<div class="header-wrap">
			<div class="header">
				<tiles:insertAttribute name="header"/>
			</div>
		</div>

		<div class="content-wrap">
			<div class="content">
				<tiles:insertAttribute name="content"/>
			</div>
	 	</div>
	 
	 	<div class="footer-warp">
			<div class="footer">
				<tiles:insertAttribute name="footer"/>
			</div>
		</div>
	
	</div>
	
</body>
</html>