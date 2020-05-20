<%@ page import="model.bean.NhanVien"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../template/Header.jsp"></jsp:include>
<div id="main">
	<ol class="breadcrumb">
		<li><a href="./Home"><i class="fa fa-home"></i> Trang quản
				trị</a></li>
		<li class="active"><a href="./DanhSachHoatDong">Học Vấn</a></li>
		<li class="active">Thêm Học Vấn</li>
	</ol>
	<div class="col-xs-12">
		<form id="form-insert" action="./ThemTrinhDoHV" method="post"
			name="form1" class=" col-xl-9 col-lg-10 col-md-12 col-sm-12">
			<div class="form-row">
				<div class="form-group col-md-6">
					<lable class="form-check-label">Mã trình độ Học Vấn</lable>
					<input type="text" value="${maHV}" readonly="readonly" name="maHV"
						id="maHV" class="form-control" />
				</div>
				<div class="form-group col-md-6">
					<lable class="form-check-label">Tên trình độ học Vấn</lable>
					<input type="text" name="tenHV" id="tenHV" class="form-control" />
				</div>

			</div>
			<div class="form-group">
				<div class="col-lg-6">
					<lable class="form-check-label">Tên nhân viên</lable>
					<select class="form-control" name="nhanVien" id="nhanVien">
						<%
							ArrayList<NhanVien> listNhanVien = (ArrayList<NhanVien>) request.getAttribute("listNhanVien");
							for (NhanVien nhanVien : listNhanVien) {
						%>
						<option value="<%=nhanVien.getMaNV()%>"><%=nhanVien.getTenNV()%></option>
						<%
							}
						%>
					</select>
				</div>
			</div>
			<div class="row"></div>

			<div class="form-row button">
				<div class="form-group col-md-3">
					<a class="btn btn-danger" href="./DanhSachTrinhDoHV"
						style="margin-left: 15px;"> Về danh sách </a>
				</div>
				<div class="form-group col-md-3" style="padding-left: 40px;">
					<button type="submit" class="btn btn-primary "
						style="margin-left: 15px;">Thêm Học Vấn</button>
				</div>
				<div class="form-group col-md-3"></div>
				<div class="form-group col-md-3"></div>
			</div>
		</form>
	</div>
</div>
<!--END #main-->
  
<script>
		$(document).ready(function(){
			if(<%=session.getAttribute("title") != null%>){
			swal ( '<%=(String) session.getAttribute("title")%>','<%=(String) session.getAttribute("content")%>','<%=(String) session.getAttribute("type")%>
			')
		<%session.removeAttribute("title");%>
			
		<%session.removeAttribute("content");%>
			
		<%session.removeAttribute("type");%>
			}
						return false
					});
</script>
<script type="text/javascript">
    $(document).ready(function(){
        $("#form-insert").validate({
            rules:{
            	maHV:"required",
            	tenHV:"required",
            	nhanVien:"required"
            },
            messages:{
            	maCV:"Bạn vui lòng nhập vào trường dữ liệu này",
            	tenCV:"Bạn vui lòng nhập vào trường dữ liệu này",
            	nhanVien:"Bạn vui lòng nhập vào trường dữ liệu này"
            },
            errorClass: "my-error-class",
            validClass: "my-valid-class"
        });
    });
	
</script>
<style>
.form-row.button {
	margin-top: 50px;
	padding-left: 50%;
}
</style>
</body>
</html>

