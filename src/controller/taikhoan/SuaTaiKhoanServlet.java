package controller.taikhoan;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.TaiKhoanBO;

/**
 * Servlet implementation class SuaTaiKhoanServlet
 */
@WebServlet("/SuaTaiKhoan")
public class SuaTaiKhoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaTaiKhoanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String content, type, title;
		HttpSession session = request.getSession(false);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		if("submit".equals(request.getParameter("submit"))){
			TaiKhoanBO taiKhoanBO=new TaiKhoanBO();
			String maTK=request.getParameter("maTK");
			 String email =request.getParameter("email");
			 String matKhau =request.getParameter("matKhau");
			 String phanQuyen =request.getParameter("phanQuyen");
			 title = "Sửa Thành Công ";
			 content = "Bạn Đã Sửa Thành Công ";
			 type = "success";
			 session.setAttribute("title", title);
			 session.setAttribute("content", content);
			 session.setAttribute("type", type);
			 taiKhoanBO.editthongtintaikhoan(maTK,email,matKhau,phanQuyen);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("DanhSachTaiKhoanServlet");
				dispatcher.include(request, response);		
		}
		else {
			title = "Không Thành Công ";
			content = "Vui lòng kiểm tra lại ";
			type = "error";
			session.setAttribute("title", title);
			session.setAttribute("content", content);
			session.setAttribute("type", type);
			 String maTK=request.getParameter("maTK");
			RequestDispatcher dispatcher = request.getRequestDispatcher("ThongTinSuaTaiKhoanServlet?maTK="+maTK);
			dispatcher.include(request, response);
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
