<%@page import="model.bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../template/Header.jsp"></jsp:include>
<div id="main">
<ol class="breadcrumb">
	<li><a href="./Home"><i class="fa fa-home"></i> Trang quản
			trị</a></li>
	<li class="active"><a href="DanhSachLuongServlet">Danh Sách Lương</a></li>
	<li class="active">Thêm Lương</li> 
</ol>
<div class="col-xs-12">
	<form action="ThemLuongServlet" method="post" id="form-insert" name="form1" class=" col-xl-9 col-lg-10 col-md-12 col-sm-12">
		<div class="form-row">
			<div class="form-group col-md-4">
				<lable class="form-check-label">Mã lương</lable>
				<input type="text" name="maLuong"value="${maLuong}" class="form-control" autocomplete="off" readonly/>
			</div>
			<div class="form-group col-md-8">
				<lable class="form-check-label">Tên nhân viên</lable>
				<select class="form-control" name="maNV">
                    <%
                    	ArrayList<NhanVien> listNV = (ArrayList<NhanVien>)request.getAttribute("listNhanVien");
                    	for(NhanVien nhanvien:listNV){
                    %>
                    <option value="<%= nhanvien.getMaNV() %>"><%= nhanvien.getTenNV() %></option>
                    <%
                    	}
                    %>
                </select>
			</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-4">
					<lable class="form-check-label">Hệ số lương</lable>
					<input type="number" id="hesoLuong_i" name="hesoLuong" class="form-control" autocomplete="off" />
					<span class="text-danger" id="error"></span>
				</div>
				<div class="form-group col-md-4">
					<lable class="form-check-label">Lương cơ bản</lable>
					<input type="number" name="LuongCB" class="form-control" autocomplete="off" />
				</div>
				<div class="form-group col-md-4">
					<lable class="form-check-label">Phụ cấp</lable>
					<input type="number" name="phuCap" class="form-control" autocomplete="off" />
				</div>
			</div>
		<div class="form-row">
		<div class="form-group col-md-3"><a class="btn btn-danger" href="DanhSachLuongServlet"
				style="margin-left: 15px;"> Về danh sách </a></div>
		<div class="form-group col-md-3">	<button type="submit" class="btn btn-primary "
				style="margin-left: 15px;">Thêm Lương</button></div>
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
		$(document).ready(function(){
		    $("#form-insert").validate({
		        rules: {
		        	maLuong: {
		                required: true,
		            },
		            hesoLuong: {
		                required: true,
		            },
		            LuongCB: {
		                required: true,
		            },
		            phuCap: {
		                required: true,
		            },
		        },
		        messages: {
		        	maLuong:
		            {
		                required: "Bạn vui lòng nhập vào trường dữ liệu này"
		            },
		            hesoLuong:
		            {
		                required: "Bạn vui lòng nhập vào trường dữ liệu này"
		            },
		            LuongCB:
		            {
		                required: "Bạn vui lòng nhập vào trường dữ liệu này"
		            },
		            phuCap:
		            {
		                required: "Bạn vui lòng nhập vào trường dữ liệu này",
		            },
		        },
		        errorClass: "my-error-class",
		        validClass: "my-valid-class"
		    });
		    $(document).change("#hesoLuong_i",function(){
		    	if($("#hesoLuong_i").val() > 8 || $("#hesoLuong_i").val() <= 0){
		    		$("#error").show();
		    		$("#error").text("Hệ số lương chưa đúng vui lòng nhập lại !");
		    	}else{
		    		$("#error").hide();
		    	}
		    });
		});
</script>

<style>
.btn {
	margin-bottom: 10px;
}
.my-error-class {
color:#FF0000;  /* red */
}
.my-valid-class {
    color:rgb(10, 186, 255); /* green */
}
</style>
</body>
</html>

