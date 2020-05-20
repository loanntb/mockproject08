package controller.taikhoan;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CheckQuyen;
import model.bo.TaiKhoanBO;

/**
 * Servlet implementation class DanhSachTaiKhoanServlet
 */
@WebServlet("/DanhSachTaiKhoan")
public class DanhSachTaiKhoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachTaiKhoanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        if (CheckQuyen.CheckQuyen1(request) == 0) {
        TaiKhoanBO taiKhoanBO=new TaiKhoanBO();
        List<Map<String, Object>> DanhSachTaiKhoan = taiKhoanBO.getListTaiKhoan();
        DanhSachTaiKhoan = taiKhoanBO.getListTaiKhoan();
   	    request.setAttribute("DanhSachTaiKhoan", DanhSachTaiKhoan);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/TaiKhoan/DanhSachTaiKhoan.jsp");
		dispatcher.forward(request, response);
	}
	 else {
       	RequestDispatcher dispatcher = request.getRequestDispatcher("./CallLogin");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
