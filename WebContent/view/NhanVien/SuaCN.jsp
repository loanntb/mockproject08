<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../template/Header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<div id="main">
	<ol class="breadcrumb">
		<li><a href="./Home"><i class="fa fa-home"></i> Trang quản
				trị</a></li>
		<li class="active">Nhân Viên</li>
	</ol>
		 <div class="form-group col-md-12">
	<form method="post" action="UploadFile?maNV=${nhanVien.maNV}" enctype="multipart/form-data">
	<div class="col-xs-3">
		<div class="form-row">
			<div class="form-group col-md-12">
			  <c:set var="url" value="images/${nhanVien.anh}"></c:set>
                      
			 <img   class="img-thumbnail" id="csimage" name="csimage" style="border-radius:5px;height:250px; width:95%" src="${url}">
				
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
			  <input type="file" class="form-control" onchange="checknutbam()" name="csfile" id="csfile" >
			</div>
			<div class="form-group col-md-6">
				<button type="submit" value="submit" name="submit" id="nutbam" class="btn btn-primary "
				  style="margin-left: -25px;" disabled = true>Cập nhật ảnh</button>
			</div>
		</div>
	</div>  
	</form>
	<div class="col-xs-9">
		<form method="post" action="./SuaCaNhan" role="form">
		      	<input type="hidden" name="maNV" value="${nhanVien.maNV}" class="form-control" />
			<div class="col-xs-12">
				<div class="form-row">
					<div class="form-group col-md-6">
						<lable class="form-check-label">Tên Nhân viên:</lable>
						<input type="text" name="tenNV" value="${nhanVien.tenNV}" class="form-control" />
					</div>
					<div class="form-group col-md-6">
						<lable class="form-check-label">Giới tính:</lable>
						<select class="form-control" id="goiTinh" name="gioiTinh">
							<c:choose>
								<c:when test="${nhanVien.gioiTinh== 1}">
									<option selected value="1">Nam</option>
									  <option value="0">Nữ</option>
								</c:when>
								<c:otherwise>
									    <option selected value="0">Nữ</option>
									    <option value="1">Nam</option>
								</c:otherwise>
								
							</c:choose>
							 
						</select>
					</div>

				</div>
				<c:set var="today" value="${fn:substring(nhanVien.ngaySinh,0,10)}" />
    				<fmt:parseDate value="${today}" pattern="yyyy-MM-dd" var="parseDate" />
					<fmt:formatDate pattern="yyyy-MM-dd" value="${parseDate}" var="date1" />
				<div class="form-row">
					<div class="form-group col-md-6">
						<lable class="form-check-label">Ngày sinh:</lable>
						<input type='date' class="form-control" value="${date1}" name="ngaySinh" />
					</div>
					<div class="form-group col-md-6">
						<lable class="form-check-label">Chức vụ:</lable>
						<select class="form-control" id="maCV" name="maCV">
							<c:forEach var="chucvu" items="${DanhSachCV}">
							<c:choose>
								<c:when test="${nhanVien.maCV== chucvu.MaCV}">
									<option selected value="${nhanVien.maCV}">${chucvu.TenCV}</option>
								</c:when>
								<c:otherwise>
									  <option value="${nhanVien.maCV}">${chucvu.TenCV}</option>
								</c:otherwise>
							</c:choose>
							</c:forEach>
						</select>
					</div>


				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<lable class="form-check-label">Địa chỉ:</lable>
						<input type="text" name="diaChi" value="${nhanVien.diachi}" class="form-control" />
					</div>
					<div class="form-group col-md-6">
						<lable class="form-check-label">Số điện thoại:</lable>
						<fmt:parseNumber var = "i" type = "number" value = "${nhanVien.dienThoai}" />
						<input type="number" name="soDienThoai" value="0${i}" class="form-control" />
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<lable class="form-check-label">Phòng ban:</lable>
						<select class="form-control" id="maPB" name="maPB">
						
							<c:forEach var="phongban" items="${DanhSachPB}">
							<c:choose>
								<c:when test="${nhanVien.maPB== phongban.MaPB}">
									<option selected value="${nhanVien.maPB}">${phongban.TenPB}</option>
								</c:when>
								<c:otherwise>
									   <option value="${phongban.MaPB}">${phongban.TenPB}</option>
								</c:otherwise>
							</c:choose>
							
								
							</c:forEach>
						</select>
					</div>
					<div class="form-group col-md-6">
						<lable class="form-check-label">Email:</lable>
						<input type="email" name="email" value="${nhanVien.email}" class="form-control" />
					</div>
				</div>

				<div class="form-row"> 
					<div class="form-group col-md-3">
						<a class="btn btn-danger" href="./DanhSachNhanVienServlet"
							style="margin-left: 85px;"> Về Danh Sách </a>
					</div> 
					<div class="form-group col-md-3">
						<button type="submit" value="submit" name="submit"class="btn btn-primary "
							style="margin-left: 25px;">Sửa Nhân Viên</button>
					</div>

				</div>
			</div>
		</form>
	</div>
</div>


<!--END #main-->
</div>
</body>
<script>
function checknutbam() {
  document.getElementById("nutbam").disabled = false;
}
</script>
 <script type="text/javascript">
	
	$("#csfile").change(function() {
		
    readURL(this,'csimage');
});

	function readURL(input,giatrianh) {

    if (input.files && input.files[0]) {
      var reader = new FileReader();
    
      reader.onload = function(e) {
           
        $("#"+giatrianh).attr('src', e.target.result);
       
      }
      
      reader.readAsDataURL(input.files[0]);
    }
  }
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
</html>