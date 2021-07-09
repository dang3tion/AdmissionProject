<%@ page import="java.util.ArrayList" %>
<%@ page import="model.CollegesInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:url var="url" scope="session" value="/view"></c:url>
<html>
<jsp:include page="../component/menu.jsp"></jsp:include>
<style>
    .form-search-wrap {
        background: #bde3ff !important;
    }
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

	    <div class="site-blocks-cover2 overlay " style="background-image: url('${url}/images/hero_2.jpg')" data-aos="fade" data-stellar-background-ratio="1"></div>

        <div class="site-section bg-light">
            <div class="container">

                <div class="form-search-wrap mb-3" data-aos="fade-up"
                     data-aos-delay={200}>
                    <form method="GET" action="search">
                        <div class="row align-items-center">
                            <div class="col-lg-12 mb-10 mb-xl-0 col-xl-10 search-text">
                                <input type="text" class="form-control rounded search-input" id="search-input" oninput="searchHint()"
                                       placeholder="Enter college name " autoFocus name="keyword"/>
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

                            <div class="col-lg-12 col-xl-2 ml-auto text-right">
                                <%--									<NavLink to="/searching" class="cta btn btn-primary btn-block rounded">--%>
                                <%--										<button type="submit"> <span class=" text-white rounded"> Tìm kiếm </span></button>--%>
                                <%--									</NavLink>--%>

                                <button type="submit" class="cta btn btn-primary btn-block rounded">
                                    <span class="text-white rounded">Tìm kiếm</span>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>


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

        <div class="container mt-3 mb-3">
            <div class="rehomes-pagination-counter mb-100 d-flex flex-wrap justify-content-between align-items-center wow fadeInUp" data-wow-delay="200ms" style="visibility: visible" ; animationDelay="200ms" animationName="fadeInUp">
                <% if(colleges.size() > 0){%>
                <nav class="rehomes-pagination">
                    <ul class="pagination">
                        <%
                            int numberPage = (int) request.getAttribute("numberPage");
                            for (int i = 0; i < numberPage;i++){%>
                        <li class="page-item">
                            <% String link = "search?keyword="+request.getParameter("keyword")+"&page="+(i+1);%>
                            <a class="page-link" href="<%=link%>">
                                <h5> <%=(i+1)%></h5>
                            </a>
                        </li>
                        <%}
                        %>

<%--                        <li class="page-item">--%>
<%--                            <a class="page-link" href="#">--%>
<%--                                <h5> Next</h5>--%>
<%--                            </a>--%>
<%--                        </li>--%>
                    </ul>
                </nav>
                <div class="page-counter">
                    <p>
                        <%
                            int currentPage = Integer.parseInt(request.getParameter("page"));
                        %>
                        Page <span><%=currentPage%></span> of <span><%=numberPage%></span> <% if(numberPage >1) {%>results <%}else{%> result<%}%>
                    </p>
                </div>
                <%}else{%>
                <p style="margin: auto">Không tìm thấy!</p>
                <%}%>
            </div>
        </div>


	<jsp:include page="../component/footer.jsp"></jsp:include>

    <script>
        function searchHint(){
            var keyword = document.getElementById("search-input").value;
            $.ajax({
                url: "search-hint",
                type: "get",
                data:{
                    keyword : keyword
                },
                success: function (data) {

                    if (data.length > 0){
                        document.getElementById("list-group").innerHTML ="";
                        console.log(data);
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
</body>
</html>