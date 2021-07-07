<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<c:url var="url" scope="session" value="/view"></c:url>
<html>
<jsp:include page="../component/menu.jsp"></jsp:include>

<style type="text/css">
	.search-text{
		position: relative;
	}
	.search-input{
		z-index: 2;
	}
	.search-hint{
		display: none;
		margin-top:1px;
		width: 92%;
		position: absolute;
		z-index: 3;
	}

</style>


<body>

	<div class="site-blocks-cover overlay"
		style=" background-image:url('${url}/images/hero_2.jpg')"
		data-aos="fade" data-stellar-background-ratio="0.5">
		<div class="container">
			<div
				class="row align-items-center justify-content-center text-center">
				<div class="col-md-12">
					<div class="row justify-content-center mb-4">
						<div class="col-md-8 text-center">
							<h1  data-aos="fade-up">Chào mừng đến với IFLY College</h1>
							<p data-aos="fade-up" data-aos-delay={100}>Tìm kiếm ngôi trường thích hợp nhất</p>
						</div>
					</div>
					<div class="form-search-wrap mb-3" data-aos="fade-up"
						data-aos-delay={200}>
						<form method="post">
							<div class="row align-items-center">
								<div class="col-lg-12 mb-4 mb-xl-0 col-xl-4 search-text">
									<input type="text" class="form-control rounded search-input" id="search-input" oninput="searchHint()"
										   placeholder="Enter college name " autoFocus />
									<div class="search-hint col-md-13" id="search-hint">
										<div class="list-group" id="list-group">
