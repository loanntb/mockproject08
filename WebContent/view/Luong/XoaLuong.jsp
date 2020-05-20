<%@page import="model.bean.Luong"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../template/Header.jsp"></jsp:include>
<div id="main">
<ol class="breadcrumb">
	<li><a href="./Home"><i class="fa fa-home"></i> Trang quản
			trị</a></li>
	<li class="active"><a href="DanhSachLuongServlet">Danh Sách Lương</a></li>
	<li class="active">Xóa Lương</li>
</ol>
<div class="col-xs-12">
	<form action="XoaLuongServlet" method="post" name="form1" class=" col-xl-9 col-lg-10 col-md-12 col-sm-12">
		<%
			Luong luong = (Luong)request.getAttribute("listluong");
         %>
		<div class="form-row">
			<div class="form-group col-md-4">
				<lable class="form-check-label">Mã lương</lable>
				<input type="text" name="maLuong" class="form-control" readonly="readonly" autocomplete="off" value="<%= luong.getMaLuong() %>" />
			</div>
		</div>	
		<div class="form-row">
		<div class="form-group col-md-3"><a class="btn btn-danger" href="DanhSachLuongServlet"
				style="margin-left: 15px;"> Về danh sách </a></div>
		<div class="form-group col-md-3">	<button type="submit" class="btn btn-primary "
				style="margin-left: 15px;">Xóa Lương</button></div>
		<div class="form-group col-md-3"></div>
		<div class="form-group col-md-3"></div>
		</div>
	</form>
</div>
</div>
<!--END #main-->
<script type="text/javascript">
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

