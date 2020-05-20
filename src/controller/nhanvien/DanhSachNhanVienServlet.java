package controller.nhanvien;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CheckQuyen;
import model.bo.NhanVienBO;

/**
 * Servlet implementation class DanhSachNhanVienServlet
 */
@WebServlet("/DanhSachNhanVien")
public class DanhSachNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachNhanVienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        if (CheckQuyen.CheckQuyen1(request) == 0) {
        NhanVienBO nhanVienBO=new NhanVienBO();
        List<Map<String, Object>> DanhSachNhanVien = nhanVienBO.getListNhanVien();
        DanhSachNhanVien = nhanVienBO.getListNhanVien();
   	    request.setAttribute("DanhSachNhanVien", DanhSachNhanVien);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/NhanVien/DanhSachNV.jsp");
		dispatcher.forward(request, response);
        }
        else {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("./CallLogin");
			dispatcher.forward(request, response);
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
