<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="model.bean.Luong"%>
	<%@page import="model.bean.NhanVien"%>
	<%@page import="java.util.ArrayList"%>
<jsp:include page="../template/Header.jsp"></jsp:include>
<div id="main">
<ol class="breadcrumb">
	<li><a href="./Home"><i class="fa fa-home"></i> Trang quản
			trị</a></li>
	<li class="active"><a href="DanhSachLuongServlet">Lương</a></li>
	<li class="active">Chỉnh Sửa Lương</li>
</ol>
<div class="col-xs-12">
	<form action="SuaLuongServlet" method="post" id="form-update" name="form1"
		onsubmit="return validateForm()" class=" col-xl-9 col-lg-10 col-md-12 col-sm-12">
					<%
					Luong luong = (Luong)request.getAttribute("listluong");
                    %>
			<div class="form-row">
						<div class="form-group col-md-4">
							<lable class="form-check-label">Mã lương</lable>
							<input type="text" name="maLuong" class="form-control" readonly="readonly" autocomplete="off" value="<%= luong.getMaLuong() %>" />
						</div>
						<div class="form-group col-md-8">
							<lable class="form-check-label">Tên nhân viên</lable>
							<select class="form-control" name="maNV">
		                    <option value="<%= luong.getMaNV() %>"><%= luong.getTenNV() %></option>
               			 </select>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-4">
							<lable class="form-check-label">Hệ số lương</lable>
							<input type="number" name="hesoLuong" class="form-control" autocomplete="off" value="<%= luong.getHeSL() %>" />
						</div>
						<div class="form-group col-md-4">
							<lable class="form-check-label">Lương cơ bản</lable>
							<input type="number" name="LuongCB" class="form-control" autocomplete="off" value="<%= luong.getLuongCB() %>" />
						</div>
						<div class="form-group col-md-4">
							<lable class="form-check-label">Phụ cấp</lable>
							<input type="number" name="phuCap" class="form-control" autocomplete="off" value="<%= luong.getPhuCap() %>" />
						</div>
					</div>
		<div class="form-row">
		<div class="form-group col-md-3"><a class="btn btn-danger" href="DanhSachLuongServlet"
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
<script type="text/javascript">
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
});
</script>
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
.my-error-class {
color:#FF0000;  /* red */
}
.my-valid-class {
    color:rgb(10, 186, 255); /* green */
}
</style>
</body>
</html>

