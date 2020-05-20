package controller.chucvu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.ChucVuBO;

/**
 * Servlet implementation class CapNhatChucVu
 */
@WebServlet("/CapNhatChucVu")
public class CapNhatChucVu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ChucVuBO chucVuBO = new ChucVuBO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CapNhatChucVu() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String maCV = request.getParameter("maCV");
		String tenCV = request.getParameter("tenCV");
		String content, type, title;
		HttpSession session = request.getSession(false);
		if (chucVuBO.CapNhatCV(maCV, tenCV)) {
			title = "Cập Nhật Thành Công ";
			content = "Bạn Đã Cập Nhật " + tenCV + " Thành Công ";
			type = "success";
			session.setAttribute("title", title);
			session.setAttribute("content", content);
			session.setAttribute("type", type);
			response.sendRedirect("./DanhSachChucVu");

		} else {
			title = "Không Thành Công ";
			content = "Vui lòng kiểm tra lại ";
			type = "error";
			session.setAttribute("title", title);
			session.setAttribute("content", content);
			session.setAttribute("type", type);
			RequestDispatcher dispatcher = request.getRequestDispatcher("./view/ChucVu/SuaCV.jsp");
			dispatcher.include(request, response);
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
