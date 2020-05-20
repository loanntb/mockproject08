<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../template/Header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<div id="main">
            <ol class="breadcrumb">
         <li><a href="./Home"><i class="fa fa-home"></i> Trang quản trị</a></li>
         <li class="active">Nhân Viên</li>
      </ol>
      <div class="col-xs-12">
         <form  method="post" action="ThemMoiNhanVien" role="form" >
            <div class="col-xs-12">
                <div class="form-row">
			<div class="form-group col-md-6">
				<lable class="form-check-label">Mã Nhân viên:</lable>
				<input type="text" value="${maMay}"  name="maNV" class="form-control" readonly="readonly" />
			</div>
			<div class="form-group col-md-6">
				<lable class="form-check-label">Tên Nhân viên:</lable>
				<input type="text" name="tenNV" class="form-control" />
			</div>
		</div>
		<div class="form-row">
		   <div class="form-group col-md-6">
				<lable class="form-check-label">Giới tính:</lable>
				<select class="form-control" id="goiTinh" name="gioiTinh">
            	<option value="1">Nam</option>
            	<option value="0">Nữ</option>
			</select>
			</div>
			 <div class="form-group col-md-6">
				<lable class="form-check-label">Ngày sinh:</lable>
					<input type='date' class="form-control" name="ngaySinh" />
			</div>
		</div>
		
		
		  <div class="form-row">
		  <div class="form-group col-md-6">
			<lable class="form-check-label">Chức vụ:</lable>
			<select class="form-control" id="maCV" name="maCV">
			<c:forEach var="chucvu" items="${DanhSachCV}">
            	<option value="${chucvu.MaCV}">${chucvu.TenCV}</option>
          </c:forEach>				    
			</select>
		</div>
		
			<div class="form-group col-md-6">
				<lable class="form-check-label">Địa chỉ:</lable>
				<input type="text" name="diaChi" class="form-control" />
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<lable class="form-check-label">Số điện thoại:</lable>
				<input type="number" name="soDienThoai" class="form-control" />
			</div>
			<div class="form-group col-md-6">
			<lable class="form-check-label">Phòng ban:</lable>
			<select class="form-control" id="maPB" name="maPB">
			<c:forEach var="phongban" items="${DanhSachPB}">
            	<option value="${phongban.MaPB}">${phongban.TenPB}</option>
          </c:forEach>				    
			</select>
		</div>
		</div>
		
			<div class="form-row">
			<div class="form-group col-md-4">
				<lable class="form-check-label">Email:</lable>
				<input type="email" name="email" class="form-control" />
			</div>
		<div class="form-group col-md-4">
				<lable class="form-check-label">Mật khẩu:</lable>
				<input type="password" name="matTK" class="form-control" />
			</div>
		<div class="form-group col-md-4">
				<lable class="form-check-label">Nhập lại Mật khẩu:</lable>
				<input type="password" name="nhaplaimatTK" class="form-control" />
			</div>
		
		</div>
	
            <div class="form-group col-md-4">
				<input type="hidden" value="${maTaiKhoan}"  name="maTK" class="form-control" readonly="readonly" />
			</div>
		<div class="form-row">
		<div class="form-group col-md-3"><a class="btn btn-danger" href="./DanhSachNhanVienServlet"
				style="margin-left: 85px;"> Về Danh Sách </a></div>
		<div class="form-group col-md-3">	<button type="submit" value="submit" class="btn btn-primary "
				style="">Thêm Nhân Viên</button></div>
		
		</div>
              </div>
         </form>
      </div>
         </div>
         <!--END #main-->
      </div>
   </body>
    
</html>