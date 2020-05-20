package controller.phongban;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.PhongBanBO;


/**
 * Servlet implementation class SuahoatDongController
 */
@WebServlet("/SuaPhongBan")
public class SuaPhongBanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PhongBanBO phongBanBO = new PhongBanBO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaPhongBanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String MaPB = request.getParameter("maPB");
		String TenPB = request.getParameter("TenPB");
		String SoDT = request.getParameter("SoDT");
		String ViTri = request.getParameter("ViTri");
		
		 String content, type, title;
	        HttpSession session = request.getSession(false);
		
		if(phongBanBO.CapNhatPB(MaPB, TenPB, SoDT, ViTri)==true) {
            title = "Sửa Thành Công ";
            content = "Bạn đã sửa " + TenPB + " thành công ";
            type = "success";
            session.setAttribute("title", title);
            session.setAttribute("content", content);
            session.setAttribute("type", type);
            response.sendRedirect("./DanhSachPhongBan");
        } else {
            title = "Không thành công ";
            content = "Vui lòng kiểm tra lại ";
            type = "error";
            session.setAttribute("title", title);
            session.setAttribute("content", content);
            session.setAttribute("type", type);
            response.sendRedirect("./view/PhongBan/ThemPB.jsp");


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
