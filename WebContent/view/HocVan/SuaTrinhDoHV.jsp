<%@ page import="model.bean.NhanVien"%>
<%@ page import="model.bean.HocVan"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../template/Header.jsp"></jsp:include>
<div id="main">
	<ol class="breadcrumb">
		<li><a href="./Home"><i class="fa fa-home"></i> Trang quản
				trị</a></li>
		<li class="active"><a href="./DanhSachTrinhDoHV">Học Vấn</a></li>
		<li class="active">Chỉnh sửa trình độ học Vấn</li>
	</ol>
	<div class="col-xs-12">
		<%
			HocVan listHocVan = (HocVan) request.getAttribute("listHocVan");
		%>
		<form action="./CapNhatTrinhDoHV" method="post" name="form1"
			class=" col-xl-9 col-lg-10 col-md-12 col-sm-12">
			<div class="form-row">
				<div class="form-group col-md-6">
					<lable class="form-check-label">Mã trình độ học vấn</lable>
					<input type="text" name="maHV" class="form-control"
						value="<%=listHocVan.getMaHV()%>" readonly="readonly" />

				</div>
				<div class="form-group col-md-6">
					<lable class="form-check-label">Tên trình độ học vấn</lable>
					<input type="text" name="tenHV" class="form-control"
						value="<%=listHocVan.getTenHV()%>" />
				</div>

			</div>
			<div class="form-group">
				<div class="col-lg-6">
					<lable class="form-check-label">Tên nhân viên</lable>
					<select class="form-control" name="nhanVien">
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
				<div class="form-group col-md-3">
					<button type="submit" class="btn btn-primary "
						style="padding-left: 40px;">Cập nhật học vấn</button>
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
			if(<%= session.getAttribute("title")!= null %>){
			swal ( '<%= (String)session.getAttribute("title")%>','<%= (String)session.getAttribute("content")%>','<%= (String)session.getAttribute("type")%>')
			<%session.removeAttribute("title");%>
			<%session.removeAttribute("content");%>
			<%session.removeAttribute("type");%>
			}
			return false
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

