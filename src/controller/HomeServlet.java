package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.NhanVien;
import model.bean.TaiKhoan;
import model.bo.NhanVienBO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NhanVienBO nhanVienBO = new NhanVienBO();
	NhanVien nhanVien = new NhanVien();
	TaiKhoan taiKhoan = new TaiKhoan();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		if(session.getAttribute("TaiKhoan")!=null) {	
			taiKhoan = (TaiKhoan) session.getAttribute("TaiKhoan") ;
			nhanVien = nhanVienBO.getByID(taiKhoan.getMaTaiKhoan());
			session.setAttribute("TenNV",nhanVien.getTenNV());
			session.setAttribute("MaNV",nhanVien.getMaNV());
			session.setAttribute("Quyen", taiKhoan.getPhanQuyen());
			session.setAttribute("content","Xin chào "+ nhanVien.getTenNV()+ " !!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("./view/Home/index.jsp");
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
