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
import model.bo.TaiKhoanBO;

/**
 * Servlet implementation class ThemMoiNhanVienServlet
 */
@WebServlet("/ThemMoiNhanVien")
public class ThemMoiNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemMoiNhanVienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String content, type, title;
		HttpSession session = request.getSession(false);
		NhanVienBO nhanVienBO =new NhanVienBO();
		TaiKhoanBO taiKhoanBO=new TaiKhoanBO();
		String maNV =request.getParameter("maNV");
		String tenNV =request.getParameter("tenNV");
		String gioiTinh =request.getParameter("gioiTinh");
		String ngaySinh =request.getParameter("ngaySinh");
		String email =request.getParameter("email");
		String diachi =request.getParameter("diaChi");
		String dienThoai =request.getParameter("soDienThoai");
		String maPB =request.getParameter("maPB");
		String maCV =request.getParameter("maCV");
		String maTaiKhoan =request.getParameter("maTK");
		String Matkhau =request.getParameter("matTK");
		String PhanQuyen ="1";
		try {
			if(taiKhoanBO.InsertTaiKhoan(maTaiKhoan,email,Matkhau,PhanQuyen)==true && nhanVienBO.InsertNhanVien(maNV, tenNV, ngaySinh, gioiTinh, dienThoai, email, diachi, maPB, maCV, maTaiKhoan)==true) {
				title = "Thêm Thành Công ";
				content = "Bạn Đã Thêm " + tenNV + " Thành Công ";
				type = "success";
				session.setAttribute("title", title);
				session.setAttribute("content", content);
				session.setAttribute("type", type);
				RequestDispatcher dr=request.getRequestDispatcher("./DanhSachNhanVien");
				dr.forward(request, response);
			}
			else {
				title = "Không Thành Công ";
				content = "Vui lòng kiểm tra lại ";
				type = "error";
				session.setAttribute("title", title);
				session.setAttribute("content", content);
				session.setAttribute("type", type);
				RequestDispatcher dr=request.getRequestDispatcher("./ThongTinThemMoiNhanVien");
				dr.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
