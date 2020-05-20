/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import common.ConnectDB;
import model.bean.PhongBan;

/**
 * @author HP
 *
 */
public class PhongBanDao {
	public ArrayList<PhongBan> getListPB() {
		Connection conn = ConnectDB.getConnection();
		ArrayList<PhongBan> list = new ArrayList<>();
		String sql = "SELECT * FROM PHONGBAN";
		PreparedStatement stmt = null;
		PhongBan pb;

		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				pb = new PhongBan();
				pb.setMaPB(rs.getString(1));
				pb.setTenPB(rs.getString(2));
				pb.setSoDT(rs.getString(3));
				pb.setViTri(rs.getString(4));
				list.add(pb);
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
	 * @param pB
	 * @return
	 */ 
	public boolean Chen(PhongBan pB) {
		try {
			
			Connection con = ConnectDB.getConnection();
	        String  sql= "INSERT INTO PHONGBAN(MaPB,TenPB,SoDienThoai,ViTriPB) values (?,?,?,?)";
			 PreparedStatement stmt = con.prepareStatement(sql,ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
			 stmt.setString(1,pB.getMaPB());
			 stmt.setString(2, pB.getTenPB());
			 stmt.setString(3, pB.getSoDT());
			 stmt.setString(4, pB.getViTri());

			 int rs = stmt.executeUpdate();
			 if(rs!=0) 
				return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
        }
		
		return false;
	}

	/**
	 * MoTa
	 * @param phongBan
	 * @return
	 */ 
	public int updatePB(PhongBan pb) {
		Connection conn = ConnectDB.getConnection();
		String sql = "SELECT * FROM PHONGBAN WHERE MaPB = ?";
		PreparedStatement statement = null;
		int rowCount = 0;

		try {
			statement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			statement.setString(1, pb.getMaPB());
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				rs.updateString("MaPB",pb.getMaPB());
				rs.updateString("TenPB",pb.getTenPB());
				rs.updateString("SoDienThoai",pb.getSoDT());
				rs.updateString("ViTriPB",pb.getViTri());

				rs.updateRow();
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
	 * @param maPB
	 * @return
	 */ 
	public PhongBan getPhongBanById(String id) {
		Connection conn = ConnectDB.getConnection();
		String sql = "Select *  from PHONGBAN where MaPB = ?";
		PreparedStatement stmt = null;
		PhongBan tv = new PhongBan();

		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				tv.setMaPB(rs.getString(1));
				tv.setTenPB(rs.getString(2));
				tv.setSoDT(rs.getString(3));
				tv.setViTri(rs.getString(4));
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
		return tv;
	}

	/**
	 * MoTa
	 * @param maPB
	 * @return
	 */ 
	public int deletePB(String id) {
		Connection conn = ConnectDB.getConnection();
		String sql = "SELECT * FROM PHONGBAN WHERE MaPB  = ?";
		PreparedStatement statement = null;
		int rowCount = 0;
		try {
			statement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				result.deleteRow();
				rowCount++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block- 

				e.printStackTrace();
			}
		}
		return rowCount;
	}

	/**
	 * MoTa
	 * @param hoatDong
	 * @return
	 */ 
	
	

		
		
}	