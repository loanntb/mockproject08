package controller.luong;
import java.io.IOException;


import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Luong;
import model.bean.NhanVien;
import model.bo.LuongBO;
import model.bo.NhanVienBO;

@WebServlet("/CallSuaLuongServlet")
public class CallSuaLuongServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 public CallSuaLuongServlet() {
	        super();
	 }
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			LuongBO luongBO = new LuongBO();
			NhanVienBO nhanvienBO = new NhanVienBO();
			ArrayList<NhanVien> listNhanVien = nhanvienBO.getNhanVien();
			request.setAttribute("listNhanVien",listNhanVien);
			String maLuong = request.getParameter("maLuong");
			Luong luong = luongBO.getThongTinLuong(maLuong);
			request.setAttribute("listluong", luong);
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/Luong/ChinhSuaLuong.jsp");
			dispatcher.forward(request, response);
	}
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doGet(request, response);
		}
}
