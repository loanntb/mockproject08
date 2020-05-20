package controller.luong;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.LuongDAO;

@WebServlet("/XoaLuongAllServlet")
public class XoaLuongAllServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    public XoaLuongAllServlet() {
        super();
    }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String content, type, title;
		HttpSession session = request.getSession(false);
		String maLuong = request.getParameter("maLuong");
		try {
			if (LuongDAO.xoaluongALL(maLuong) == true) {
				title = "Xóa Thành Công ";
				content = "Bạn xóa " + maLuong + " Thành Công ";
				type = "success";
				session.setAttribute("title", title);
				session.setAttribute("content", content);
				session.setAttribute("type", type);
				response.sendRedirect("DanhSachLuongServlet");
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
