package controller.nhanvien;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.NhanVienBO;

/**
 * Servlet implementation class SuaNhanVienServlet
 */
@WebServlet("/SuaCaNhan")
public class SuaCaNhanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaCaNhanServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String content, type, title;
		HttpSession session = request.getSession(false);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		if("submit".equals(request.getParameter("submit"))){
			NhanVienBO nhanVienBO=new NhanVienBO();
			 String maNV =request.getParameter("maNV");
			 String tenNV =request.getParameter("tenNV");
			 String gioiTinh =request.getParameter("gioiTinh");
			 String ngaySinh =request.getParameter("ngaySinh");
			 String email =request.getParameter("email");
			 String diachi =request.getParameter("diaChi");
			 String dienThoai =request.getParameter("soDienThoai");
			 String maPB =request.getParameter("maPB");
			 String maCV =request.getParameter("maCV");
			 nhanVienBO.editthongtinnhanvien(maNV,tenNV,ngaySinh,gioiTinh,dienThoai,email,diachi,maPB,maCV);
			 title = "Sửa Thành Công ";
			 content = "Bạn Đã Sửa " + tenNV + " Thành Công ";
			 type = "success";
			 session.setAttribute("title", title);
			 session.setAttribute("content", content);
			 session.setAttribute("type", type);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("./DanhSachNhanVien");
				dispatcher.include(request, response);		
		}
		else {
			title = "Không Thành Công ";
			content = "Vui lòng kiểm tra lại ";
			type = "error";
			session.setAttribute("title", title);
			session.setAttribute("content", content);
			session.setAttribute("type", type);
			 String maNV=request.getParameter("maNV");
			RequestDispatcher dispatcher = request.getRequestDispatcher("ThongTinSuaNhanVien?maNV="+maNV);
			dispatcher.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
