<%@ page import="java.util.ArrayList" %>
<%@ page import="model.CollegesInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:url var="url" scope="session" value="/view"></c:url>
<html>
<jsp:include page="../component/menu.jsp"></jsp:include>


<body onload="filter()">

	    <div class="site-blocks-cover2 overlay " style="background-image: url('${url}/images/hero_2.jpg')" data-aos="fade" data-stellar-background-ratio="1"></div>

        <div class="site-section bg-light ">
            <div class="container">
                <div class="form-search-wrap mb-3" data-aos="fade-up" data-aos-delay={200}>
<%--                    <form method="GET" action="filter">--%>
                    <input type="hidden" />
                        <div class="row align-items-center">
                            <div class="col-lg-12 mb-4 mb-xl-0 col-xl-3">
                                <div class="wrap-icon border">
                                    <span class="icon icon-room"></span>
                                    <select class="form-control rounded" name="province" id="province">
                                                <option  value="All">All</option>
												<option  value="An Giang">An Giang</option>
												<option  value="Bà Rịa – Vũng Tàu">Bà Rịa – Vũng Tàu</option>
												<option  value="Bắc Giang">Bắc Giang</option>
												<option  value="Bắc Kạn">Bắc Kạn</option>
												<option  value="Bạc Liêu">Bạc Liêu</option>
												<option  value="Bắc Ninh">Bắc Ninh</option>
												<option  value="Bến Tre">Bến Tre</option>
												<option  value="Bình Định">Bình Định</option>
												<option  value="Bình Dương">Bình Dương</option>
												<option  value="Bình Phước">Bình Phước</option>
												<option  value="Bình Thuận">Bình Thuận</option>
												<option  value="Cà Mau">Cà Mau</option>
												<option  value="Cần Thơ">Cần Thơ</option>
												<option  value="Cao Bằng">Cao Bằng</option>
												<option  value="Đà Nẵng">Đà Nẵng</option>
												<option  value="Đắk Lắk">Đắk Lắk</option>
												<option  value="Đắk Nông">Đắk Nông</option>
												<option  value="Điện Biên">Điện Biên</option>
												<option  value="Đồng Nai">Đồng Nai</option>
												<option  value="Đồng Tháp">Đồng Tháp</option>
												<option  value="Gia Lai">Gia Lai</option>
												<option  value="Hà Giang">Hà Giang</option>
												<option  value="Hà Nam">Hà Nam</option>
												<option  value="Hà Nội">Hà Nội</option>
												<option  value="Hà Tĩnh">Hà Tĩnh</option>
												<option  value="Hải Dương">Hải Dương</option>
												<option  value="Hải Phòng">Hải Phòng</option>
												<option  value="Hậu Giang">Hậu Giang</option>
												<option  value="Hòa Bình">Hòa Bình</option>
												<option  value="Hưng Yên">Hưng Yên</option>
												<option  value="Khánh Hòa">Khánh Hòa</option>
												<option  value="Kiên Giang">Kiên Giang</option>
												<option  value="Kon Tum">Kon Tum</option>
												<option  value="Lai Châu">Lai Châu</option>
												<option  value="Lâm Đồng">Lâm Đồng</option>
												<option  value="Lạng Sơn">Lạng Sơn</option>
												<option  value="Lào Cai">Lào Cai</option>
												<option  value="Long An">Long An</option>
												<option  value="Nam Định">Nam Định</option>
												<option  value="Nghệ An">Nghệ An</option>
												<option  value="Ninh Bình">Ninh Bình</option>
												<option  value="Ninh Thuận">Ninh Thuận</option>
												<option  value="Phú Thọ">Phú Thọ</option>
												<option  value="Phú Yên">Phú Yên</option>
												<option  value="Quảng Bình">Quảng Bình</option>
												<option  value="Quảng Nam">Quảng Nam</option>
												<option  value="Quảng Ngãi">Quảng Ngãi</option>
												<option  value="Quảng Ninh">Quảng Ninh</option>
												<option  value="Quảng Trị">Quảng Trị</option>
												<option  value="Sóc Trăng">Sóc Trăng</option>
												<option  value="Sơn La">Sơn La</option>
												<option  value="Tây Ninh">Tây Ninh</option>
												<option  value="Thái Bình">Thái Bình</option>
												<option  value="Thái Nguyên">Thái Nguyên</option>
												<option  value="Thanh Hóa">Thanh Hóa</option>
												<option  value="Thừa Thiên Huế">Thừa Thiên Huế</option>
												<option  value="Tiền Giang">Tiền Giang</option>
												<option  value="TP Hồ Chí Minh">TP Hồ Chí Minh</option>
												<option  value="Trà Vinh">Trà Vinh</option>
												<option  value="Tuyên Quang">Tuyên Quang</option>
												<option  value="Vĩnh Long">Vĩnh Long</option>
												<option  value="Vĩnh Phúc">Vĩnh Phúc</option>
												<option  value="Yên Bái">Yên Bái</option>

                    </select>
                                </div>
                            </div>
                            <div class="col-lg-12 mb-4 mb-xl-0 col-xl-3">
                                <div class="select-wrap border">
                                    <select class="form-control rounded" name="major" id="major">
                                        <%
                                        ArrayList<String> majors = (ArrayList<String>) request.getAttribute("majors");
                                        %>

                                        <% for(String s : majors){ %>
                                        <option value="<%=s%>"><%=s%></option>
                                        <%}%>

                                    </select>
                                    <span class="icon">
                      <span class="icon-keyboard_arrow_down"></span>
                                    </span>
