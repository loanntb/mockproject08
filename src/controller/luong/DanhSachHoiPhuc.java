package controller.luong;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CheckQuyen;
import model.bean.Luong;
import model.bean.NhanVien;
import model.bo.LuongBO;
import model.bo.NhanVienBO;

@WebServlet("/DanhSachHoiPhuc")
public class DanhSachHoiPhuc extends HttpServlet{
	private static final long serialVersionUID = 1L;
	LuongBO luongBO = new LuongBO();
	public DanhSachHoiPhuc() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
	     if (CheckQuyen.CheckQuyen1(request) == 0) {
		NhanVienBO nhanvienB0 = new NhanVienBO();
		ArrayList<NhanVien> listNhanVien = nhanvienB0.getNhanVien();
		ArrayList<Luong> list = new ArrayList<>();
		list = luongBO.getListLuongRestore();
		request.setAttribute("list",list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/Luong/DanhSachLuongRestore.jsp");
		dispatcher.include(request, response);
	 }
	 else {
       	RequestDispatcher dispatcher = request.getRequestDispatcher("./CallLogin");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
