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
                <input type="text" name="tenNV" class="form-control" required/>
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
                <lable class="form-check-label">Số điện thoại:</lable> <span id="loisdt" style="color:red"></span>
                <input type="number" id="sodienthoai"name="soDienThoai" onchange="checkSDT()" class="form-control" required />
                
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
                <input type="email" name="email" class="form-control" required />
            </div>
        <div class="form-group col-md-4">
                <lable class="form-check-label">Mật khẩu:</lable>
                <input type="password" id="matkhau"name="matTK" required class="form-control" />
            </div>
        <div class="form-group col-md-4">
             
                <lable class="form-check-label">Nhập lại Mật khẩu:</lable>
                <input type="password" id="nhaplaimatkhau" onchange="validatetrungmatkhau()" required name="nhaplaimatTK" class="form-control" />
                  <span id="loi" style="color:red"></span>
            </div>
        
        </div>
    
            <div class="form-group col-md-4">
                <input type="hidden" value="${maTaiKhoan}"  name="maTK" class="form-control" readonly="readonly" />
            </div>
        <div class="form-row">
        <div class="form-group col-md-3"><a class="btn btn-danger" href="./DanhSachNhanVienServlet"
                style="margin-left: 85px;"> Về Danh Sách </a></div>
        <div class="form-group col-md-3">    <button type="submit" value="submit" class="btn btn-primary "
                style="">Thêm Nhân Viên</button></div>
        
        </div>
              </div>
         </form>
      </div>
         </div>
         <!--END #main-->
      </div>
   </body>
    <script language="javascript">
      // Hàm show kết quả
      function validatetrungmatkhau()
      {
        var matkhau = document.getElementById("matkhau").value;
        var nhaplaimatkhau = document.getElementById("nhaplaimatkhau").value;
        if(matkhau!=nhaplaimatkhau){
            document.getElementById("loi").innerHTML="  Vui Lòng nhập lại mật khẩu cho trùng nhau  !!";
            document.getElementById("nhaplaimatkhau").value="";
        }
        
        else{
            document.getElementById("loi").innerHTML="";
        }
      }
      
      function checkSDT() {
    
            var vnf_regex = /((083|084|085|081|082|070|079|077|076|078|032|033|034|035|036|037|038|039|036|090|091|(84)+90|(84)+91)+([0-9]{7})\b)/g;
            var sdt =  document.getElementById("sodienthoai").value;
            var sdt = sdt.replace('(84)+','0')
            if(sdt !==''){
                if(sdt.length>10){
                    document.getElementById("loisdt").innerHTML="Số điện thoại sai định dạng !";
                }
                else if (vnf_regex.test(sdt) == false) 
                {
                    document.getElementById("loisdt").innerHTML="Số điện thoại sai định dạng  !";
                }
                else document.getElementById("loisdt").innerHTML="";
            }
        }

 

    </script>
</html>