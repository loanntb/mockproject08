<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../template/Header.jsp"></jsp:include>
<div id="main">
<ol class="breadcrumb">
    <li><a href="./Home"><i class="fa fa-home"></i> Trang quản
            trị</a></li>
    <li class="active"><a href="./DanhSachPhongBan">Phòng ban</a></li>
    <li class="active">Thêm phòng ban</li>
</ol>
<div class="col-xs-12">
    <form action="./ThemPhongBan" method="post" name="form1"
        class=" col-xl-9 col-lg-10 col-md-12 col-sm-12">
        <div class="form-row">
            <div class="form-group col-md-4">
                <lable class="form-check-label">Mã phòng ban</lable>
                <input type="text" name="maPB" value="${maPB}" readonly="readonly"   class="form-control" />
            </div>
            <div class="form-group col-md-8">
                <lable class="form-check-label">Tên phòng ban</lable>
                <input type="text" name="TenPB" class="form-control" />
            </div>
       
        </div>
        <div class = "form-row">
 				<div class="form-group col-md-4">
                <lable class="form-check-label">Số điện thoại</lable>
                <input type="text" name="SoDT" class="form-control" />
            </div>
            <div class="form-group col-md-8">
                <lable class="form-check-label">Vị trí</lable>
                <input type="text" name="ViTri" class="form-control" />
            </div>       
        </div>

        <div class="form-row">
        <div class="form-group col-md-3"><a class="btn btn-danger" href="./DanhSachPhongBan"
                style="margin-left: 15px;"> Về danh sách </a></div>
        <div class="form-group col-md-3">    <button type="submit" class="btn btn-primary "
                style="margin-left: 15px;">Thêm phòng ban</button></div>
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
.btn {
    margin-bottom: 10px;
}
</style>
</body>
</html>