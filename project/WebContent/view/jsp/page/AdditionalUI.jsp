<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<c:url var="url" scope="session" value="/view"></c:url>
<html>
<jsp:include page="../component/menu.jsp"></jsp:include>
<link rel="stylesheet" href="${url}css/add.css">

<body>

	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
		integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
		crossorigin="anonymous" referrerpolicy="no-referrer" />
	<%
		response.setHeader("Access-Control-Allow-Origin", "*");
	%>
	<div class="site-blocks-cover2 overlay "
		style="background-image: url('${url}/images/hero_2.jpg')"
		data-aos="fade" data-stellar-background-ratio="1"></div>

	<form action="${pageContext.request.contextPath}/admin/additional"
		onsubmit="return onSubmit()" method="POST">
		<div class="site-section bg-light">
			<div class="container mt-5" style="margin-bottom: 100px;">

				<div class="container-fluid">
					<div class="frame-cog">
						<h3>Thêm thông tin trường mới</h3>
						<div class="save">
							<a
								href="${pageContext.request.contextPath}/admin"><button
									type="button" style="float: left">
									<i class="far fa-arrow-alt-circle-left"></i> Quay lại
								</button></a>
							<button type="button" data-toggle="modal"
								data-target="#add-product">Lưu lại toàn bộ</button>

						</div>

						<div class="frame-cog-content" id="frame-content">
							<div class="frame" style="box-shadow: 1px 1px 3px -1px #5f5f5f;">


								<div id="validate-msg">
									<c:if test="${ not empty msg}">

										<p style="font-style: italic; color: #ff5722;">
											<i class="fas fa-exclamation-circle"></i> ${msg }
										</p>
									</c:if>


								</div>
								<h5>Thông tin chung</h5>
								<ul class="information">
									<li class="content-input">
										<div class="title">
											<p>Tên trường</p>
										</div>

										<div class="input">
											<input name="tentruong" placeHolder="Nhập tên trường"
												type="text" value="">



										</div>

									</li>
									<li class="content-input">
										<div class="title">
											<p>Mã trường</p>
										</div>

										<div class="input">
											<input oninput="checkId(this.value)" name="matruong"
												placeHolder="Nhập mã trường" type="text" value="">



										</div>
										<div id="msg-unique"
											style="padding: 0px 10px; font-size: 14px;"></div>
									</li>
									<li class="content-input">
										<div class="title">
											<p>Chọn Logo</p>
										</div>

										<div class="input">
											<input type="text" placeHolder="Nhập URL ảnh"
												style="min-width: 310px;" name="logo" id="color-imgmain-1"
												value="">

										</div>

										<div class="input">
											<label class="choose-file"
												style="margin: 0; margin-left: 15px; border-radius: 3px; color: white; padding: 6px; background: #f89d13; cursor: pointer;"
												onclick="">Chọn ảnh</label>
										</div> <img
										style="width: 40; height: 60px; object-fit: contain; margin-left: 10px; display: none"
										id="color-imgmain-1-img" src="">


									</li>

									<li class="content-input">
										<div class="title">
											<p>Website chính</p>
										</div>

										<div class="input">
											<input name="urlWeb" placeHolder="Nhập URL website"
												type="text" value="a">



										</div>

									</li>
									<li class="content-input">
										<div class="title">
											<p>Giới thiệu</p>
										</div>

										<div class="input">
											<textarea name="gioithieu" placeHolder="Giới thiệu về trường"
												type="text" value=""></textarea>



										</div>

									</li>
									<li class="content-input">
										<div class="title">
											<p>Thông tin tuyển sinh</p>
										</div>

										<div class="input">
											<textarea name="tuyensinh" placeHolder="Mô tả" type="text"
												value=""></textarea>



										</div>

									</li>

									<li class="content-input">
										<div class="title">
											<p>Loại trường</p>
										</div>
										<div class="input">
											<select name="loaitruong">
												<option value="conglap">Công lập</option>
												<option value="tuthuc">Tư thục</option>
												<option value="danlap">Dân lập</option>
												<option value="lienket">Liên kết quốc tế</option>
											</select>
										</div>


									</li>

									<li class="content-input">
										<div class="title">
											<p>Trạng thái</p>
										</div>
										<div class="input">
											<select class="" name="trangthai">
												<option value="hoatdong">Hoạt động</option>
												<option value="ngunghoatdong">Ngưng hoạt động</option>
											</select>
										</div>
									</li>

								</ul>
							</div>
						</div>


					</div>

					<div class="frame-number" id="color-1"
						style="width: 95%; box-shadow: 1px 1px 3px -1px #5f5f5f;">
						<h5>Địa chỉ</h5>
						<div class="frame-cog-content">
							<div class="frame">
								<table class="table">
									<thead class="thead-light">
										<tr>
											<th scope="col" title="Số thứ tự">STT</th>
											<th scope="col">Tiêu đề</th>
											<th scope="col">Địa chỉ</th>
											<th scope="col">Tỉnh/Thành</th>
											<th scope="col">Quận/Huyện</th>

											<th scope="col">Trạng thái</th>
										</tr>
									</thead>
									<tbody id="address-table">
										<tr>
											<th scope="row">1</th>
											<td>
												<div class="input">
													<input name="tieude-diachi"
														placeHolder="Nhập tiêu đề VD: cơ sở 1,..." type="text"
														value="">



												</div>
											</td>
											<td>
												<div class="input">
													<input name="diachi" placeHolder="Nhập địa chỉ" type="text"
														value="">



												</div>
											</td>

											<td>
												<div class="input">
													<select id="province1" style="width: 150px"
														name="diachi-tinh">
														<option disabled selected>Chọn tỉnh thành</option>

													</select>
												</div>
											</td>
											<td>
												<div class="input">
													<select name="diachi-huyen" id="district1"
														style="width: 150px">
														<option disabled selected value="chuachon">Chưa
															chọn</option>

													</select>
												</div>
											</td>

											<td>
												<div class="input">
													<select name="diachi-trangthai">
														<option value="hoatdong">Hoạt động</option>
														<option value="ngunghoatdong">Ngưng hoạt động</option>
													</select>
												</div>
											</td>
										</tr>

									</tbody>

								</table>

								<div class="w-100" style="overflow: auto;">
									<button type="button" class="btn-warning float-right"
										onclick="addAddress()"
										style="color: white; box-shadow: 1px 1px 2px 0px #a5a5a5; padding: 5px; border-radius: 3px; outline: 0; border: 0">Thêm
										địa chỉ</button>
								</div>
							</div>
						</div>

					</div>
					<div class="frame-number" id="color-1"
						style="width: 95%; box-shadow: 1px 1px 3px -1px #5f5f5f;">
						<h5>Số điện thoại</h5>
						<div class="frame-cog-content">
							<div class="frame">
								<table class="table">
									<thead class="thead-light">
										<tr>
											<th scope="col" title="Số thứ tự">STT</th>
											<th scope="col">Tiêu đề</th>
											<th scope="col">Số điện thoại</th>
											<th scope="col">Trạng thái</th>
										</tr>
									</thead>
									<tbody id="phoneNo">
										<tr>
											<th scope="row">1</th>
											<td>
												<div class="input">
													<input name="sdt-tieude" placeHolder="Nhập tiêu đề"
														type="text" value="">



												</div>
											</td>
											<td>
												<div class="input">
													<input name="sdt" placeHolder="Nhập số điện thoại"
														type="text" value="">



												</div>
											</td>

											<td>
												<div class="input">
													<select name="sdt-trangthai">
														<option value="hoatdong">Hoạt động</option>
														<option value="ngunghoatdong">Ngưng hoạt động</option>
													</select>
												</div>
											</td>
										</tr>

									</tbody>

								</table>

								<div class="w-100" style="overflow: auto;">
									<button type="button" class="btn-warning float-right"
										style="color: white; box-shadow: 1px 1px 2px 0px #a5a5a5; padding: 5px; border-radius: 3px; outline: 0; border: 0"
										onclick="addPhoneNo()">Thêm số điện thoại</button>
								</div>
							</div>
						</div>

					</div>
					<div class="frame-number" id="color-1"
						style="width: 95%; box-shadow: 1px 1px 3px -1px #5f5f5f;">

						<h5>Hình ảnh</h5>



						<div class="frame-cog-content">
							<div class="frame">
								<ul class="information">


									<li class="content-input">
										<div class="title">
											<p>Chọn ảnh nền</p>
										</div>

										<div class="input">
											<input type="text" style="min-width: 310px;"
												placeholder="Nhập URL ảnh nền" name="anh-nen"
												id="color-imgmain-1" value="">

										</div>

										<div class="input">
											<label class="choose-file"
												style="margin: 0; margin-left: 15px; border-radius: 3px; color: white; padding: 6px; background: #f89d13; cursor: pointer;"
												onclick="">Chọn ảnh</label>
										</div> <img
										style="width: 40; height: 60px; object-fit: contain; margin-left: 10px; display: none"
										id="color-imgmain-1-img" src="">


									</li>
									<div id="color-sub1">

										<li class="content-input">
											<div class="title">
												<p>Chọn ảnh mô tả</p>
											</div>

											<div class="input">
												<input type="text" style="min-width: 310px;"
													placeholder="Nhập URL ảnh" name="anh-phu" id="color1-sub1" />
												<!-- <label class="choose-file" style="margin: 0;"
																for="color1-sub1">Chọn ảnh</label> -->
											</div>



											<div class="input">
												<label class="choose-file"
													style="margin: 0; margin-left: 15px; border-radius: 3px; color: white; padding: 6px; background: #f89d13; cursor: pointer;">Chọn
													ảnh</label>
											</div> <img
											style="width: 40; height: 60px; object-fit: contain; margin-left: 10px; display: none"
											id="color1-sub1-img" src="">
										</li>
										<li class="content-input">
											<div class="title">
												<p>Chọn ảnh mô tả</p>
											</div>

											<div class="input">
												<input type="text" name="anh-phu" id="color1-sub2"
													placeholder="Nhập URL ảnh " style="min-width: 310px;" />
												<!-- <label class="choose-file" style="margin: 0;"
																for="color1-sub2">Chọn ảnh</label> -->
											</div>

											<div class="input">
												<label class="choose-file"
													style="margin: 0; margin-left: 15px; border-radius: 3px; color: white; padding: 6px; background: #f89d13; cursor: pointer;">Chọn
													ảnh</label>
											</div> <img
											style="width: 40; height: 60px; object-fit: contain; margin-left: 10px; display: none"
											id="color1-sub2-img" src="">

										</li>

									</div>
									<li class="content-input">
										<div class="title">
											<button type="button" class="btn-primary"
												style="box-shadow: 1px 1px 2px 0px #a5a5a5; padding: 5px; border-radius: 3px; outline: 0; border: 0"
												onclick="addImgSub()">Thêm ảnh mô tả</button>
										</div>
									</li>
								</ul>
							</div>
						</div>

					</div>
					<div class=" frame-number " id="color-1"
						style="width: 95%; box-shadow: 1px 1px 3px -1px #5f5f5f; margin-bottom: 30px;">
						<h5>Khung đào tạo</h5>
						<div class="frame-cog-content">
							<div class="frame">
								<ul class="information">
									<li class="content-input">
										<div class="title">
											<p>Chọn năm</p>
										</div>
										<div class="input">
											<select name="khung-nam">
												<option value="2021">2021</option>

											</select>
										</div>


									</li>
									<li class="content-input">
										<div class="title">
											<p>Loại khung</p>
										</div>
										<div class="input">
											<select name="loai-khung">
												<c:forEach items="${lstFrame }" var="frame">
													<option value="${frame.id }">${frame.typeFrame }</option>
												</c:forEach>
											</select>
										</div>


									</li>
									<li class="content-input">
										<div class="title">
											<p>Mô tả</p>
										</div>

										<div class="input">
											<textarea name="mota-khung" placeHolder="Nhập mô tả"
												type="text" value=""></textarea>



										</div>

									</li>
									<li class="content-input">
										<div class="title">
											<p>Trạng thái</p>
										</div>
										<div class="input">
											<select name="trangthai-khung">
												<option value="hieuluc">Có hiệu lực</option>
												<option value="vohieuluc">Vô hiệu lực</option>
											</select>
										</div>


									</li>
									<li class="content-input">
										<div class="title">
											<p>Mức học phí</p>
										</div>

										<div class="input">
											<input name="hocphi" placeHolder="Nhập mức học phí"
												type="text" value="">



										</div>

									</li>
									<li class="content-input">
										<div class="title">
											<p></p>
										</div>

										<div class="input">
											<input name="giatri-hocphi"
												placeHolder="Nhập giá trị tương đương" type="number"
												value="" step=0.01>



										</div>

									</li>
									<li class="content-input">
										<div class="title">
											<p>Mô tả (học phí)</p>
										</div>

										<div class="input">
											<textarea name="mota-hocphi" placeHolder="Nhập mô tả học phi"
												type="text" style="height: 100px;" value=""></textarea>



										</div>

									</li>




								</ul>
								<table class="table">
									<thead class="thead-light">
										<tr>
											<th scope="col">Ngành</th>
											<th scope="col">Điểm đầu vào</th>
											<th scope="col">Chỉ tiêu</th>

											<th scope="col">Tổ hợp môn</th>
											<th scope="col" style="width: 350px;">Mô tả</th>
										</tr>
									</thead>
									<tbody id="frame1">
										<tr>
											<td>
												<div class="input">
													<select name="nganh1">
														<c:forEach items="${lstCourse}" var="course">
															<option value="${course.id }">${course.name }</option>
														</c:forEach>

													</select>
												</div>
											<td>
												<div class="input">
													<input name="diem-nganh1" placeHolder="Nhập điểm"
														type="number" value="" step=0.01>
												</div>
											</td>

											<td>
												<div class="input">
													<input name="chitieu-nganh1" placeHolder="Nhập chỉ tiêu"
														type="number" value="">
												</div>
											</td>
											<td>
												<div class="input">
													<input name="tohop-nganh1" placeHolder="VD: A01,A02"
														type="text" value="">
												</div>
											</td>

											<td>
												<div class="input">
													<textarea name="mota-nganh1" placeHolder="Nhập mô tả"
														type="text"
														style="height: 100px; padding: 5px; outline: 0; width: 300px;"
														value=""></textarea>
												</div>
											</td>


										</tr>


									</tbody>

								</table>
								<div class="w-100" style="overflow: auto;">
									<button type="button" class="btn-warning float-right"
										style="color: white; box-shadow: 1px 1px 2px 0px #a5a5a5; padding: 5px; border-radius: 3px; outline: 0; border: 0"
										onclick="addCourse(1)">Thêm ngành</button>
								</div>
							</div>
						</div>


					</div>
					<div id="frame-add"></div>
					<div>

						<button type="button" class="btn-primary" data-toggle="modal"
							data-target="#add-color-btn"
							style="background: #FFC107; margin-right: 30px; float: right; box-shadow: 1px 1px 2px 0px #a5a5a5; padding: 10px; border-radius: 3px; outline: 0; border: 0;">Thêm
							khung đào tạo</button>
					</div>

				</div>


				<!-- color -->



				<!-- thong so ki thuat -->



				<div class="modal fade" id="add-product" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Xác nhận
									thêm thông tin</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<p>Thông tin trường mới bạn thêm vào không thể xóa bỏ, bạn
									có chắc chắn muốn thêm thông tin trường này không?</p>

							</div>
							<div class="modal-footer">
								<button type="submit" class="btn btn-primary" name="confirm-add"
									value="">Đồng ý</button>
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Hủy</button>
							</div>
						</div>
					</div>
				</div>
				<div class="modal fade" id="add-color-btn" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalCenterTitle"
					aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLongTitle">Xác nhận
									thêm thông tin</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">Bạn có muốn thêm khung đào tạo mới
								ko.</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Không</button>
								<button type="button" onclick="addFrame()" id="btnAddColor"
									data-dismiss="modal" class="btn btn-primary">Đồng ý</button>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>

	</form>




	<jsp:include page="../component/footer.jsp"></jsp:include>
	<script>
                    function onclickProvince(id, l) {
                        $.getJSON("https://cors-anywhere.herokuapp.com/https://thongtindoanhnghiep.co/api/city/" + id +
                            "/district",
                            function(data) {
                                console.log(data);
                                var se = document.getElementById('district' + l);
                                se.innerHTML = "";
                                var arr = data;
                                for (let a = 0; a < arr.length - 1; a++) {
                                    let option = document.createElement('option');
                                    option.setAttribute('value', arr[a]['ID']);
                                    option.innerHTML = arr[a]['Title'];
                                    se.appendChild(option);
                                }

                            });;
                    }
                    $.getJSON("https://cors-anywhere.herokuapp.com/https://thongtindoanhnghiep.co/api/city/", function(data) {
                        var se = document.getElementById('province1');
                        var arr = data['LtsItem'];
                        se.setAttribute('onchange', 'onclickProvince(this.value,1)');
                        for (let a = 0; a < arr.length - 1; a++) {
                            let option = document.createElement('option');
                            option.setAttribute('value', arr[a]['ID']);
                            option.innerHTML = arr[a]['Title'];
                            se.appendChild(option);
                        }

                    });;
                    
                    
                    
                </script>


	<script src="${url}/js/additional.js"></script>
	<script>
	var countFrame=1;
	function addFrame(){
		countFrame++;
		$("#frame-add").append(
	'			<div class=" frame-number " id="color-1" style="width: 95%; box-shadow: 1px 1px 3px -1px #5f5f5f; margin-bottom: 30px;"> <h5>Khung đào tạo</h5> <div class="frame-cog-content"> <div class="frame"> <ul class="information"> <li class="content-input"> <div class="title"> <p>Chọn năm</p> </div> <div class="input"> <select name="khung-nam"> <option value="2021">2021</option> </select> </div> </li> <li class="content-input"> <div class="title"> <p>Loại khung</p> </div> <div class="input"> <select name="loai-khung"> <option value="chinhquy">Đại học chính quy</option> <option value="caodang">Cao đẳng</option> <option value="tientien">Chất lượng tiên tiến</option> <option value="chatluongcao">Chất lượng cao</option> <option value="lienketquocte">Liên kết quốc tế</option> </select> </div> </li> <li class="content-input"> <div class="title"> <p>Mô tả</p> </div> <div class="input"> <textarea name="mota-khung" placeHolder="Nhập mô tả" type="text" value=""></textarea> </div> </li> <li class="content-input"> <div class="title"> <p>Trạng thái</p> </div> <div class="input"> <select name="trangthai-khung"> <option value="hieuluc">Có hiệu lực</option> <option value="vohieuluc">Vô hiệu lực</option> </select> </div> </li> <li class="content-input"> <div class="title"> <p>Mức học phí</p> </div> <div class="input"> <input name="hocphi" placeHolder="Nhập mức học phí" type="text" value=""> </div> </li> <li class="content-input"> <div class="title"> <p></p> </div> <div class="input"> <input name="giatri-hocphi" placeHolder="Nhập giá trị tương đương" type="number" value=""> </div> </li> <li class="content-input"> <div class="title"> <p>Mô tả (học phí)</p> </div> <div class="input"> <textarea name="mota-hocphi" placeHolder="Nhập mô tả học phi" type="text" style="height: 100px;" value=""></textarea> </div> </li> </ul> <table class="table"> <thead class="thead-light"> <tr> <th scope="col">Ngành</th> <th scope="col">Điểm đầu vào</th> <th scope="col">Chỉ tiêu</th> <th scope="col">Tổ hợp môn</th> <th scope="col" style="width: 350px;">Mô tả</th> </tr> </thead> <tbody id="frame'+countFrame+'"> <tr> <td> <div class="input"> <select name="nganh'+countFrame+'"> <c:forEach items="${lstCourse}" var="course"> <option value="${course.id }">${course.name }</option> </c:forEach> </select> </div> <td> <div class="input"> <input name="diem-nganh'+countFrame+'" placeHolder="Nhập điểm" type="number" value=""> </div> </td> <td> <div class="input"> <input name="chitieu-nganh'+countFrame+'" placeHolder="Nhập chỉ tiêu" type="number" value=""> </div> </td> <td> <div class="input"> <input name="tohop-nganh'+countFrame+'" placeHolder="VD: A01,A02" type="text" value=""> </div> </td> <td> <div class="input"> <textarea name="mota-nganh'+countFrame+'" placeHolder="Nhập mô tả" type="text" style="height: 100px; padding: 5px; outline: 0; width: 300px;" value=""></textarea> </div> </td> </tr> </tbody> </table> <div class="w-100" style="overflow: auto;"> <button type="button" class="btn-warning float-right" style="color: white; box-shadow: 1px 1px 2px 0px #a5a5a5; padding: 5px; border-radius: 3px; outline: 0; border: 0" onclick="addCourse('+countFrame+')">Thêm ngành</button> </div> </div> </div> </div>'
		);
		
	}
	function addCourse(id){
	$('#frame'+id).append(
	
	'<tr> <td> <div class="input"> <select name="nganh'+countFrame+'"> '+
	
	<c:forEach items="${lstCourse}" var="course"> 
	
	'<option value="${course.id }">${course.name }</option> '+
	</c:forEach>
	' </select> </div> <td> <div class="input"> <input name="diem-nganh'+countFrame+'" placeHolder="Nhập điểm" type="number" value=""> </div> </td> <td> <div class="input"> <input name="chitieu-nganh'+countFrame+'" placeHolder="Nhập chỉ tiêu" type="number" value=""> </div> </td> <td> <div class="input"> <input name="tohop-nganh'+countFrame+'" placeHolder="VD: A01,A02" type="text" value=""> </div> </td> <td> <div class="input"> <textarea value="" name="mota-nganh'+countFrame+'" placeHolder="Nhập mô tả" type="text" style="height: 100px; padding: 5px; outline: 0; width: 300px;" ></textarea>'
	
	)
}
	
	function sendMsgValidate(msg, check) {
		document.getElementById('validate-msg').innerHTML = "";
		if (check) {
			$('#validate-msg').append('<p style="font-style: italic; color: #2196f3;"> <i class="fas fa-check-circle"></i> '  + msg + ' </p>')

		} else {
			$('#validate-msg').append('<p style="font-style: italic; color: #ff5722;"> <i class="fas fa-check-circle"></i> ' + msg + ' </p>')
		}
	}
	var isExistsId=false;
	function checkId(id) {

		$.ajax({
			type : 'POST',
			url : '${pageContext.request.contextPath}/admin/additional',
			data : {

				id : id

			},
			success : function(response) {
				$('#msg-unique').empty();
				if(response=='true'){
					$('#msg-unique').append('<p style="color: #f54646;"> <span><i class="far fa-times-circle" style="font-size: 17px; padding: 10px;"></i></span>Mã trường đã tồn tại </p> ')
				isExistsId= true;
				}else if(response=='false') {
				
					$('#msg-unique').append(' <p style="color: #f54646;"> <span><i class="far fa-check-circle" style="font-size: 17px; padding: 10px; color: #2196f3;"></i></span> </p> ')
				isExistsId= false;
				}
			}

		});

	}

	function onSubmit() {
	
		var input = document.getElementsByTagName('input');
		var select = document.getElementsByTagName('select');
		for (let i = 0; i < input.length; i++) {
			let c = input[i];
			if (c.value === null || c.value === "") {	
				sendMsgValidate('Vui lòng nhập thông tin đầy đủ các trường nhập liệu',false);
				c.style.border = "1px solid #ff5757";
				return false;
			} else {
				c.style.border = "   1px solid rgb(158, 158, 158)";
			}


		}
		for (let i = 0; i < select.length; i++) {
			let c = select[i];
			if (c.value == "") {
				sendMsgValidate('Vui lòng chọn thông tin đầy đủ',false);
				c.style.border = "1px solid #ff5757";
				return false;
			} else {
				c.style.border = "   1px solid rgb(158, 158, 158)";
			}
		}
		if(isExistsId){
			return false;
		}
		return true;
	}
	

</script>
</body>

</html>