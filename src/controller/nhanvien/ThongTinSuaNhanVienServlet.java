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

import model.bean.NhanVien;
import model.bo.NhanVienBO;
import model.bo.TaiKhoanBO;

/**
 * Servlet implementation class ThongTinSuaNhanVienServlet
 */
@WebServlet("/ThongTinSuaNhanVien")
public class ThongTinSuaNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongTinSuaNhanVienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String maNV=request.getParameter("maNV");
		    NhanVienBO nhanVienBO=new NhanVienBO();
	        TaiKhoanBO taiKhoanBO=new TaiKhoanBO();
	        List<Map<String, Object>> DanhSachPB = nhanVienBO.getListPhongBan();
	        DanhSachPB = nhanVienBO.getListPhongBan();
	   	    request.setAttribute("DanhSachPB", DanhSachPB);
	   	    // lay danh sach chuc vu
	   	   List<Map<String, Object>> DanhSachCV = nhanVienBO.getListChucVu();
	        DanhSachCV = nhanVienBO.getListChucVu();
		    request.setAttribute("DanhSachCV", DanhSachCV);
		    // lay nhan vien can sua
		    NhanVien nhanVien = nhanVienBO.getNhanVienById(maNV);
			request.setAttribute("nhanVien", nhanVien);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/NhanVien/SuaNV.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
