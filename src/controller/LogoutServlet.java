package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public LogoutServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 response.setContentType("text/html;charset=UTF-8"); 
         request.setCharacterEncoding("UTF-8");
         HttpSession session = request.getSession();	
         String content, type, title;
         session.removeAttribute("TaiKhoan");
         title = "Đăng Nhập Xuất Thành Công ";
			content = "Bạn đã đăng xuất, nếu muốn sử dụng các tác vụ vui lòng đăng nhập  ! ";
			type = "success";
			request.setAttribute("title", title);
			request.setAttribute("content", content);
			request.setAttribute("type", type);
         RequestDispatcher rd = request.getRequestDispatcher("./CallLogin");
                 rd.include(request, response);
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}
 