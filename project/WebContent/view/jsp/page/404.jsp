<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:url var="url" scope="session" value="/view"></c:url>
<html>
<jsp:include page="../component/menu.jsp"></jsp:include>


<body>

	<div class="site-blocks-cover2 overlay "
		style="background-image: url('${url}/images/hero_2.jpg')"
		data-aos="fade" data-stellar-background-ratio="1"></div>

	<div class="site-section bg-light">
		<div class="container">
			<h3 style="margin-bottom: 300px">Trang không tìm thấy 404 error</h3>
		</div>
	</div>
	<jsp:include page="../component/footer.jsp"></jsp:include>
</body>
</html>