<%@ page import="model.bean.ChucVu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.bean.ChucVu"%>
<jsp:include page="../template/Header.jsp"></jsp:include>
<div id="main">
	<ol class="breadcrumb">
		<li><a href="./Home"><i class="fa fa-home"></i> Trang quản
				trị</a></li>
		<li class="active"><a href="./DanhSachChucVu">Chức Vụ</a></li>
		<li class="active">Chỉnh Sửa Chức Vụ</li>
	</ol>
	<div class="col-xs-12">
		<%
			ChucVu chucVu = (ChucVu) request.getAttribute("ChucVu");
		%>
		<form action="./CapNhatChucVu" method="post" name="form1"
			onsubmit="return validateForm()"
			class=" col-xl-9 col-lg-10 col-md-12 col-sm-12">
			<div class="form-row">
				<div class="form-group col-md-6">
					<lable class="form-check-label">Mã Chức Vụ</lable>
					<input type="text" name="maCV" class="form-control"
						value="<%=chucVu.getMaCV()%>" readonly="readonly" />

				</div>
				<div class="form-group col-md-6">
					<lable class="form-check-label">Tên Chức Vụ</lable>
					<input type="text" name="tenCV" class="form-control"
						value="<%=chucVu.getTenCV()%>" />
				</div>

			</div>


			<div class="form-row">
				<div class="form-group col-md-3">
					<a class="btn btn-danger" href="./DanhSachChucVu"
						style="margin-left: 15px;"> Về danh sách </a>
				</div>
				<div class="form-group col-md-3">
					<button type="submit" class="btn btn-primary "
						style="margin-left: 15px;">Cập Nhật</button>
				</div>
				<div class="form-group col-md-3"></div>
				<div class="form-group col-md-3"></div>
			</div>
		</form>
	</div>
</div>
<!--END #main-->
<script type="text/javascript">
	$(function() {
		$('.datetimepicker1').datetimepicker({
			format : 'YYYY-MM-DD HH:mm'
		});
	});
</script>
		
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
.btn {
	margin-bottom: 10px;
}
</style>
</body>
</html>

