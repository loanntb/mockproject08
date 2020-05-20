<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="model.bean.PhongBan"%>
<jsp:include page="../template/Header.jsp"></jsp:include>
<div id="main">
<ol class="breadcrumb">
	<li><a href="./Home"><i class="fa fa-home"></i> Trang quản
			trị</a></li>
	<li class="active"><a href="./DanhSacPhongBan">Hoạt Động</a></li>
	<li class="active">Chỉnh Sửa Hoạt Động</li>
</ol>
<div class="col-xs-12">
<%PhongBan phongban = (PhongBan) request.getAttribute("phongban");%>
	<form action="./SuaPhongBan" method="post">
			<div class="form-row">
						<div class="form-group col-md-4">
							<lable class="form-check-label">Mã phòng ban</lable>
							<input type="text" name="maPB" class="form-control"  value="${phongban.maPB}"/>
							
						</div>
						<div class="form-group col-md-8">
							<lable class="form-check-label">Tên phòng ban</lable>
							<input type="text" name="TenPB" class="form-control" value="${phongban.tenPB}" />
						</div>

					</div>
			<div class="form-row">
						<div class="form-group col-md-4">
							<lable class="form-check-label">Số điện thoại</lable>
							<input type="text" name="SoDT" class="form-control"  value="${phongban.soDT}"/>
							
						</div>
						<div class="form-group col-md-8">
							<lable class="form-check-label">Vị vị phòng ban</lable>
							<input type="text" name="ViTri" class="form-control" value="${phongban.viTri}" />
						</div>

					</div>
					
					
				
		

		<div class="form-row">
		<div class="form-group col-md-3"><a class="btn btn-danger" href="./DanhSachPhongBan"
				style="margin-left: 15px;"> Về danh sách </a></div>
		<div class="form-group col-md-3">	<button type="submit" class="btn btn-primary "
				style="margin-left: 15px;">Cập Nhật</button></div>
		<div class="form-group col-md-3"></div>
		<div class="form-group col-md-3"></div>
		</div>
	</form>
</div>
</div>
<!--END #main-->

<script>
		$(document).ready(function(){
			if(<%= session.getAttribute("content")!= null %>){
			swal ( '<%= (String)session.getAttribute("title")%>','<%= (String)session.getAttribute("content")%>','<%= (String)session.getAttribute("type")%>')
			<%session.removeAttribute("title");%>
			<%session.removeAttribute("content");%>
			<%session.removeAttribute("type");%>
			}
			return false
				});
			</script>

<style>
.btn {
	margin-bottom: 10px;
}
</style>
</body>
</html>

