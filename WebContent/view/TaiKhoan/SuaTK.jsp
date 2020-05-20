<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../template/Header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div id="main">
	<ol class="breadcrumb">
		<li><a href="./Home"><i class="fa fa-home"></i> Trang quản
				trị</a></li>
		<li class="active">Tài khoản</li>
	</ol>
		 <div class="form-group col-md-12">
	<div class="col-xs-3">
	</div>
	<div class="col-xs-6">
		<form method="post" action="SuaTaiKhoan?maTK=${taiKhoan.maTaiKhoan}" role="form">
		      	<input type="hidden" name="maTK" value="${taiKhoan.maTaiKhoan}" class="form-control" />
			
			<div class="col-xs-12">
				<div class="form-row">
					<div class="form-group col-md-12">
						<lable class="form-check-label">Email Tài khoản:</lable>
						<input type="text" name="email" value="${taiKhoan.email}" class="form-control" />
					</div>
					
				</div>
				
				<div class="form-row">
					<div class="form-group col-md-12">
						<lable class="form-check-label">Mật khẩu:</lable>
						<input type="text" name="matKhau" value="${taiKhoan.matkhau}" class="form-control" />
					</div>
					

				</div>
				
				<div class="form-row">
					<div class="form-group col-md-12">
						<lable class="form-check-label">Phân quyền:</lable>
						<c:set value="${taiKhoan.phanQuyen}" var="giatri"></c:set>  
						<select class="form-control" id="phanQuyen" name="phanQuyen">
							<c:choose>
								<c:when test="${giatri==1}">
									<option selected value="1">Nhân viên</option>
									 <option  value="0">Admin</option>
								</c:when>
								<c:otherwise>
									    <option selected value="0">Admin</option>
									   <option  value="1">Nhân viên</option>
								</c:otherwise>
							</c:choose>
						</select>
					</div>
					

				</div>
				<div class="form-row"> 
					<div class="form-group col-md-3">
						<a class="btn btn-danger" href="DanhSachTaiKhoanServlet"
							style="margin-left: 65px;"> Về Danh Sách tài khoản </a>
					</div> 
					<div class="form-group col-md-3">
						<button type="submit" value="submit" name="submit"class="btn btn-primary "
							style="margin-left: 125px;">Cập nhật tài khoản</button>
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