package controller.luong;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhanVien;
import model.bo.LuongBO;
import model.bo.NhanVienBO;

@WebServlet("/CallTaoLuongServlet")
public class CallTaoLuongServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    NhanVienBO nhanvienBO = new NhanVienBO();
    LuongBO luongBO=new LuongBO();
    public CallTaoLuongServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		NhanVienBO nhanvienB0 = new NhanVienBO();
		ArrayList<NhanVien> listNhanVien = nhanvienB0.getNhanVien();
		request.setAttribute("listNhanVien", listNhanVien);
		// lay ma tu dong ma luong
		  // lay ma tu đong nhan vien 
	    request.setAttribute("maLuong", luongBO.createLuongMa());
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/Luong/ThemLuong.jsp");
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
