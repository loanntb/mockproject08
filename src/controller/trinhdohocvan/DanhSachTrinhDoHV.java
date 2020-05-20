package controller.trinhdohocvan;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CheckQuyen;
import model.bean.HocVan;
import model.bo.HocVanBO;

/**
 * Servlet implementation class DanhSachTrinhDoHV
 */
@WebServlet("/DanhSachTrinhDoHV")
public class DanhSachTrinhDoHV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HocVanBO hocVanBO = new HocVanBO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DanhSachTrinhDoHV() {
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
		request.setCharacterEncoding("utf-8");
		if (CheckQuyen.CheckQuyen1(request) == 0) {
			ArrayList<HocVan> DanhSachHV = new ArrayList<>();
			DanhSachHV = hocVanBO.getListHV();
			request.setAttribute("DanhSachHV", DanhSachHV);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/HocVan/DanhSachTrinhDoHV.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("./CallLogin");
			dispatcher.forward(request, response);
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
