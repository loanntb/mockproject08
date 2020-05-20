package controller.luong;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.LuongDAO;

@WebServlet("/ThanhToanServlet")
public class ThanhToanServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 public ThanhToanServlet() {
	        super();
	    }
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			String content, type, title;
			HttpSession session = request.getSession(false);
			try {
					String maLuong = request.getParameter("maLuong");
					String maNhanVien = request.getParameter("maNhanVien");
				if (LuongDAO.thanhToanLuong(maLuong,maNhanVien) == true) {
					title = "Thanh toán Thành Công ";
					content = "Thanh toán thành công";
					type = "success";
					session.setAttribute("title", title);
					session.setAttribute("content", content);
					session.setAttribute("type", type);
					response.sendRedirect("DaThanhToanServlet");
				} else {
					title = "Không Thành Công ";
					content = "Vui lòng kiểm tra lại ";
					type = "error";
					session.setAttribute("title", title);
					session.setAttribute("content", content);
					session.setAttribute("type", type);
				}

			} catch (Exception e) {
				title = "Không Thành Công ";
				content = "Vui lòng kiểm tra lại ";
				type = "error";
				session.setAttribute("title", title);
				session.setAttribute("content", content);
				session.setAttribute("type", type);
			}

		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doGet(request, response);
		}
}
