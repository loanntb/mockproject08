package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.TaiKhoan;
import model.bo.TaiKhoanBO;
import model.dao.TaiKhoanDao;
 

 
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    TaiKhoanBO taiKhoanBO = new TaiKhoanBO();
    public LoginServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession(false);
    	String content, type, title;
        String Email = request.getParameter("email");
        String MatKhau = request.getParameter("password");
        TaiKhoan taiKhoan = taiKhoanBO.Login(Email,MatKhau);
        
        if (taiKhoan != null) {
        	session.setAttribute("TaiKhoan", taiKhoan);
        	title = "Đăng Nhập Thành Công ";			
			type = "success";
			session.setAttribute("title", title);
			session.setAttribute("type", type);
			response.sendRedirect("./Home");
        }
        else {
        	title = "Đăng Nhập Không Thành Công ";
			content = "Tài khoản hoặc mật khẩu bạn vừa nhập không đúng, kiểm tra lại ! ";
			type = "error";
			request.setAttribute("title", title);
			request.setAttribute("content", content);
			request.setAttribute("type", type);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/CallLogin");
			dispatcher.forward(request, response);
		}
 
    }
}
