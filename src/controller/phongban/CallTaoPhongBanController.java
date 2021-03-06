package controller.phongban;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.PhongBanBO;

/**
 * Servlet implementation class TaoMoiController
 */
@WebServlet("/CallPhongBan")
public class CallTaoPhongBanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PhongBanBO phongBanBO = new PhongBanBO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallTaoPhongBanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		

		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        // Mã tự động tăng
        request.setAttribute("maPB", phongBanBO.createComputerId());
		
        
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/PhongBan/ThemPB.jsp");
		dispatcher.include(request, response);
			
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
