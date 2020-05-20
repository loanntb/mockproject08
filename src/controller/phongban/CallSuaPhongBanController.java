package controller.phongban;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.PhongBan;
import model.bo.PhongBanBO;



/**
 * Servlet implementation class CallSuaPhongBanController
 */
@WebServlet("/CallSuaPhongBan")
public class CallSuaPhongBanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PhongBanBO phongBanBO = new PhongBanBO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallSuaPhongBanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String MaPB = request.getParameter("id");
		PhongBan phongBan = phongBanBO.getPhongBanById(MaPB);

		request.setAttribute("phongban", phongBan);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/PhongBan/SuaPB.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
