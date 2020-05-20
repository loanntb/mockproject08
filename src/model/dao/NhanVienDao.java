
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.ConnectDB;
import model.bean.NhanVien;

/**
 * NhanVienDao.java
 *
 * Version 1.0
 *
 * Date: 26-04-2020
 *
 * Copyright
 *
 * Modification Logs: DATE AUTHOR DESCRIPTION
 * -----------------------------------------------------------------------
 * 26-04-2020 DungPT49 Create
 */
public class NhanVienDao {

	/**
	 * MoTa
	 * 
	 * @param maTaiKhoan
	 * @return
	 */
	public NhanVien getByID(String maTaiKhoan) {
		Connection conn = ConnectDB.getConnection();
		String sql = "Select *  from NHANVIEN where MaTaiKhoan = ?";
		PreparedStatement stmt = null;
		NhanVien nhanVien = new NhanVien();
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, maTaiKhoan);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				nhanVien.setMaNV(rs.getString(1));
				nhanVien.setTenNV(rs.getString(2));
				nhanVien.setAnh(rs.getString(3));
				nhanVien.setNgaySinh(rs.getString(4));
				nhanVien.setDienThoai(rs.getString(5));
				nhanVien.setEmail(rs.getString(6));
				nhanVien.setEmail(rs.getString(7));
				nhanVien.setDiachi(rs.getString(8));
				nhanVien.setNgayDangKy(rs.getString(9));
				nhanVien.setNgayUpdate(rs.getString(10));
				nhanVien.setTrangThai(rs.getString(11));
				nhanVien.setMaPB(rs.getString(12));
				nhanVien.setMaCV(rs.getString(13));
				nhanVien.setMaTaiKhoan(rs.getString(14));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return nhanVien;
	}

	public ArrayList<NhanVien> getListNhanVienHV() {
		Connection conn = ConnectDB.getConnection();
		ArrayList<NhanVien> list = new ArrayList<>();
		String sql = "SELECT * FROM NHANVIEN";
		PreparedStatement stmt = null;
		NhanVien nv;

		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				nv = new NhanVien();
				nv.setMaNV(rs.getString(1));
				nv.setTenNV(rs.getString(2));
				list.add(nv);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return list;
	}

	public boolean InsertNhanVien(NhanVien nV) {
		String Ngaydangky = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		Connection conn = ConnectDB.getConnection();
		String sql = "INSERT INTO NHANVIEN(MaNV,TenNV,Anh,NgaySinh,GioiTinh,DienThoai,Email,DiaChi,NgayDangKy,NgayUpdate,TrangThai,MaPB,MaCV,MaTaiKhoan)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, nV.getMaNV());
			stmt.setString(2, nV.getTenNV());
			stmt.setString(3, "noneimage.jpg");
			stmt.setString(4, nV.getNgaySinh());
			stmt.setString(5, nV.getGioiTinh());
			stmt.setString(6, nV.getDienThoai());
			stmt.setString(7, nV.getEmail());
			stmt.setString(8, nV.getDiachi());
			stmt.setString(9, Ngaydangky);
			stmt.setString(10, Ngaydangky);
			stmt.setString(11, "1");
			stmt.setString(12, nV.getMaPB());
			stmt.setString(13, nV.getMaCV());
			stmt.setString(14, nV.getMaTaiKhoan());
			int rs = stmt.executeUpdate();
			if (rs != 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * MoTa
	 * 
	 * @param nV
	 * @return
	 */
	public boolean CapNhatHinhAnh(NhanVien nV) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * MoTa
	 * 
	 * @param maNV
	 * @return
	 */
	public NhanVien getNhanVienById(String maNV) {
		Connection conn = ConnectDB.getConnection();
		String sql = "Select *  from NHANVIEN where MaNV = ?";
		PreparedStatement stmt = null;

		NhanVien nhanVien = new NhanVien();

		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, maNV);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				nhanVien.setMaNV(rs.getString("MaNV"));
				nhanVien.setTenNV(rs.getString("TenNV"));
				nhanVien.setAnh(rs.getString("Anh"));
				nhanVien.setNgaySinh(rs.getString("NgaySinh"));
				nhanVien.setGioiTinh(rs.getString("GioiTinh"));
				nhanVien.setDienThoai(rs.getString("DienThoai"));
				nhanVien.setEmail(rs.getString("Email"));
				nhanVien.setDiachi(rs.getString("Diachi"));
				nhanVien.setMaPB(rs.getString("MaPB"));
				nhanVien.setMaCV(rs.getString("MaCV"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return nhanVien;
	}

	/**
	 * MoTa
	 * 
	 * @param tenanh
	 * @param maNV
	 */
	public void edithinhanh(String tenanh, String maNV) {
		Connection conn = ConnectDB.getConnection();
		String sql = String.format("UPDATE NHANVIEN SET Anh='%s' WHERE MaNV='%s'", tenanh, maNV);
		try {
			Statement stm = conn.createStatement();
			stm.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * MoTa
	 * 
	 * @return
	 */
	public void editthongtinnhanvien(String maNV, String tenNV, String ngaySinh, String gioiTinh, String dienThoai,
			String email, String diachi, String maPB, String maCV) {
		Connection conn = ConnectDB.getConnection();
		String NgayUpdate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		String sql = String.format(
				"UPDATE NHANVIEN SET TenNV=N'%s',NgaySinh='%s',GioiTinh='%s',DienThoai='%s',Email='%s',Diachi=N'%s',NgayUpdate='%s',MaPB='%s',MaCV='%s' WHERE MaNV='%s'",
				tenNV, ngaySinh, gioiTinh, dienThoai, email, diachi, NgayUpdate, maPB, maCV, maNV);

		try {
			Statement stm = conn.createStatement();
			stm.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int XoaNV(String maNV) {
		Connection conn = ConnectDB.getConnection();
		String sql = String.format("UPDATE NHANVIEN SET TrangThai='0' WHERE MaNV='%s'", maNV);
		PreparedStatement statement = null;
		int rowCount = 0;

		try {
			statement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			int rs = statement.executeUpdate();
			if (rs != 0) {
				rowCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCount;
	}

	/**
	 * MoTa
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getListNhanViendaxoa() {
		Connection conn = ConnectDB.getConnection();
		List<Map<String, Object>> list = new ArrayList<>();
		String sql = "Select MaNV ,TenNV ,Anh ,NgaySinh ,GioiTinh ,DienThoai ,Email ,Diachi ,NgayDangKy ,NgayUpdate ,TrangThai,PHONGBAN.TenPB,\r\n"
				+ "CHUCVU.TenCV FROM NHANVIEN,PHONGBAN,CHUCVU WHERE NHANVIEN.MaPB=PHONGBAN.MaPB AND NHANVIEN.MaCV=CHUCVU.MaCV AND TrangThai='0' ORDER BY NHANVIEN.MaNV ASC";
		ResultSet rs = null;
		Map<String, Object> mapTK;
		try {
			Statement stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				mapTK = new HashMap();
				mapTK.put("MaNV", rs.getString(1));
				mapTK.put("TenNV", rs.getString(2));
				mapTK.put("Anh", rs.getString(3));
				mapTK.put("NgaySinh", rs.getString(4));
				mapTK.put("GioiTinh", rs.getString(5));
				mapTK.put("DienThoai", rs.getString(6));
				mapTK.put("Email", rs.getString(7));
				mapTK.put("Diachi", rs.getString(8));
				mapTK.put("NgayDangKy", rs.getString(9));
				mapTK.put("NgayUpdate", rs.getString(10));
				mapTK.put("TrangThai", rs.getString(11));
				mapTK.put("TenPB", rs.getString(12));
				mapTK.put("TenCV", rs.getString(13));
				list.add(mapTK);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return list;
	}

	/**
	 * MoTa
	 * 
	 * @param maNV
	 * @return
	 */
	public int PhucHoiNV(String maNV) {
		Connection conn = ConnectDB.getConnection();
		String sql = String.format("UPDATE NHANVIEN SET TrangThai='1' WHERE MaNV='%s'", maNV);
		PreparedStatement statement = null;
		int rowCount = 0;

		try {
			statement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			int rs = statement.executeUpdate();
			if (rs != 0) {
				rowCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCount;
	}
	public List<Map<String, Object>> getListNhanVien() {
		Connection conn = ConnectDB.getConnection();
		List<Map<String, Object>> list = new ArrayList<>();
		String sql = "Select MaNV ,TenNV ,Anh ,NgaySinh ,GioiTinh ,DienThoai ,Email ,Diachi ,NgayDangKy ,NgayUpdate ,TrangThai,PHONGBAN.TenPB,\r\n" + 
				"CHUCVU.TenCV FROM NHANVIEN,PHONGBAN,CHUCVU WHERE NHANVIEN.MaPB=PHONGBAN.MaPB AND NHANVIEN.MaCV=CHUCVU.MaCV AND TrangThai='1' ORDER BY NHANVIEN.MaNV ASC ";
		ResultSet rs=null;
		 Map<String,Object> mapTK;
		try {
			 Statement stm=conn.createStatement();
			 rs=stm.executeQuery(sql);
				while (rs.next()) {
					mapTK = new HashMap();
					mapTK.put("MaNV", rs.getString(1));
					mapTK.put("TenNV", rs.getString(2));
					mapTK.put("Anh", rs.getString(3));
					mapTK.put("NgaySinh", rs.getString(4));
					mapTK.put("GioiTinh", rs.getString(5));
					mapTK.put("DienThoai", rs.getString(6));
					mapTK.put("Email", rs.getString(7));
					mapTK.put("Diachi", rs.getString(8));
					mapTK.put("NgayDangKy", rs.getString(9));
					mapTK.put("NgayUpdate", rs.getString(10));
					mapTK.put("TrangThai", rs.getString(11));
					mapTK.put("TenPB", rs.getString(12));
					mapTK.put("TenCV", rs.getString(13));
					list.add(mapTK);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return list;
	}
	public List<Map<String, Object>> getListPhongBan() {
		Connection conn = ConnectDB.getConnection();
		List<Map<String, Object>> lists = new ArrayList<>();
		String sql = "SELECT MaPB,TenPB FROM PHONGBAN";
		ResultSet rs=null;
		 Map<String,Object> mapTK;
		try {
			 Statement stm=conn.createStatement();
			 rs=stm.executeQuery(sql);
				while (rs.next()) {
					mapTK = new HashMap();
					mapTK.put("MaPB", rs.getString(1));
					mapTK.put("TenPB", rs.getString(2));
					lists.add(mapTK);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return lists;
	}
	/**
	 * MoTa
	 * @return
	 */ 
	public List<Map<String, Object>> getListChucVu() {
		Connection conn = ConnectDB.getConnection();
		List<Map<String, Object>> lists = new ArrayList<>();
		String sql = "SELECT MaCV,TenCV FROM CHUCVU";
		ResultSet rs=null;
		 Map<String,Object> mapTK;
		try {
			 Statement stm=conn.createStatement();
			 rs=stm.executeQuery(sql);
				while (rs.next()) {
					mapTK = new HashMap();
					mapTK.put("MaCV", rs.getString(1));
					mapTK.put("TenCV", rs.getString(2));
					lists.add(mapTK);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return lists;
	}
	public ArrayList<NhanVien> getNhanVien() {
		Connection conn = ConnectDB.getConnection();
		String sql=	"SELECT MaNV,TenNV FROM NHANVIEN";
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<NhanVien> list = new ArrayList<NhanVien>();
		NhanVien nhanvien;
		try {
			while(rs.next()){
				nhanvien = new NhanVien();
				nhanvien.setMaNV(rs.getString("MaNV"));
				nhanvien.setTenNV(rs.getString("TenNV"));
				list.add(nhanvien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
