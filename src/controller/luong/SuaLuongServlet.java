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
import model.bo.NhanVienBO;
import model.dao.LuongDAO;
import model.bo.LuongBO;

@WebServlet("/SuaLuongServlet")
public class SuaLuongServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 public SuaLuongServlet() {
	        super();
	    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
	    if (CheckQuyen.CheckQuyen1(request) == 0) {
		String content, type, title;
		HttpSession session = request.getSession(false);
		String maLuong = request.getParameter("maLuong");
		try {
			String maNV = request.getParameter("maNV");
			Float heSoLuong = Float.parseFloat(request.getParameter("hesoLuong"));
			int luongCoBan = Integer.parseInt(request.getParameter("LuongCB"));
			int phuCap = Integer.parseInt(request.getParameter("phuCap"));
			int trangThai = 1;
			if (LuongDAO.suaLuong(maLuong, maNV, heSoLuong, luongCoBan, phuCap,trangThai) == true) {
				title = "Cập Nhật Thành Công ";
				content = "Bạn cập nhật " + maLuong + " Thành Công ";
				type = "success";
				session.setAttribute("title", title);
				session.setAttribute("content", content);
				session.setAttribute("type", type);
				response.sendRedirect("DanhSachLuongServlet");
			} else {
				title = "Không Thành Công ";
				content = "Vui lòng kiểm tra lại ";
				type = "error";
				session.setAttribute("title", title);
				session.setAttribute("content", content);
				session.setAttribute("type", type);
				response.sendRedirect("CallSuaLuongServlet");
			}

		} catch (Exception e) {
			request.setCharacterEncoding("UTF-8");
			LuongBO luongBO = new LuongBO();
			NhanVienBO nhanvienBO = new NhanVienBO();
			ArrayList<NhanVien> listNhanVien = nhanvienBO.getNhanVien();
			request.setAttribute("listNhanVien",listNhanVien);
			Luong luong = luongBO.getThongTinLuong(maLuong);
			request.setAttribute("listluong", luong);
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/Luong/ChinhSuaLuong.jsp");
			dispatcher.forward(request, response);
		 }
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
