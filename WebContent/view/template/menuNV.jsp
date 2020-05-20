<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="clearfix">
         <div id="sidebar-bg"></div>
         <div id="sidebar" role="navigation">
            <div class="panel panel-default">
               <div class="panel-heading">
                  <h3 class="panel-title">
                     <i class="fa fa-th"></i><span> Danh mục quản lý</span>
                     <b class="fa fa-plus-sign visible-xs pull-right"></b>
                  </h3>
               </div>
               <ul id="menu" class="list-group">
                  <li class="list-group-item">
                     <a href="./ThongTinCaNhan">
                     <i class="fa fa-user"></i> <span>Tài Khoản</span>
                     </a>
                  </li>
                  <li class="list-group-item">
                     <a href="./DanhSachLuongCaNhanServlet">
                     <i class="fa fa-bars"></i> <span>Quản Lý Lương</span>
                     </a>
                  </li>
                  <li class="list-group-item">
                     <a href="./logout">
                     <i class="fa fa-wrench"></i> <span>Đăng Xuất</span>
                     </a>
                  </li>
               </ul>
            </div>
         </div>