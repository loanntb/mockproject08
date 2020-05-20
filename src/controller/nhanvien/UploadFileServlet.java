package controller.nhanvien;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.bo.NhanVienBO;

/**
 * Servlet implementation class UploadFileServlet
 */
@WebServlet("/UploadFile")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 50, // 50MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String tenfile = "null";
		try {
		for (Part part : request.getParts()) {
			String fileName = extractFileName(part);
			fileName = new File(fileName).getName();
			part.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
			tenfile = fileName;
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		if("submit".equals(request.getParameter("submit"))){
			NhanVienBO nhanVienBO=new NhanVienBO();
			 String tenanh=tenfile;
			 String maNV=request.getParameter("maNV");
			 nhanVienBO.edithinhanh(tenanh,maNV);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("./ThongTinSuaNhanVien?maNV="+maNV);
				dispatcher.include(request, response);		
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("./DanhSachNhanVien");
			dispatcher.include(request, response);
		}
		
		
	}

private String extractFileName(Part part) {
    String contentDisp = part.getHeader("content-disposition");
    String[] items = contentDisp.split(";");
  
    for (String s : items) {
      if (s.trim().startsWith("filename")) {
        return s.substring(s.indexOf("=") + 2, s.length() - 1);
      }
    } // ko de bug duoc. kho tim hieu nguye nnha nqua
    return "";
  }
  public File getFolderUpload() {

    File folderUpload = new File("F:/Intern/Mock_Project/WebContent/images");
    if (!folderUpload.exists()) {
      folderUpload.mkdirs();
    }
    return folderUpload;
	}

}
