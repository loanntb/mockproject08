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

import model.bo.NhanVienBO;
import model.bo.TaiKhoanBO;

/**
 * Servlet implementation class ThongTinThemMoiNhanVien
 */
@WebServlet("/ThongTinThemMoiNhanVien")
public class ThongTinThemMoiNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongTinThemMoiNhanVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//lay danh sach phong ban
        NhanVienBO nhanVienBO=new NhanVienBO();
        TaiKhoanBO taiKhoanBO=new TaiKhoanBO();
        List<Map<String, Object>> DanhSachPB = nhanVienBO.getListPhongBan();
        DanhSachPB = nhanVienBO.getListPhongBan();
   	    request.setAttribute("DanhSachPB", DanhSachPB);
   	    // lay danh sach chuc vu
   	   List<Map<String, Object>> DanhSachCV = nhanVienBO.getListChucVu();
        DanhSachCV = nhanVienBO.getListChucVu();
	    request.setAttribute("DanhSachCV", DanhSachCV);
	    
	    // lay ma tu đong nhan vien 
	    request.setAttribute("maMay", nhanVienBO.createNhanVienMa());
	 // lay ma tu đong tài khoản
	    request.setAttribute("maTaiKhoan", taiKhoanBO.createMaTaiKhoan());
	    
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/NhanVien/ThemMoiNV.jsp");
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
