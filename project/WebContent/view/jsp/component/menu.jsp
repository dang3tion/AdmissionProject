<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="url" scope="session" value="/view/"></c:url>

<head>
<meta charset="UTF-8">
<head>
<title>Admission</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


<link rel="stylesheet" href="${url}fonts/icomoon/style.css">

<link rel="stylesheet" href="${url}css/bootstrap.min.css">
<link rel="stylesheet" href="${url}css/magnific-popup.css">
<link rel="stylesheet" href="${url}css/jquery-ui.css">
<link rel="stylesheet" href="${url}css/owl.carousel.min.css">
<link rel="stylesheet" href="${url}css/owl.theme.default.min.css">

<link rel="stylesheet" href="${url}css/bootstrap-datepicker.css">

<link rel="stylesheet" href="${url}fonts/flaticon/font/flaticon.css">

<link rel="stylesheet" href="${url}css/aos.css">
<link rel="stylesheet" href="${url}css/rangeslider.css">

<link rel="stylesheet" href="${url}css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
</head>
<body>
	<div class="site-mobile-menu">
		<div class="site-mobile-menu-header">
			<div class="site-mobile-menu-close mt-3">
				<span class="icon-close2 js-menu-toggle"></span>
			</div>
		</div>
		<div class="site-mobile-menu-body"></div>
	</div>

	<header class="site-navbar container py-0 " role="banner">

		<div class="row align-items-center">
			<div class="col-6 col-xl-2">
				<h1 class="mb-0 site-logo">
					<a class="" href="${pageContext.request.contextPath}/" class="text-white mb-0"> IFly College </a>
				</h1>
			</div>
			<div class="col-12 col-md-10 d-none d-xl-block">
				<nav class="site-navigation position-relative text-right"
					role="navigation">
					<ul class="site-menu js-clone-nav mr-auto d-none d-lg-block">
						<li class="active hover-menu"><a href="${pageContext.request.contextPath}/"> Trang chủ
						</a></li>
						<li class="active hover-menu"><a
							href="filterpage">
								Trang lọc </a></li>

						<li class="active hover-menu"><a href="#"> Tư vấn chọn
								ngành </a></li>
						<li class="active hover-menu"><a href="#"> Chúng tôi </a></li>
						<li class="active hover-menu"><a href="#"> Liên hệ </a></li>

						<c:choose>
							<c:when test="${ not empty token }">
								<li class="ml-xl-3 login hover-menu"><a
									href="${pageContext.request.contextPath}/admin/additional">
										<span class="border-left pl-xl-4">Thêm thông tin</span>
								</a></li>
								<li class="hover-regis"><a class="" href="${pageContext.request.contextPath}/admin" class="cta">
										<span class="bg-primary text-white rounded p-2"> Đăng
											xuất </span>
								</a></li>
							</c:when>
							<c:otherwise>
								<li class="ml-xl-3 login hover-menu"><a
									href="${pageContext.request.contextPath}/admin"> <span
										class="border-left pl-xl-4">Đăng nhập</span>
								</a></li>
								<li class="hover-regis"><a class="" href="#" class="cta">
										<span class="bg-primary text-white rounded p-2"> Đăng
											ký </span>
								</a></li>
							</c:otherwise>

						</c:choose>



					</ul>
				</nav>
			</div>
			<div class="d-inline-block d-xl-none ml-auto py-3 col-6 text-right"
				style="position: relative; top: 3px">
				<a href="#" class="site-menu-toggle js-menu-toggle text-white">
					<span class="icon-menu h3"></span>
				</a>
			</div>
		</div>
	</header>
</body>