<%--&lt;%&ndash;											&lt;%&ndash;%>--%>
<%--&lt;%&ndash;												ArrayList<String> hints = (ArrayList<String>) request.getAttribute("hints");&ndash;%&gt;--%>
<%--&lt;%&ndash;												if(hints != null){&ndash;%&gt;--%>
<%--&lt;%&ndash;													System.out.println("hints= "+hints.toString());&ndash;%&gt;--%>
<%--&lt;%&ndash;												for (String s : hints){&ndash;%&gt;--%>
<%--&lt;%&ndash;											%>&ndash;%&gt;--%>
<%--											<a href="#" class="list-group-item">i</a>--%>
<%--&lt;%&ndash;											<%}}%>&ndash;%&gt;--%>
										</div>
									</div>
								</div>
								<div class="col-lg-12 mb-4 mb-xl-0 col-xl-3">
									<div class="wrap-icon">
										<span class="icon icon-room"></span> <select
											class="form-control rounded" name id>
										<option value>All area</option>
										<option value>Asia</option>
										<option value>Europe</option>
										<option value>Africa</option>
										<option value>Americas</option>
										<option value>Oceania</option>
									</select>
									</div>
								</div>
								<div class="col-lg-12 mb-4 mb-xl-0 col-xl-3">
									<div class="select-wrap">
				<span class="icon"> <span
						class="icon-keyboard_arrow_down"></span>
				</span> <select class="form-control rounded" name id>
										<option value>All major</option>
										<option value>Information Technology</option>
										<option value>Economics</option>
										<option value>Mechanics</option>
										<option value>Business English</option>
										<option value>Finance and Banking</option>
										<option value>Business Administration</option>
										<option value>Chemical Engineering</option>
										<option value>Trade Marketing</option>
										<option value>Nuclear Engineering</option>
										<option value>International Trade</option>
										<option value>Others</option>
									</select>
									</div>
								</div>

								<div class="col-lg-12 col-xl-2 ml-auto text-right">
									<NavLink to="/searching"
											 class="cta btn btn-primary btn-block rounded"> <span
											class=" text-white rounded"> Tìm kiếm </span> </NavLink>
								</div>
							</div>
						</form>
					</div>
					<div class="row text-left trending-search" data-aos="fade-up"
						data-aos-delay={300}>
						<div class="col-12">
							<h2 class="d-inline-block">Bạn muốn tìm:</h2>
							<a href="${pageContext.request.contextPath}/view/jsp/page/DetailInforUI.jsp">University of Cambridge</a> <a
								href="${pageContext.request.contextPath}/view/jsp/page/DetailInforUI.jsp">Nong Lam University</a> <a
								href="${pageContext.request.contextPath}/view/jsp/page/DetailInforUI.jsp">Harvard University</a> <a
								href="${pageContext.request.contextPath}/view/jsp/page/DetailInforUI.jsp">University of Oxford</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="site-section bg-light">
		<div class="container">
			<div class="row mb-5">
				<div class="col-md-7 text-left border-primary">
					<h2 class="font-weight-light text-primary">Các trường nổi bật</h2>
				</div>
			</div>
			<div class="row mt-5">
				<div class="col-lg-6">
					<div class="d-block d-md-flex listing hoverd">
						<a href="${pageContext.request.contextPath}/view/jsp/page/DetailInforUI.jsp" class="img d-block"
							style="background-image: url( '${url}/images/college/cb2.jpg')"></a>
						<div class="lh-content">
							<span class="category">Public University</span> <a href="#"
								class="bookmark"> <span class="icon-heart"></span>
							</a>
							<h3>
								<a class="hovera" href="${pageContext.request.contextPath}/view/jsp/page/DetailInforUI.jsp"> University of
									Cambridge </a>
							</h3>
							<address>Cambridge CB2 1TN, United Kingdom <br/>(Europe)</address>
							<p class="mb-0">
								<span class="icon-star text-warning"></span> <span
									class="icon-star text-warning"></span> <span
									class="icon-star text-warning"></span> <span
									class="icon-star text-warning"></span> <span
									class="icon-star-half-full text-warning"></span> <span
									class="review">(1203 Reviews)</span>
							</p>
						</div>
					</div>
					<div class="d-block d-md-flex listing hoverd">
						<a href="${pageContext.request.contextPath}/view/jsp/page/DetailInforUI.jsp" class="img d-block"
							style="background-image: url(  '${url}/images/college/hv.jpg') "></a>
						<div class="lh-content">
							<span class="category">Public University</span> <a href="#"
								class="bookmark"> <span class="icon-heart"></span>
							</a>
							<h3>
								<a class="hovera" href="${pageContext.request.contextPath}/view/jsp/page/DetailInforUI.jsp"> Harvard
									University </a>
							</h3>
							<address>
								Cambridge, MA, United States <br/> (Americas)
							</address>
							<p class="mb-0">
								<span class="icon-star text-warning"></span> <span
									class="icon-star text-warning"></span> <span
									class="icon-star text-warning"></span> <span
									class="icon-star text-warning"></span> <span
									class="icon-star text-secondary"></span> <span class="review">(1224
									Reviews)</span>
							</p>
						</div>
					</div>
					<div class="d-block d-md-flex listing hoverd">
						<a href="${pageContext.request.contextPath}/view/jsp/page/DetailInforUI.jsp" class="img d-block"
							style=" background-image:url('${url}/images/college/sf.jpg ')"></a>
						<div class="lh-content">
							<span class="category">Public University</span> <a href="#"
								class="bookmark"> <span class="icon-heart"></span>
							</a>
							<h3>
								<a class="hovera" href="${pageContext.request.contextPath}/view/jsp/page/DetailInforUI.jsp"> Stanford
									University </a>
							</h3>
							<address>

								Stanford, CA 94305, United States <br/>(Americas)
							</address>
							<p class="mb-0">
								<span class="icon-star text-warning"></span> <span
									class="icon-star text-warning"></span> <span
									class="icon-star text-warning"></span> <span
									class="icon-star text-warning"></span> <span
									class="icon-star text-secondary" /> <span class="review">(1120
									Reviews)</span>
							</p>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="d-block d-md-flex listing hoverd">
						<a href="${pageContext.request.contextPath}/view/jsp/page/DetailInforUI.jsp" class="img d-block"
							style="background-image: url('${url}/images/college/cb2.jpg')"></a>
						<div class="lh-content">
							<span class="category">Public University</span> <a href="#"
								class="bookmark"> <span class="icon-heart"></span>
							</a>
							<h3>
								<a class="hovera" href="${pageContext.request.contextPath}/view/jsp/page/DetailInforUI.jsp"> University of
									Cambridge </a>
							</h3>
							<address>Cambridge CB2 1TN, United Kingdom <br/>(Europe)</address>
							<p class="mb-0">
								<span class="icon-star text-warning"></span> <span
									class="icon-star text-warning"></span> <span
									class="icon-star text-warning"></span> <span
									class="icon-star text-warning"></span> <span
									class="icon-star-half-full text-warning"></span> <span
									class="review">(1203 Reviews)</span>
							</p>
						</div>
					</div>
					<div class="d-block d-md-flex listing hoverd">
						<a href="${pageContext.request.contextPath}/view/jsp/page/DetailInforUI.jsp" class="img d-block"
							style="background-image: url(  '${url}/images/college/hv.jpg') "></a>
						<div class="lh-content">
							<span class="category">Public University</span> <a href="#"
								class="bookmark"> <span class="icon-heart"></span>
							</a>
							<h3>
								<a class="hovera" href="${pageContext.request.contextPath}/view/jsp/page/DetailInforUI.jsp"> Harvard
									University </a>
							</h3>
							<address>
								Cambridge, MA, United States <br/>(Americas)
							</address>
							<p class="mb-0">
								<span class="icon-star text-warning"></span> <span
									class="icon-star text-warning"></span> <span
									class="icon-star text-warning"></span> <span
									class="icon-star text-warning"></span> <span
									class="icon-star text-secondary"></span> <span class="review">(1224
									Reviews)</span>
							</p>
						</div>
					</div>
					<div class="d-block d-md-flex listing hoverd">
						<a href="${pageContext.request.contextPath}/view/jsp/page/DetailInforUI.jsp" class="img d-block"
							style=" background-image:url('${url}images/college/sf.jpg ')"></a>
						<div class="lh-content">
							<span class="category">Public University</span> <a href="#"
								class="bookmark"> <span class="icon-heart"></span>
							</a>
							<h3>
								<a class="hovera" href="${pageContext.request.contextPath}/view/jsp/page/DetailInforUI.jsp"> Stanford
									University </a>
							</h3>
							<address>

								Stanford, CA 94305, United States<br/> (Americas)
							</address>
							<p class="mb-0">
								<span class="icon-star text-warning"></span> <span
									class="icon-star text-warning"></span> <span
									class="icon-star text-warning"></span> <span
									class="icon-star text-warning"></span> <span
									class="icon-star text-secondary" /> <span class="review">(1120
									Reviews)</span>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-12 text-center mt-4">
			<a href="/advice"
				class="btn btn-primary rounded py-2 px-4 text-white"> Xem thêm </a>
		</div>
	</div>
	<script>
		function searchHint(){
			var keyword = document.getElementById("search-input").value;
			$.ajax({
				url: "search",
				type: "get",
				data:{
					keyword : keyword
				},
				success: function (data) {

					if (data.length > 0){
						document.getElementById("list-group").innerHTML ="";
						// console.log(data);
						console.log(keyword);
						var hint = document.getElementById("search-hint");
						hint.style.display="block";
						document.getElementById("list-group").innerHTML += data;
					}
					else {
						console.log('not found.');
						document.getElementById("search-hint").style.display="none";
					}
				},
				error: function (data) {
					console.log('An error occurred.');
					console.log(data);
				},
			});
		}

		function clickOnItem(event){
			document.getElementById("search-input").value = event;
			console.log(event);
			document.getElementById("search-hint").style.display="none";
		}


	</script>


	<jsp:include page="../component/footer.jsp"></jsp:include>
</body>
</html>