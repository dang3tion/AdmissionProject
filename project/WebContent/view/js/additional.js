var countAddress = 1;

function addAddress() {


	countAddress = countAddress + 1;
	$('#address-table').append(
		'<tr> <th scope="row">'  + countAddress + '</th> <td> <div class="input"> <input name="tieude-diachi" placeHolder="Nhập tiêu đề VD: cơ sở 1,..." type="text" value=""> </div> </td> <td> <div class="input"> <input name="diachi" placeHolder="Nhập địa chỉ" type="text" value=""> </div> </td> <td> <div class="input"> <select id="province'  + countAddress   +'" style="width: 150px" name="diachi-tinh"> <option disabled selected>Chọn tỉnh thành</option> </select> </div> </td> <td> <div class="input"> <select name="diachi-huyen" id="district' + countAddress + '" style="width: 150px"> <option disabled selected value="chuachon">Chưa chọn</option> </select> </div> </td> <td> <div class="input"> <select name="diachi-trangthai" > <option value="hoatdong">Hoạt động</option> <option value="ngunghoatdong">Ngưng hoạt động</option> </select> </div> </td> </tr>'
	)
	$.getJSON("https://thongtindoanhnghiep.co/api/city/", function(data) {
		var se = document.getElementById('province' + countAddress);
		var arr = data['LtsItem'];
		se.setAttribute('onchange', 'onclickProvince(this.value,' + countAddress + ')');
		for (let a = 0; a < arr.length - 1; a++) {
			let option = document.createElement('option');
			option.setAttribute('value', arr[a]['ID']);
			option.innerHTML = arr[a]['Title'];
			se.appendChild(option);
		}

	});
}


var countPno = 1;

function addPhoneNo() {
	countPno++;
	$("#phoneNo").append(
		'<tr> <th scope="row">' + countPno + '</th> <td> <div class="input"> <input name="sdt-tieude" placeHolder="Nhập tiêu đề" type="text" value=""> </div> </td> <td> <div class="input"> <input name="sdt" placeHolder="Nhập số điện thoại" type="text" value=""> </div> </td> <td> <div class="input"> <select name="sdt-trangthai"> <option value="hoatdong">Hoạt động</option> <option value="ngunghoatdong">Ngưng hoạt động</option> </select> </div> </td> </tr>'
	)
}

function addImgSub() {
	$('#color-sub1').append(
		'<li class="content-input"> <div class="title"> <p>Chọn ảnh mô tả</p> </div> <div class="input"> <input type="text" name="anh-phu" id="color1-sub2" placeholder="Nhập URL ảnh" style="min-width: 310px;" />  </div> <div class="input"> <label class="choose-file" style="margin: 0; margin-left: 15px; border-radius: 3px; color: white; padding: 6px; background: #f89d13; cursor: pointer;">Chọn ảnh</label> </div> <img style="width: 40; height: 60px; object-fit: contain; margin-left: 10px; display: none" id="color1-sub2-img" src=""> </li>'
	);


}


