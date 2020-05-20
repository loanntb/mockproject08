package controller.chucvu;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CheckQuyen;
import model.bean.ChucVu;
import model.bo.ChucVuBO;

/**
 * Servlet implementation class DanhSachChucVu
 */
@WebServlet("/DanhSachChucVu")
public class DanhSachChucVu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ChucVuBO chucVuBO = new ChucVuBO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DanhSachChucVu() {
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
			ArrayList<ChucVu> DanhSachCV = new ArrayList<>();
			DanhSachCV = chucVuBO.getListCV();
			request.setAttribute("DanhSachCV", DanhSachCV);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/ChucVu/DanhSachCV.jsp");
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
