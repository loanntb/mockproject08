package controller.trinhdohocvan;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhanVien;
import model.bo.HocVanBO;
import model.bo.NhanVienBO;

/**
 * Servlet implementation class GoiTaoTrinhDoHocVan
 */
@WebServlet("/GoiTaoTrinhDoHocVan")
public class GoiTaoTrinhDoHocVan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HocVanBO hocVanBO = new HocVanBO();
	NhanVienBO nhanVienBO = new NhanVienBO();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoiTaoTrinhDoHocVan() {
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
		request.setAttribute("maHV", hocVanBO.themHVId());
		ArrayList<NhanVien> listNhanVien = nhanVienBO.getListNhanVienHV();
		request.setAttribute("listNhanVien", listNhanVien);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/HocVan/ThemTrinhDoHV.jsp");
		dispatcher.forward(request, response);
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
