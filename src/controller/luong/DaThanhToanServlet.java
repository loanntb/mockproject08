package controller.luong;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Luong;
import model.bo.LuongBO;
@WebServlet("/DaThanhToanServlet")
public class DaThanhToanServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	LuongBO luongBO = new LuongBO();
	public DaThanhToanServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		ArrayList<Luong> list = new ArrayList<>();
		list = luongBO.getListDaThanhToanLuong();
		request.setAttribute("list",list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/Luong/DaThanhToan.jsp");
		dispatcher.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
