package controller.trinhdohocvan;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.NhanVien;
import model.bo.HocVanBO;
import model.bo.NhanVienBO;

/**
 * Servlet implementation class ThemTrinhDoHocVan
 */
@WebServlet("/ThemTrinhDoHV")
public class ThemTrinhDoHocVan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NhanVienBO nhanVienBO = new NhanVienBO();
	HocVanBO hocVanBO = new HocVanBO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemTrinhDoHocVan() {
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
			ArrayList<NhanVien> listNhanVien = nhanVienBO.getListNhanVienHV();
			request.setAttribute("listNhanVien", listNhanVien);
			String maHV = request.getParameter("maHV");
			String tenHV = request.getParameter("tenHV");
			String maNV = request.getParameter("nhanVien");
			if (hocVanBO.ThemHocVan(maHV, tenHV, maNV) == true) {
				title = "Thêm Thành Công ";
				content = "Bạn Đã Thêm " + maHV + " Thành Công ";
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
				response.sendRedirect("./DanhSachTrinhDoHV");

			}

		} catch (Exception e) {
			title = "Không Thành Công ";
			content = "Vui lòng kiểm tra lại ";
			type = "error";
			session.setAttribute("title", title);
			session.setAttribute("content", content);
			session.setAttribute("type", type);
			response.sendRedirect("./ThemTrinhDoHocVan");
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
