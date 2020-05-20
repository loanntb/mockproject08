package controller.luong;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CheckQuyen;
import model.dao.LuongDAO;

@WebServlet("/XoaLuongServlet")
public class XoaLuongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public XoaLuongServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		if (CheckQuyen.CheckQuyen1(request) == 0) {
			String content, type, title;
			HttpSession session = request.getSession(false);
			String maLuong = request.getParameter("maLuong");
			try {
				if (LuongDAO.xoaLuong(maLuong) == true) {
					title = "Xóa Thành Công ";
					content = "Bạn xóa " + maLuong + " Thành Công ";
					type = "success";
					session.setAttribute("title", title);
					session.setAttribute("content", content);
					session.setAttribute("type", type);
					response.sendRedirect("DanhSachHoiPhuc");
				} else {
					title = "Không Thành Công ";
					content = "Vui lòng kiểm tra lại ";
					type = "error";
					session.setAttribute("title", title);
					session.setAttribute("content", content);
					session.setAttribute("type", type);
				}

			} catch (Exception e) {
				title = "Không Thành Công ";
				content = "Vui lòng kiểm tra lại ";
				type = "error";
				session.setAttribute("title", title);
				session.setAttribute("content", content);
				session.setAttribute("type", type);
			}
		} else

		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("./CallLogin");
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
