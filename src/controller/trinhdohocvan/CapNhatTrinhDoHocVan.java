package controller.trinhdohocvan;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.HocVanBO;

/**
 * Servlet implementation class CapNhatTrinhDoHocVan
 */
@WebServlet("/CapNhatTrinhDoHV")
public class CapNhatTrinhDoHocVan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HocVanBO hocVanBO = new HocVanBO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CapNhatTrinhDoHocVan() {
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
		String maHV = request.getParameter("maHV");
		String tenHV = request.getParameter("tenHV");
		String maNV = request.getParameter("nhanVien");
		String content, type, title;
		HttpSession session = request.getSession(false);
		if (hocVanBO.CapNhatCV(maHV, tenHV, maNV)) {
			title = "Cập Nhật Thành Công ";
			content = "Bạn Đã Cập Nhật " + tenHV + " Thành Công ";
			type = "success";
			session.setAttribute("title", title);
			session.setAttribute("content", content);
			session.setAttribute("type", type);
			response.sendRedirect("./DanhSachTrinhDoHV");

		} else {
			title = "Không Thành Công ";
			content = "Vui lòng kiểm tra lại ";
			type = "error";
			session.setAttribute("title", title);
			session.setAttribute("content", content);
			session.setAttribute("type", type);
			RequestDispatcher dispatcher = request.getRequestDispatcher("./view/HocVan/SuaTrinhDoHV.jsp");
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
