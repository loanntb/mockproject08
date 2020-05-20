package controller.trinhdohocvan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.HocVanBO;

/**
 * Servlet implementation class XoaTrinhDoHV
 */
@WebServlet("/XoaTrinhDoHV")
public class XoaTrinhDoHocVan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HocVanBO hocVanBO = new HocVanBO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XoaTrinhDoHocVan() {
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
		HttpSession session = request.getSession(false);
		String content, type, title;
		String maHV = request.getParameter("id");
		if (hocVanBO.XoaCV(maHV) == true) {
			title = "Xóa Thành Công ";
			content = "Bạn đã xóa " + maHV + " Thành Công ";
			type = "success";
			session.setAttribute("title", title);
			session.setAttribute("content", content);
			session.setAttribute("type", type);
			response.sendRedirect("./DanhSachTrinhDoHV");
		} else {
			title = "Xóa Không Thành Công ";
			content = "Bạn đã xóa " + maHV + " Không Thành Công ";
			type = "error";
			session.setAttribute("title", title);
			session.setAttribute("content", content);
			session.setAttribute("type", type);
			response.sendRedirect("./DanhSachTrinhDoHV");
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
