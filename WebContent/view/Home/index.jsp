<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/view/template/Header.jsp"></jsp:include>
 	  <div id="main"><!-- Phần chứa nội dung chính -->
            <ol class="breadcrumb">
               <li><a href="index.html"><i class="fa fa-home"></i> Trang Chủ</a></li>
            </ol>
            <div class="col-xs-12">
               <div class="menu">
                  <a href="index.html" class="col-md-2 col-sm-5 col-xs-5">
                  <i class="fa fa-home"></i><br> <span>Trang Chủ </span>
                  </a>
                  <a href="./ThongTinCaNhan" class="col-md-2 col-sm-5 col-xs-5">
                  <i class="fa fa-user"></i><br> <span>Tài Khoản Cá Nhân</span>
                  </a>
                  
                  <a href="./DanhSachLuongCaNhanServlet" class="col-md-2 col-sm-5 col-xs-5">
                  <i class="fa fa-bars"></i><br> <span>Lương Cá Nhân</span>
                  </a>
                  <a href="contact.html" class="col-md-2 col-sm-5 col-xs-5">
                  <i class="fa fa-envelope-o"></i><br> <span>Phản hồi</span>
                  </a>
                  <a href="./logout" class="col-md-2 col-sm-5 col-xs-5">
                  <i class="fa fa-wrench"></i><br> <span>Đăng xuất</span>
                  </a>
               </div>
            </div>
         </div>
         <!--END #main-->
      </div>
   </body>
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
</html>
