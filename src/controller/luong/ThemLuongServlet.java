package controller.luong;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.LuongBO;
import model.dao.LuongDAO;

@WebServlet("/ThemLuongServlet")
public class ThemLuongServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	LuongBO luongBO = new LuongBO();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemLuongServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String content, type, title;
		HttpSession session = request.getSession(false);
		try {
			String maLuong = request.getParameter("maLuong");
			String maNV = request.getParameter("maNV");
			Float heSoLuong = Float.parseFloat(request.getParameter("hesoLuong"));
			int luongCoBan = Integer.parseInt(request.getParameter("LuongCB"));
			int phuCap = Integer.parseInt(request.getParameter("phuCap"));
			int trangThai = 1;
			if (LuongDAO.themLuong(maLuong, maNV, heSoLuong, luongCoBan, phuCap,trangThai) == true) {
				title = "Thêm Thành Công ";
				content = "Bạn đã Thêm " + maLuong + " Thành Công ";
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
				response.sendRedirect("CallTaoLuongServlet");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
