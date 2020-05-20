<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.bean.Luong"%>
<%@page import="model.bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="../template/Header.jsp"></jsp:include>
<div id="main">
            <ol class="breadcrumb">
         <li><a href="./Home"><i class="fa fa-home"></i> Trang quản trị</a></li>
         <li class="active">Danh sách lương</li>
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
                  <a href="CallTaoLuongServlet" class="btn btn-submit"><small><i class="fa fa-plus"></i></small> Thêm mới</a>
                  <a href="DanhSachHoiPhuc" class="btn btn-primary"><small></small><i class="fa fa-bars" aria-hidden="true"></i> Danh sách hồi phục</a>
               	  <a href="DaThanhToanServlet" class="btn btn-info"> Lương đã thanh toán</a>
                  <a href="ChuaThanhToanServlet" class="btn btn-warning"> Lương chưa thanh toán</a>
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
                                      },
                                      dom: 'Bfrtip',
                                      buttons: [{
                                        extend: "excel",
                                        className: "btn btn-success",
                                        titleAttr: 'Export in Excel',
                                        text: 'Excel',
                                        init: function(api, node, config) {
                                           $(node).removeClass('dt-button')
                                        }
                                      }]
                    } );
                } );
               </script>
				 <script>
				$.extend(true, $.fn.dataTable.defaults.oLanguage.oPaginate, {
				    sNext: '<i class="fa fa-chevron-right" ></i>',
				    sPrevious: '<i class="fa fa-chevron-left" ></i>'
				});
				</script>
               
               <table id="myTable" class="table table-bordered table-hover myTable">
                  <thead>
                     <tr>
                        <th>Mã lương</th>
                        <th>Mã nhân viên</th>
                        <th>Tên nhân viên</th>
                        <th>Hệ số lương</th>
                        <th>Lương cơ bản</th>
                        <th>Phụ cấp</th>
                        <th>Sửa</th>
                        <th>Xóa</th>
                       
                     </tr>
                  </thead>
                  <tbody>
                   <% ArrayList<Luong> list = (ArrayList<Luong>)request.getAttribute("list");
                               		for(int i = 0; i < list.size() ; i++){
                    %>
                     <tr>
                        <td><%= list.get(i).getMaLuong() %></td>
                        <td><%= list.get(i).getMaNV() %></td>
                        <td><%= list.get(i).getTenNV() %></td>
                        <td><%= list.get(i).getHeSL() %></td>
                        <td><%= list.get(i).getLuongCB() %></td>
                        <td><%= list.get(i).getPhuCap() %></td>
                        <td>
                        <a href="SuaLuongServlet?maLuong=<%=list.get(i).getMaLuong() %>">
                        <i class="fa fa-edit text-success" data-toggle="tooltip" data-placement="top" title="Sửa lương nhân viên"></i>
                        </a>
                        </td>
                        <td>
                        <a href="XoaLuongServlet?maLuong=<%=list.get(i).getMaLuong() %>">
                           <i class="fa fa-times text-danger" data-toggle="tooltip" data-placement="top" title="Xóa lương nhân viên"></i>
                         </a>
                        </td>
                     </tr>
                     <% 
                        }
                      %>
                  </tbody>
               </table>
               <p><strong><i class="fa fa-bookmark"></i>Ghi chú: </strong></p>
                <p class="note-items"><i class="glyphicon glyphicon-sort-by-attributes"></i> Sắp xếp theo CSDL</p>
               <p class="note-items"><i class="fa fa-edit text-success"></i> Chỉnh sửa lương.</p>
               <p class="note-items"><i class="fa fa-times text-danger"></i> Xóa lương</p>
            </div>
         </form>
      </div>
         </div>
      </div>
   </body>
</html>
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