package common;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.bean.TaiKhoan;

/**
 * Servlet implementation class Message
 */
@WebServlet("/CheckQuyen")
public class CheckQuyen extends HttpServlet {
	public static int CheckQuyen1(HttpServletRequest request) {
		HttpSession session = request.getSession();
		TaiKhoan taiKhoan = new TaiKhoan();
		if (session.getAttribute("TaiKhoan") != null) {
			taiKhoan = (TaiKhoan) session.getAttribute("TaiKhoan");
			return taiKhoan.getPhanQuyen();
		}
		return -1;
	}
}
