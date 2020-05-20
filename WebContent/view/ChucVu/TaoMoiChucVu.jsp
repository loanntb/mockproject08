<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../template/Header.jsp"></jsp:include>
<div id="main">
<ol class="breadcrumb">
	<li><a href="./Home"><i class="fa fa-home"></i> Trang quản
			trị</a></li>
	<li class="active"><a href="./DanhSachHoatDong">chức vụ</a></li>
	<li class="active">Thêm Chức Vụ</li>
</ol>
<div class="col-xs-12">
	<form action="./ThemChucVu" id="form-insert" method="post" name="form1"
		onsubmit="return validateForm()" class=" col-xl-9 col-lg-10 col-md-12 col-sm-12">
		<div class="form-row">
			<div class="form-group col-md-6">
				<lable class="form-check-label">Mã chức vụ</lable>
				<input id="maCV" type="text" value="${maCV}" readonly="readonly" name="maCV" class="form-control"  />
			</div>
			<div class="form-group col-md-6">
				<lable class="form-check-label">Tên chức vụ</lable>
				<input  id="tenCV" type="text" name="tenCV" class="form-control" />
			</div>

		</div>
		<div class="form-row">
		<div class="form-group col-md-3"><a class="btn btn-danger" href="./DanhSachHoatDong"
				style="margin-left: 15px;"> Về danh sách </a></div>
		<div class="form-group col-md-3">	<button type="submit" class="btn btn-primary "
				style="margin-left: 15px;">Thêm chức vụ</button></div>
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
<script type="text/javascript">
    $(document).ready(function(){
        $("#userForm").validate({
            rules:{
                email:{
                    required: true,
                    email:true
                },

                fullname:"required",
                password:"required"
            },
            messages:{
                email:{
                    required: "Please enter email",
                    email: "Please enter an availd email address"
                },
                
                fullname:"Please enter fullname",
                password:"Please enter password"
            }
        });
    });
	
</script>
<script type="text/javascript">
    $(document).ready(function(){
        $("#form-insert").validate({
            rules:{

            	maCV:"required",
            	tenCV:"required"
            },
            messages:{
            	maCV:"Bạn vui lòng nhập vào trường dữ liệu này",
            	tenCV:"Bạn vui lòng nhập vào trường dữ liệu này"
            },
            errorClass: "my-error-class",
            validClass: "my-valid-class"
        });
    });
	
</script>

<style>
.btn {
	margin-bottom: 10px;
}
</style>
</body>
</html>

