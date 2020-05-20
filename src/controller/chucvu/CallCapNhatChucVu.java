package controller.chucvu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ChucVu;
import model.bo.ChucVuBO;

/**
 * Servlet implementation class CallCapNhatChucVu
 */
@WebServlet("/CallCapNhatChucVu")
public class CallCapNhatChucVu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ChucVuBO chucVuBO = new ChucVuBO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CallCapNhatChucVu() {
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
		String maCV = request.getParameter("id");
		ChucVu ChucVu = chucVuBO.getChucVuById(maCV);
		request.setAttribute("ChucVu", ChucVu);
		System.out.println(ChucVu.getMaCV());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/ChucVu/SuaCV.jsp");
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
