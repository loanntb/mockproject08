package controller.chucvu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.ChucVuBO;

/**
 * Servlet implementation class ThemChucVu
 */
@WebServlet("/ThemChucVu")
public class ThemChucVu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ChucVuBO chucVuBO = new ChucVuBO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemChucVu() {
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
		String content, type, title;
		HttpSession session = request.getSession(false);
		try {
			String maCV = request.getParameter("maCV");
			String tenCV = request.getParameter("tenCV");

			if (chucVuBO.ThemChucVu(maCV, tenCV) == true) {
				title = "Thêm Thành Công ";
				content = "Bạn Đã Thêm " + maCV + " Thành Công ";
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
				response.sendRedirect("./ThemChucVu");

			}

		} catch (Exception e) {
			title = "Không Thành Công ";
			content = "Vui lòng kiểm tra lại ";
			type = "error";
			session.setAttribute("title", title);
			session.setAttribute("content", content);
			session.setAttribute("type", type);
			response.sendRedirect("./ThemChucVu");
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
