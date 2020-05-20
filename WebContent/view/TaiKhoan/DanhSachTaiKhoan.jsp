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
         <form id="post_form" method="post" action="" role="form" >
            <div class="col-xs-12">
               <div class="form-group">
                  <!-- Single button -->
               </div>
               <script type="text/javascript" class="init">
               $(document).ready(function() {
            	    var table = $('#myTable').DataTable( {
            	    	 "lengthChange": false,
            	    	 "aoColumnDefs": [
            	    		    { "bSortable": false, "aTargets": [ "_all" ] } //disable ordering events and takeout the icon
            	    		   ],
            	    		   
            	    		"language": {
            	    			      "info": "Hiển thị  _START_ đến _END_ trên _TOTAL_ bản ghi",
            	    			    },
            	    		"language": {
            	    			        "emptyTable": "Không có dữ liệu."
            	    			      }
            	    } );
            	} );
               </script>
				 <script>
				$.extend(true, $.fn.dataTable.defaults.oLanguage.oPaginate, {
				    sNext: '<i class="fa fa-chevron-right" ></i>',
				    sPrevious: '<i class="fa fa-chevron-left" ></i>'
				});
				</script>
               
               <table   id="myTable" class="table table-bordered table-hover">
                  <thead>
                     <tr>
                        <th>Mã Tài khoản</th>
                        <th>Email</th>
                        <th class="hidden-xs" style=" text-align: center !important;">Mật khẩu</th>
                        <th class="hidden-xs">Quyền truy cập</th>
                        <th class="hidden-xs">Sửa</th>
                     </tr>
                  </thead>
                  <tbody>
                
                   <c:forEach var="taikhoan" items="${DanhSachTaiKhoan}">
                  <%-- 	${taikhoan.getListddanhsachtaikkhoan()  gọi hẳn hàm get--%>
                        <td class="hidden-xs">${taikhoan.MaTaiKhoan}</td>
                        <td class="hidden-xs">${taikhoan.Email}</td>
                         <td class="hidden-xs">${taikhoan.Matkhau}</td>
                         <td class="hidden-xs" style=" text-align: center !important;">${taikhoan.Phanquyen}</td>
                        <td>
                        	<c:set value="${taikhoan.Phanquyen}" var="giatri"></c:set>  
						
							<c:choose>
								<c:when test="${giatri==0}">
								<a class="btn btn-submit" disabled >Sửa</a>
								</c:when>
								<c:otherwise>
							   <a class="btn btn-submit" href="./ThongTinSuaTaiKhoan?maTK=${taikhoan.MaTaiKhoan}">Sửa</a>
								</c:otherwise>
							</c:choose>
                        </td>
                      
						
                      
                     </tr>
                   </c:forEach>
                  </tbody>
               </table>
            </div>
         </form>
      </div>
         </div>
        
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
         <!--END #main-->
      </div>
   </body>
</html>