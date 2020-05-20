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
                
                  <a href="./ThongTinThemMoiNhanVien" class="btn btn-submit"><small><i class="fa fa-plus"></i></small> Thêm mới</a>
                    <a href="./DanhSachNhanVienDaXoa" class="btn btn-submit"><small><i class="fa fa-times text-danger"></i></small> Danh Sách nhân viên đã xoá</a>
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
                         <!-- <th  class="hidden-xs">Trạng Thái</th> -->
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
                     <c:set var="url" value="images/${nhanvien.Anh}"></c:set>
                        <td ><img style="width:60px;height:60px" src="${url}"/></td>
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
                        <td class="hidden-sm hidden-xs">${fn:substring(nhanvien.NgayDangKy,0,16)}</td>
                        <td class="hidden-xs">${fn:substring(nhanvien.NgayUpdate,0,16)}</td>
                    <%--      <td class="hidden-xs">${nhanvien.TrangThai}</td> --%>
                        <td class="hidden-xs">${nhanvien.TenPB}</td>
                         <td class="hidden-xs">${nhanvien.TenCV}</td>
                        <td>
                        <a href="ThongTinSuaNhanVien?maNV=${nhanvien.MaNV}">
                        <i class="fa fa-edit" data-toggle="tooltip" data-placement="top" title="Sửa nhân viên"></i>
                        </a>
                         <a href="XoaNhanVien?maNV=${nhanvien.MaNV}">
                        <i class="fa fa-times text-danger" data-toggle="tooltip" data-placement="top" title="Xoá nhân viên"></i>
                        </a>
                        </td>
                      
                     </tr>
                   </c:forEach>
                  </tbody>
               </table>
               <span><strong><i class="fa fa-bookmark"></i>Ghi chú: </strong></span> 
               &nbsp; &nbsp; &nbsp; <span class="note-items"><i class="glyphicon glyphicon-sort-by-attributes"></i>Sắp xếp theo CSDL</span>
               &nbsp; &nbsp; &nbsp;<span class="note-items"><i class="fa fa-edit text-success"></i> Sửa nhân viên.</span>
               &nbsp; &nbsp; &nbsp; <span class="note-items"><i class="fa fa-times text-danger"></i> Xoá nhân viên</span>
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
			<%request.removeAttribute("content");%>
			}
			return false
				});
			</script>
         <!--END #main-->
      </div>
   </body>
</html>