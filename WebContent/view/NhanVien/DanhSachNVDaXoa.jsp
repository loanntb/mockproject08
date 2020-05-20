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
                 <a  onclick="goBack()" class="btn btn-submit">Quay về danh sách nhân viên</a>
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
               
               <table  style="margin-top:-30px" id="myTable" class="table table-bordered table-hover">
                  <thead>
                     <tr>
                        <th>Mã NV</th>
                        <th>Tên NV</th>
                        <th class="hidden-xs" style=" text-align: center !important;">Ảnh</th>
                        <th class="hidden-xs"style=" text-align: center !important;">Ngày Sinh</th>
                        <th class="hidden-xs">Giới tính</th>
                        <th class="hidden-sm hidden-xs">Điện thoại</th>
                        <th class="hidden-sm hidden-xs">Email</th>
                        <th  class="hidden-xs">Địa chỉ</th>
                        <th  class="hidden-xs">Ngày ĐK</th>
                        <th  class="hidden-xs">Ngày Update</th>
                        <th  class="hidden-xs">Phòng ban</th>
                        <th  class="hidden-xs">Chức vụ</th>
                        <th  class="hidden-xs">Thao tác</th>
                     </tr>
                  </thead>
                  <tbody>
                
                   <c:forEach var="nhanvien" items="${DanhSachNhanVien}">
                  <%-- 	${nhanvien.getListNhanVien()  gọi hẳn hàm get--%>
                        <td class="hidden-xs">${nhanvien.MaNV}</td>
                        <td class="hidden-xs">${nhanvien.TenNV}</td>
                        <td class="hidden-xs">${nhanvien.Anh}</td>
                        <td class="hidden-xs">${fn:substring(nhanvien.NgaySinh,0,10)}</td>
                       <c:choose>
								<c:when test="${nhanvien.GioiTinh== 1}">
									  <td class="hidden-xs">Nam</td>
								</c:when>
								<c:otherwise>
									     <td class="hidden-xs">Nữ</td>
								</c:otherwise>
							</c:choose>
                        <td class="hidden-xs">${nhanvien.DienThoai}</td>
                        <td class="hidden-xs">${nhanvien.Email}</td>
                        <td class="hidden-sm hidden-xs">${nhanvien.Diachi}</td>
                        <td class="hidden-sm hidden-xs">${nhanvien.NgayDangKy}</td>
                        <td class="hidden-xs">${nhanvien.NgayUpdate}</td>
                        <td class="hidden-xs">${nhanvien.TenPB}</td>
                         <td class="hidden-xs">${nhanvien.TenCV}</td>
                        <td>
                           <a href="PhucHoiNhanVienServlet?maNV=${nhanvien.MaNV}" class="btn btn-submit"> Phục hồi</a>
                      
                       
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
			if(<%= session.getAttribute("content")!= null %>){
			swal ( '<%= (String)session.getAttribute("title")%>','<%= (String)session.getAttribute("content")%>','<%= (String)session.getAttribute("type")%>')
			<%session.removeAttribute("title");%>
			<%session.removeAttribute("content");%>
			<%session.removeAttribute("type");%>
			}
			return false
				});
			</script>
         <!--END #main-->
           <script>
	function goBack() {
	  window.history.back();
	}
	</script>
      </div>
   </body>
</html>