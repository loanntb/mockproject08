package controller.nhanvien;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.NhanVienBO;

/**
 * Servlet implementation class XoaNhanVienServlet
 */
@WebServlet("/XoaNhanVien")
public class XoaNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaNhanVienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		String content, type, title;
		String maNV = request.getParameter("maNV");
		NhanVienBO nhanVienBO=new NhanVienBO();
		if (nhanVienBO.XoaNV(maNV) == true) {
			title = "Xóa Thành Công ";
			content = "Bạn đã xóa " + maNV + " Thành Công ";
			type = "success";
			session.setAttribute("title", title);
			session.setAttribute("content", content);
			session.setAttribute("type", type);
			response.sendRedirect("./DanhSachNhanVien");
		} else {
			title = "Xóa Không Thành Công ";
			content = "Bạn đã xóa " + maNV + " Không Thành Công ";
			type = "error";
			session.setAttribute("title", title);
			session.setAttribute("content", content);
			session.setAttribute("type", type);
			response.sendRedirect("./DanhSachNhanVien");
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