<%--                                    <input type="hidden" value="<%= request.getParameter("page")%>" name="page"/>--%>
                                    
                                </div>
                            </div>
                            <div class="col-lg-12 mb-4 mb-xl-0 col-xl-3">
                                <div class="select-wrap border">
                                    <span class="icon">
                      <span class="icon-keyboard_arrow_down"></span>
                                    </span>
                                    <select class="form-control rounded" name="type" id="type">
				                      <option value="daihoc">Public University</option>
				                      <option value="Private University">Private University</option>
				                      <option value="Public College">Public College</option>
				                      <option value="Private College">Private College</option>
				                      <option value="Nation University">Nation University</option>
				                      <option value="Institutes">Institutes</option>
				                      <option value="Centres">Centres</option>
				                    </select>	
                        </div>
                            </div>
                            <div class="col-lg-12 mb-4 mb-xl-0 col-xl-3">
                          	 <button type="submit" class="cta btn btn-primary btn-block rounded" onclick="filter()">
            		            <span class="text-white rounded">Filter</span>
			                 </button>
                            </div>
                        </div>
<%--                    </form>--%>
                </div>

                <div class="row mb-5">
                    <div class="col-md-7 text-left border-primary">
                        <h2 class="font-weight-light text-primary">Result</h2>
                    </div>
                </div>
                <section class="">
                    <div class="container">
                        <div class="row" id="college-list">

<%--                        <% ArrayList<CollegesInfo> colleges = (ArrayList<CollegesInfo>) request.getAttribute("list");--%>
<%--                            for(CollegesInfo c : colleges) { %>--%>
<%--                            <div class="col-md-6 ">--%>
<%--                                <a class=" hover-bg-enlarge link-normal" href="/college-list?action=detail&id=<%=c.getIdColleges()%>">--%>
<%--                                    <div class="propertie-item set-bg2 " style="background-image: url('${url}/images/college/cb.jpg')">--%>
<%--                                        <div class="propertie-info text-white" style="background-color: rgba(0, 0, 0, 0.212);">--%>
<%--                                            <div class="info-warp">--%>
<%--                                                <h5><%=c.getName()%></h5>--%>
<%--                                                <p>--%>
<%--                                                    <%= c.getIntroduce()%>--%>
<%--                                                    <br/>--%>
<%--                                                   Website: <a class="link-normal" href="<%=c.getWebsite()%>"><%=c.getWebsite()%></a>--%>
<%--                                                </p>--%>
<%--                                            </div>--%>
<%--                                            <p class="price2 mb-0">--%>
<%--                                                <span class="icon-star text-warning"></span>--%>
<%--                                                <span class="icon-star text-warning"></span>--%>
<%--                                                <span class="icon-star text-warning"></span>--%>

<%--                                                <span class="icon-star text-warning"></span>--%>
<%--                                                <span class="icon-star-half-full text-warning"></span>--%>
<%--                                                <span class="review">(1302 Reviews)</span>--%>
<%--                                            </p>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </a>--%>
<%--                                <hr></hr>--%>
<%--                            </div>--%>
<%--                       <%}%>--%>
                        </div>
                    </div>
                </section>
            </div>
        </div>

        <div class="container mt-3 mb-3" id="page-number-container" style="display: none">
            <div class="rehomes-pagination-counter mb-100 d-flex flex-wrap justify-content-between align-items-center wow fadeInUp" data-wow-delay="200ms" style="visibility: visible" ; animationDelay="200ms" animationName="fadeInUp">
