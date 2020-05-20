<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.bean.NhanVien"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <base href=".">
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Quản trị hệ thống</title>
      <link rel="shortcut icon" href="favicon.png">
      <link href="view/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="view/resources/css/font-awesome.min.css" rel="stylesheet">
      <link href="view/resources/css/admin.css" rel="stylesheet">
      <link href="view/resources/css/introjs.min.css" rel="stylesheet">
      <script type="text/javascript" src="view/resources/js/jquery-3.3.1.js"></script>
      <script type="text/javascript" src="view/resources/js/bootstrap.min.js"></script>
      <script type="text/javascript" src="view/resources/js/intro.min.js"></script>
	  <script type="text/javascript" src="view/resources/js/jquery.validate.min.js"></script>
      <script type="text/javascript" src="view/resources/js/admin.js"></script>
      <script src="view/resources/ckeditor/ckeditor.js"></script>
      <script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  <!-- use datetimepicker -->
      <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.15.1/moment.min.js"></script>
      <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/css/bootstrap-datetimepicker.min.css"> 
      <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/css/bootstrap-datetimepicker-standalone.css"> 
      <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/js/bootstrap-datetimepicker.min.js"></script>
	  <!-- -->
	  <!-- use datatable -->
	  <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
	  <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap.min.js"></script>
	  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap.min.css">
	  <link rel="stylesheet" href="https://cdn.datatables.net/fixedheader/3.1.6/css/fixedHeader.bootstrap.min.css">
	  
	  <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.3.1/js/dataTables.buttons.min.js"></script> 
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.html5.min.js"></script>
	
   </head>
   <body>
      <nav class="navbar navbar-inverse" role="navigation">
         <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="./Home"><i class="fa fa-cogs"></i> Quản Lý Nhân Viên</a>
         </div>
         <!-- Collect the nav links, forms, and other content for toggling -->
         <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
               <li class="dropdown">
               
		
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>${TenNV}</b><b class="caret"></b></a>
                  <ul class="dropdown-menu">
                     <li><a href="./ThongTinCaNhan"><i class="fa fa-user"></i> Chỉnh sửa tài khoản</a></li>
                     <li><a href="./logout"><i class="fa fa-power-off"></i> Đăng xuất</a></li>
                  </ul>
               </li>
            </ul>
         </div>
         <!-- /.navbar-collapse -->
      </nav>
      
     <jsp:include page="/view/template/menu.jsp"></jsp:include>
      