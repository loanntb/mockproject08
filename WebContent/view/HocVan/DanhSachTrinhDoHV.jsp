<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../template/Header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<div id="main">
            <ol class="breadcrumb">
         <li><a href="./Home"><i class="fa fa-home"></i> Trang quản trị</a></li>
         <li class="active">Trình độ Học Vấn</li>
      </ol>
      <div class="col-xs-12">
         <form id="post_form" method="post" action="" role="form" >
            <div class="col-xs-12">
               <div class="form-group">
                  <!-- Single button -->
                  <div class="btn-group">
                     <select id="task" name="task" class="form-control">
                        <option>Tác vụ</option>
                        <option value="delete">Xóa</option>
                        <option value="deactive">Ẩn</option>
                        <option value="active">Hiện</option>
                     </select>
                  </div>
                  <a href="./GoiTaoTrinhDoHocVan" class="btn btn-submit"><small><i class="fa fa-plus"></i></small> Thêm mới</a>
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
                        <th>Mã Trình độ Học Vấn</th>
                        <th>Tên Trình độ Học Vấn</th>
                 		<th>Mã nhân viên</th>
                        <th>Sửa</th>
                        <th>Xóa</th>
                       
                     </tr>
                  </thead>
                  <tbody>
                  	<c:forEach var="hv" items="${DanhSachHV}">
                     <tr>
                     <%-- 	${hoatdong.getSLToiThieuYC()  gọi hẳn hàm get--%>
                        <td >${hv.getMaHV()}</td>
                        <td class="hidden-xs">${hv.getTenHV()}</td>
                         <td class="hidden-xs">${hv.getMaNV()}</td>
                        <td>
                        <a href="./CallCapNhatTrinhDoHV?id=${hv.getMaHV()}">
                        <i class="fa fa-edit" data-toggle="tooltip" data-placement="top" title="Sửa Trình độ Học Vấn"></i>
                        </a>
                        </td>
                        <td>
                        <a href="./XoaTrinhDoHV?id=${hv.getMaHV()} ">
                           <i class="fa fa-times text-danger" data-toggle="tooltip" data-placement="top" title="Xóa Trình độ Học Vấn"></i>
                         </a>
                        </td>
                     </tr>
                     </c:forEach>
                  </tbody>
               </table>
               <p><strong><i class="fa fa-bookmark"></i>Ghi chú: </strong></p>
                <p class="note-items"><i class="glyphicon glyphicon-sort-by-attributes"></i>     Sắp xếp theo CSDL</p>
               <p class="note-items"><i class="fa fa-edit text-success"></i> Chỉnh sửa Trình độ Học Vấn.</p>
               <p class="note-items"><i class="fa fa-times text-danger"></i> Xóa Trình độ Học Vấn</p>
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