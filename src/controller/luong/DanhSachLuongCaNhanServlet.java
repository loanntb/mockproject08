package controller.luong;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CheckQuyen;
import model.bean.Luong;
import model.bean.NhanVien;
import model.bean.TaiKhoan;
import model.bo.LuongBO;
import model.bo.NhanVienBO;
/**
 * @author TinNH5
 *
 */
@WebServlet("/DanhSachLuongCaNhanServlet")
public class DanhSachLuongCaNhanServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	LuongBO luongBO = new LuongBO();
	NhanVien nhanVien = new NhanVien();
	TaiKhoan taiKhoan = new TaiKhoan();
	NhanVienBO nhanVienBO = new NhanVienBO();
	public DanhSachLuongCaNhanServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session= request.getSession();
		taiKhoan = (TaiKhoan) session.getAttribute("TaiKhoan") ;
		nhanVien = nhanVienBO.getByID(taiKhoan.getMaTaiKhoan());
	
		ArrayList<Luong> list = new ArrayList<>();
		list = luongBO.getListLuong123(nhanVien.getMaNV());
		request.setAttribute("list",list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/Luong/DanhSachLuong.jsp");
		dispatcher.include(request, response);
	  
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