<%--                <% if(colleges.size() > 0){%>--%>
                <nav class="rehomes-pagination" id="list-number">
					<input type="hidden" name="page" value="<%=request.getParameter("page")%>" id="currentPage">
                    <ul class="pagination" id="list-item">
<%--                        <%--%>
<%--                            int numberPage = (int) request.getAttribute("numberPage");--%>
<%--                            for (int i = 0; i < numberPage;i++){%>--%>
                        <li class="page-item" id="item">
<%--                            <% String link = "filter?province="+request.getParameter("province")+"&major="+request.getParameter("major")+"&page="+(i+1)+"&type="+request.getParameter("type");%>--%>
                            <a class="page-link" href="" id="item-page">
<%--                                <h5> <%=(i+1)%></h5>--%>
                            </a>
                        </li>
<%--                        <%}--%>
<%--                        %>--%>

<%--                        <li class="page-item">--%>
<%--                            <a class="page-link" href="#">--%>
<%--                                <h5> Next</h5>--%>
<%--                            </a>--%>
<%--                        </li>--%>
                    </ul>
                </nav>
                <div class="page-counter" id="next-page">
                    <p>
<%--                        <%--%>
<%--                            int currentPage = Integer.parseInt(request.getParameter("page"));--%>
<%--                        %>--%>
<%--                        Page <span><%=currentPage%></span> of <span><%=numberPage%></span> <% if(numberPage >1) {%>results <%}else{%> result<%}%>--%>

						Page <span id="current-page"></span> of <span id="total-page"></span>
					</p>
                </div>
<%--                <%}else{%>--%>
                <p id="notify" style="margin: auto; display: none">Không tìm thấy!</p>
<%--                <%}%>--%>
            </div>
        </div>


	<jsp:include page="../component/footer.jsp"></jsp:include>

    <script>
       function filter(){
		   document.getElementById("next-page").style.display = "block";
		   document.getElementById("notify").style.display = "none";
		   document.getElementById("list-number").style.display = "block";
           $.ajax({
               url: "filter",
               type: "get",
               data: {
                   province : document.getElementById("province").value,
                   major : document.getElementById("major").value,
                   type: document.getElementById("type").value,
				   page: document.getElementById("currentPage").value
               },
               success: function (data) {
                   if (data.length > 0) {
					   var parent = document.getElementById("college-list");
					   console.log(data);

					   var item = data.substring(0,data.lastIndexOf("</div>"));
					   var numberPage = data.substring(data.lastIndexOf("</div>")+6);

					   console.log(numberPage);

					   parent.innerHTML = item;

					   document.getElementById("page-number-container").style.display = "block";
					   var listItem = document.getElementById("list-item");
					   var item = document.getElementById("item");
					   listItem.innerHTML = "";
					   var currentPage = 0;
					   currentPage = document.getElementById("currentPage").value;
					   console.log(currentPage);
					   for (let i = 0; i < numberPage;i++){
					   		item.innerHTML =  '<li class="page-item" id="item" onclick="filterByItem('+(i+1)+');"> <a class="page-link" id="item-page"> <h5 id="text-item">'+(i+1)+'</h5> </a> </li>';
						    listItem.innerHTML += item.innerHTML;
					   }
					   console.log(currentPage);

					   document.getElementById("currentPage").value = 1;

					   document.getElementById("current-page").innerText = currentPage;
					   document.getElementById("total-page").innerText = numberPage;


					   // hiển thị màu ở trang hiện tại
					   document.getElementsByClassName("page-link")[currentPage-1].style.backgroundColor="#a0d7ff";
					   document.getElementsByClassName("page-link")[currentPage-1].style.color="white";


					   // document.getElementById("item").style.backgroundColor="#4fc3f7";
					   // document.getElementById("text-item").style.color = "#ffffff";
                   }
                   else {
					   document.getElementById("next-page").style.display = "none";
					   document.getElementById("notify").style.display = "block";
					   document.getElementById("list-number").style.display = "none";

                       console.log('not found.');
                       document.getElementById("college-list").innerHTML= "";
                   }
               },
               error: function (data) {
                   console.log('An error occurred.');
                   console.log(data);
               },
           });
       }
       function setInputPage(event){
       		document.getElementById("currentPage").value = event;
       		console.log(event);
		   	console.log(document.getElementById("currentPage").value);
	   }
	   function filterByItem(event){
       		setInputPage(event);
       		filter();
	   }
    </script>
</body>
</html>