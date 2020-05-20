package controller.taikhoan;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.TaiKhoan;
import model.bo.TaiKhoanBO;

/**
 * Servlet implementation class ThongTinSuaTaiKhoanServlet
 */
@WebServlet("/ThongTinSuaTaiKhoan")
public class ThongTinSuaTaiKhoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongTinSuaTaiKhoanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String maTK=request.getParameter("maTK");
	        TaiKhoanBO taiKhoanBO=new TaiKhoanBO();;
		    // lay thông tin tài khoản cần sửa
		    TaiKhoan taiKhoan = taiKhoanBO.getTaiKhoanById(maTK);
			request.setAttribute("taiKhoan", taiKhoan);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/TaiKhoan/SuaTK.jsp");
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
