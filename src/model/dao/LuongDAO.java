/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import common.ConnectDB;
import model.bean.Luong;
/**
 * @author TINNH5
 *
 */
public class LuongDAO {

	public static ArrayList<Luong> getListLuong() {
		Connection conn = ConnectDB.getConnection();
		String sql=	"SELECT LUONG.MaLuong,LUONG.MaNV,NHANVIEN.TenNV,LUONG.MaNV,LUONG.HeSoLuong,LUONG.LuongCoBan,LUONG.LuongPhuCap FROM LUONG INNER JOIN NHANVIEN ON NHANVIEN.MaNV = LUONG.MaNV WHERE LUONG.TrangThai = 1";
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<Luong> list = new ArrayList<Luong>();
		Luong luong;
		try {
			while(rs.next()){
				luong = new Luong();
				luong.setMaLuong(rs.getString("MaLuong"));
				luong.setMaNV(rs.getString("MaNV"));
				luong.setTenNV(rs.getString("TenNV"));
				luong.setHeSL(rs.getFloat("HeSoLuong"));
				luong.setLuongCB(rs.getInt("LuongCoBan"));
				luong.setPhuCap(rs.getInt("LuongPhuCap"));
				list.add(luong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Luong> getListLuong(String maLuong) {
		Connection conn = ConnectDB.getConnection();
		String sql=	String.format("SELECT LUONG.MaLuong,LUONG.MaNV,NHANVIEN.TenNV,LUONG.MaNV,LUONG.HeSoLuong,LUONG.LuongCoBan,LUONG.LuongPhuCap FROM LUONG INNER JOIN NHANVIEN ON NHANVIEN.MaNV = LUONG.MaNV WHERE LUONG.TrangThai = 1 AND LUONG.MaLuong = '%s'", maLuong);
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<Luong> list = new ArrayList<Luong>();
		Luong luong;
		try {
			while(rs.next()){
				luong = new Luong();
				luong.setMaLuong(rs.getString("MaLuong"));
				luong.setMaNV(rs.getString("MaNV"));
				luong.setTenNV(rs.getString("TenNV"));
				luong.setHeSL(rs.getFloat("HeSoLuong"));
				luong.setLuongCB(rs.getInt("LuongCoBan"));
				luong.setPhuCap(rs.getInt("LuongPhuCap"));
				list.add(luong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Luong> getListLuong123(String manv) {
		Connection conn = ConnectDB.getConnection();
		String sql=	String.format("SELECT LUONG.MaLuong,LUONG.MaNV,NHANVIEN.TenNV,LUONG.MaNV,LUONG.HeSoLuong,LUONG.LuongCoBan,LUONG.LuongPhuCap FROM LUONG INNER JOIN NHANVIEN ON NHANVIEN.MaNV = LUONG.MaNV WHERE LUONG.TrangThai = 1 AND LUONG.MaNV = '%s'", manv);
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<Luong> list = new ArrayList<Luong>();
		Luong luong;
		try {
			while(rs.next()){
				luong = new Luong();
				luong.setMaLuong(rs.getString("MaLuong"));
				luong.setMaNV(rs.getString("MaNV"));
				luong.setTenNV(rs.getString("TenNV"));
				luong.setHeSL(rs.getFloat("HeSoLuong"));
				luong.setLuongCB(rs.getInt("LuongCoBan"));
				luong.setPhuCap(rs.getInt("LuongPhuCap"));
				list.add(luong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static boolean themLuong(String maLuong, String maNV, Float heSoLuong, int luongCoBan, int phuCap,int trangThai) {
		try {
			Connection conn = ConnectDB.getConnection();
			String sql=	String.format("INSERT INTO LUONG(MaLuong,MaNV,HeSoLuong,LuongCoBan,LuongPhuCap,TrangThai) "+
					" VALUES ('%s','%s',%f,%d,%d,%d)", maLuong, maNV, heSoLuong, luongCoBan,phuCap,trangThai);
			Statement stmt = conn.createStatement();
			 int rs = stmt.executeUpdate(sql);
			 if(rs!=0) 
				return true;
		} catch (SQLException ex) {
            Logger.getLogger(LuongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
		return false;
		
	}
	public static boolean suaLuong(String maLuong, String maNV, Float heSoLuong, int luongCoBan, int phuCap,
			int trangThai) {
		try {
			Connection conn = ConnectDB.getConnection();
			String sql=	String.format("UPDATE LUONG "+
						" SET MaNV = '%s', HeSoLuong = %f, LuongCoBan = %d, LuongPhuCap = %d,TrangThai = %d" +
						" WHERE maLuong = '%s'", maNV, heSoLuong, luongCoBan, phuCap, trangThai, maLuong);
			Statement stmt = conn.createStatement();
			 int rs = stmt.executeUpdate(sql);
			 if(rs!=0) 
				return true;
		} catch (SQLException ex) {
			Logger.getLogger(LuongDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
	public static Luong getThongTinLuong(String maLuong) {
		Connection conn = ConnectDB.getConnection();
		String sql=	String.format("SELECT LUONG.MaLuong,LUONG.MaNV,NHANVIEN.TenNV,LUONG.MaNV,LUONG.HeSoLuong,LUONG.LuongCoBan,LUONG.LuongPhuCap"+
					" FROM LUONG INNER JOIN NHANVIEN ON NHANVIEN.MaNV = LUONG.MaNV WHERE LUONG.TrangThai = 1 AND LUONG.MaLuong = '%s'", maLuong);
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Luong luong = new Luong();
		try {
			while(rs.next()){
				luong.setMaLuong(maLuong);
				luong.setTenNV(rs.getString("TenNV"));
				luong.setMaNV(rs.getString("MaNV"));
				luong.setHeSL(rs.getFloat("HeSoLuong"));
				luong.setLuongCB(rs.getInt("LuongCoBan"));
				luong.setPhuCap(rs.getInt("LuongPhuCap"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return luong;
	}
	public static boolean xoaLuong(String maLuong) {
		try {
			Connection conn = ConnectDB.getConnection();
			String sql=	String.format("UPDATE LUONG SET TrangThai = 0 WHERE MaLuong = '%s'", maLuong);
			Statement stmt = conn.createStatement();
			 int rs = stmt.executeUpdate(sql);
			 if(rs!=0) 
				return true;
		} catch (SQLException ex) {
			Logger.getLogger(LuongDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
	public ArrayList<Luong> getListLuongRestore() {
		Connection conn = ConnectDB.getConnection();
		String sql=	"SELECT LUONG.MaLuong,LUONG.MaNV,NHANVIEN.TenNV,LUONG.MaNV,LUONG.HeSoLuong,LUONG.LuongCoBan,LUONG.LuongPhuCap FROM LUONG INNER JOIN NHANVIEN ON NHANVIEN.MaNV = LUONG.MaNV WHERE LUONG.TrangThai = 0";
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<Luong> list = new ArrayList<Luong>();
		Luong luong;
		try {
			while(rs.next()){
				luong = new Luong();
				luong.setMaLuong(rs.getString("MaLuong"));
				luong.setMaNV(rs.getString("MaNV"));
				luong.setTenNV(rs.getString("TenNV"));
				luong.setHeSL(rs.getFloat("HeSoLuong"));
				luong.setLuongCB(rs.getInt("LuongCoBan"));
				luong.setPhuCap(rs.getInt("LuongPhuCap"));
				list.add(luong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static boolean phuchoiLuong(String maLuong) {
		try {
			Connection conn = ConnectDB.getConnection();
			String sql=	String.format("UPDATE LUONG SET TrangThai = 1 WHERE MaLuong = '%s'", maLuong);
			Statement stmt = conn.createStatement();
			 int rs = stmt.executeUpdate(sql);
			 if(rs!=0) 
				return true;
		} catch (SQLException ex) {
			Logger.getLogger(LuongDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
	public static boolean xoaluongALL(String maLuong) {
		try {
			Connection conn = ConnectDB.getConnection();
			String sql=	String.format("DELETE FROM LUONG WHERE MaLuong = '%s'", maLuong);
			Statement stmt = conn.createStatement();
			 int rs = stmt.executeUpdate(sql);
			 if(rs!=0) 
				return true;
		} catch (SQLException ex) {
			Logger.getLogger(LuongDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
	public ArrayList<Luong> getListDaThanhToanLuong() {
		Connection conn = ConnectDB.getConnection();
		String sql=	"  SELECT LUONG.MaNV,LUONG.MaLuong, NHANVIEN.TenNV,LICHSUTHANHTOAN.NgayThanhToan FROM LUONG INNER JOIN NHANVIEN ON NHANVIEN.MaNV = LUONG.MaNV INNER JOIN LICHSUTHANHTOAN ON LICHSUTHANHTOAN.MaLuong = LUONG.MaLuong WHERE LUONG.MaNV IN (SELECT MaNV FROM LICHSUTHANHTOAN)";
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<Luong> list = new ArrayList<Luong>();
		Luong luong;
		try {
			while(rs.next()){
				luong = new Luong();
				luong.setMaNV(rs.getString("MaNV"));
				luong.setMaLuong(rs.getString("MaLuong"));
				luong.setTenNV(rs.getString("TenNV"));
				luong.setNgayThanhToan(rs.getTimestamp("NgayThanhToan"));
				list.add(luong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Luong> getListChuaThanhToanLuong() {
			Connection conn = ConnectDB.getConnection();
			String sql=	"SELECT LUONG.MaNV,NHANVIEN.TenNV,LUONG.MaLuong FROM LUONG INNER JOIN NHANVIEN ON NHANVIEN.MaNV = LUONG.MaNV WHERE LUONG.MaNV NOT IN(SELECT MaNV FROM LICHSUTHANHTOAN)";
			ResultSet rs = null;
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			ArrayList<Luong> list = new ArrayList<Luong>();
			Luong luong;
			try {
				while(rs.next()){
					luong = new Luong();
					luong.setMaLuong(rs.getString("MaLuong"));
					luong.setMaNV(rs.getString("MaNV"));
					luong.setTenNV(rs.getString("TenNV"));
					list.add(luong);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
	}
	public static boolean thanhToanLuong(String maLuong, String maNV) {
		try {
			Connection conn = ConnectDB.getConnection();
			String sql=	String.format("INSERT INTO LICHSUTHANHTOAN(MaLuong,MaNV,NgayThanhToan) "+
					" VALUES ('%s','%s',GETDATE())", maLuong, maNV);
			Statement stmt = conn.createStatement();
			 int rs = stmt.executeUpdate(sql);
			 if(rs!=0) 
				return true;
		} catch (SQLException ex) {
            Logger.getLogger(LuongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
		return false;
	}
}
