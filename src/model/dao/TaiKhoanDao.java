
package model.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.ConnectDB;
import model.bean.TaiKhoan;

/**
 * TaiKhoanDao.java
 *
 * Version 1.0
 *
 * Date: 25-04-2020
 *
 * Copyright
 *
 * Modification Logs: DATE AUTHOR DESCRIPTION
 * -----------------------------------------------------------------------
 * 25-04-2020 DungPT49 Create
 */
public class TaiKhoanDao {

	public TaiKhoan getTaiKhoanByEmail(String email) {
		Connection conn = ConnectDB.getConnection();
		String sql = "SELECT *  FROM TAIKHOAN where Email = ?";
		PreparedStatement stmt = null;
		TaiKhoan tk = new TaiKhoan();

		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				tk.setMaTaiKhoan(rs.getString(1));
				tk.setEmail(rs.getString(2));
				tk.setMatkhau(rs.getString(3));
				tk.setPhanQuyen(rs.getInt(4));
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
		return tk;
	}

	/**
	 * MoTa
	 * 
	 * @return
	 */
	public ArrayList<TaiKhoan> getListTaiKhoan() {
		Connection conn = ConnectDB.getConnection();
		String sql = "SELECT MaTaiKhoan,Email,Matkhau,PhanQuyen FROM TAIKHOAN";
		ArrayList<TaiKhoan> list = new ArrayList<TaiKhoan>();
		PreparedStatement stmt = null;
		TaiKhoan tk;
		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				tk = new TaiKhoan();
				tk.setMaTaiKhoan(rs.getString(1));
				tk.setEmail(rs.getString(2));
				tk.setMatkhau(rs.getString(3));
				tk.setPhanQuyen(rs.getInt(4));
				list.add(tk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * MoTa
	 * 
	 * @param tK
	 * @return
	 */
	public boolean InsertTaiKhoan(TaiKhoan tK) {
		Connection conn = ConnectDB.getConnection();
		String sql = "INSERT TAIKHOAN(MaTaiKhoan,Email,Matkhau,PhanQuyen) VALUES(?,?,?,?)";
		String password = tK.getMatkhau();
		String matkhau = getMD5(password);
		try {
			PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, tK.getMaTaiKhoan());
			stmt.setString(2, tK.getEmail());
			stmt.setString(3, matkhau);
			stmt.setInt(4, tK.getPhanQuyen());
			int rs = stmt.executeUpdate();
			System.out.println("du lieu:" + rs);
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
	 * @return
	 */
	public List<Map<String, Object>> getListDachSachTaiKhoan() {
		Connection conn = ConnectDB.getConnection();
		List<Map<String, Object>> list = new ArrayList<>();
		String sql = "Select MaTaiKhoan ,Email ,Matkhau,Phanquyen  FROM TaiKhoan";
		ResultSet rs = null;
		Map<String, Object> mapTK;
		try {
			Statement stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				mapTK = new HashMap();
				mapTK.put("MaTaiKhoan", rs.getString(1));
				mapTK.put("Email", rs.getString(2));
				mapTK.put("Matkhau", rs.getString(3));
				mapTK.put("Phanquyen", rs.getString(4));
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
	 * @param maTK
	 * @return
	 */
	public TaiKhoan getTaiKhoanById(String maTK) {
		Connection conn = ConnectDB.getConnection();
		String sql = "Select *  from TAIKHOAN where MaTaiKhoan = ?";
		PreparedStatement stmt = null;

		TaiKhoan taiKhoan = new TaiKhoan();

		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, maTK);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				taiKhoan.setMaTaiKhoan(rs.getString("MaTaiKhoan"));
				taiKhoan.setEmail(rs.getString("Email"));
				taiKhoan.setMatkhau(rs.getString("Matkhau"));
				taiKhoan.setPhanQuyen(rs.getInt("Phanquyen"));
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
		return taiKhoan;
	}

	/**
	 * MoTa
	 * 
	 * @param maTK
	 * @param email
	 * @param matKhau
	 * @param phanQuyen
	 */

	public void editthongtintaikhoan(String maTK, String email, String matKhau, String phanQuyen) {
		Connection conn = ConnectDB.getConnection();
		String password = matKhau;
		String matkhaumahoa = getMD5(password);
		String sql = String.format("UPDATE TAIKHOAN SET Email='%s',Matkhau='%s',Phanquyen='%s' WHERE MaTaiKhoan='%s'",
				email, matkhaumahoa, phanQuyen, maTK);

		try {
			Statement stm = conn.createStatement();
			stm.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			return convertByteToHex(messageDigest);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public static String convertByteToHex(byte[] data) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

}
