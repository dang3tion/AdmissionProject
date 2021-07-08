<%@ page import="java.util.ArrayList" %>
<%@ page import="model.CollegesInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:url var="url" scope="session" value="/view"></c:url>
<html>
<jsp:include page="../component/menu.jsp"></jsp:include>


<body>

	    <div class="site-blocks-cover2 overlay " style="background-image: url('${url}/images/hero_2.jpg')" data-aos="fade" data-stellar-background-ratio="1"></div>

        <div class="site-section bg-light">
            <div class="container">


                <div class="row mb-5">
                    <div class="col-md-7 text-left border-primary">
                        <h5 class="font-weight-light text-primary">Kết quả tìm kiếm của từ: <%=request.getParameter("keyword")%> </h5>
                    </div>
                </div>
                <section class="">
                    <div class="container">
                        <div class="row">
                        <% ArrayList<CollegesInfo> colleges = (ArrayList<CollegesInfo>) request.getAttribute("list");
                            for(CollegesInfo c : colleges) { %>
                            <div class="col-md-6 ">
                                <a class=" hover-bg-enlarge link-normal" href="/college-list?action=detail&id=<%=c.getIdColleges()%>">
                                    <div class="propertie-item set-bg2 " style="background-image: url('${url}/images/college/cb.jpg')">
                                        <div class="propertie-info text-white" style="background-color: rgba(0, 0, 0, 0.212);">
                                            <div class="info-warp">
                                                <h5><%=c.getName()%></h5>
                                                <p>
                                                    <%= c.getIntroduce()%>
                                                    <br/>
                                                   Website: <a class="link-normal" href="<%=c.getWebsite()%>"><%=c.getWebsite()%></a>
                                                </p>
                                            </div>
                                            <p class="price2 mb-0">
                                                <span class="icon-star text-warning"></span>
                                                <span class="icon-star text-warning"></span>
                                                <span class="icon-star text-warning"></span>

                                                <span class="icon-star text-warning"></span>
                                                <span class="icon-star-half-full text-warning"></span>
                                                <span class="review">(1302 Reviews)</span>
                                            </p>
                                        </div>
                                    </div>
                                </a>
                                <hr></hr>
                            </div>
                       <%}%>
                        </div>
                    </div>
                </section>
            </div>
        </div>

<%--        <div class="container mt-3 mb-3">--%>
<%--            <div class="rehomes-pagination-counter mb-100 d-flex flex-wrap justify-content-between align-items-center wow fadeInUp" data-wow-delay="200ms" style="visibility: visible" ; animationDelay="200ms" animationName="fadeInUp">--%>
<%--                <% if(colleges.size() > 0){%>--%>
<%--                <nav class="rehomes-pagination">--%>
<%--                    <ul class="pagination">--%>
<%--                        <%--%>
<%--                            int numberPage = (int) request.getAttribute("numberPage");--%>
<%--                            for (int i = 0; i < numberPage;i++){%>--%>
<%--                        <li class="page-item">--%>
<%--                            <% String link = "filter?province="+request.getParameter("province")+"&major="+request.getParameter("major")+"&page="+(i+1)+"&type="+request.getParameter("type");%>--%>
<%--                            <a class="page-link" href="<%=link%>">--%>
<%--                                <h5> <%=(i+1)%></h5>--%>
<%--                            </a>--%>
<%--                        </li>--%>
<%--                        <%}--%>
<%--                        %>--%>

<%--&lt;%&ndash;                        <li class="page-item">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <a class="page-link" href="#">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <h5> Next</h5>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </li>&ndash;%&gt;--%>
<%--                    </ul>--%>
<%--                </nav>--%>
<%--                <div class="page-counter">--%>
<%--                    <p>--%>
<%--                        <%--%>
<%--                            int currentPage = Integer.parseInt(request.getParameter("page"));--%>
<%--                        %>--%>
<%--                        Page <span><%=currentPage%></span> of <span><%=numberPage%></span> <% if(numberPage >1) {%>results <%}else{%> result<%}%>--%>
<%--                    </p>--%>
<%--                </div>--%>
<%--                <%}else{%>--%>
<%--                <p style="margin: auto">Không tìm thấy!</p>--%>
<%--                <%}%>--%>
<%--            </div>--%>
<%--        </div>--%>


	<jsp:include page="../component/footer.jsp"></jsp:include>
</body>
</html>