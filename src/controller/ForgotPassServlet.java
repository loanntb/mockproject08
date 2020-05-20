package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.TaiKhoan;
import model.bo.TaiKhoanBO;

/**
 * A servlet that takes message details from user and send it as a new e-mail
 * through an SMTP server.
 *
 * @author www.codejava.net
 *
 */
@WebServlet("/ForgotPass")
public class ForgotPassServlet extends HttpServlet {
	private String host;
	private String port;
	private String user;
	private String pass;
	TaiKhoanBO taiKhoanBO = new TaiKhoanBO();

	public void init() {

		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		// reads form fields
		String content1, type, title;
		String recipient = request.getParameter("email");
		String subject = "Yêu cầu lấy lại mật khẩu đăng nhập công ty ABC ";
		String content = "";
		String resultMessage = "";
		TaiKhoan taiKhoan = taiKhoanBO.ForgotPass(recipient);
		if (taiKhoan.getMaTaiKhoan() != null) {
			content = taiKhoan.getMatkhau();
			try {
				EmailUtility.sendEmail(host, port, user, pass, recipient, subject, content, taiKhoan.getEmail());
				title = "Gửi Yêu Cầu Thành Công ";
				content1 = "Bạn vui lòng truy cập vào Email vừa nhập để nhận mật khẩu ! ";
				type = "success";
				request.setAttribute("title", title);
				request.setAttribute("content", content1);
				request.setAttribute("type", type);
				request.setAttribute("Message", resultMessage);
				getServletContext().getRequestDispatcher("/CallLogin").forward(request, response);
			} catch (Exception ex) {
				ex.printStackTrace();
				resultMessage = "There were an error: " + ex.getMessage();
			} finally {
				
			}
		}
		else {
			title = "Yêu Cầu Không Thành Công ";
			content1 = "Email bạn vừa nhập không khớp với tài khoản nào của chúng tôi vui lòng kiểm tra lại ! ";
			type = "error";
			request.setAttribute("title", title);
			request.setAttribute("content", content1);
			request.setAttribute("type", type);
			getServletContext().getRequestDispatcher("/CallForgotPass").forward(request, response);
		}

	}
}