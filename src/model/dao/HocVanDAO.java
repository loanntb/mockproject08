package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import common.ConnectDB;
import model.bean.HocVan;

public class HocVanDAO {
	public ArrayList<HocVan> getListHV() {
		Connection conn = ConnectDB.getConnection();
		ArrayList<HocVan> list = new ArrayList<>();
		String sql = "SELECT * FROM TRINHDOHOCVAN";
		PreparedStatement stmt = null;
		HocVan hv;

		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				hv = new HocVan();
				hv.setMaHV(rs.getString(1));
				hv.setTenHV(rs.getString(2));
				hv.setMaNV(rs.getString(3));
				list.add(hv);
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

	public boolean Chen(HocVan hv) {
		try {

			Connection con = ConnectDB.getConnection();
			String sql = "INSERT INTO TRINHDOHOCVAN(MaHV,TenHV,MaNV ) values (?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, hv.getMaHV());
			stmt.setString(2, hv.getTenHV());
			stmt.setString(3, hv.getMaNV());
			int rs = stmt.executeUpdate();
			if (rs != 0)
				return true;
		} catch (SQLException ex) {
			Logger.getLogger(HocVanDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	public int updateHV(HocVan hv) {
		Connection conn = ConnectDB.getConnection();
		String sql = "SELECT * FROM TRINHDOHOCVAN WHERE MaHV = ?";
		PreparedStatement statement = null;
		int rowCount = 0;

		try {
			statement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			statement.setString(1, hv.getMaHV());
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				rs.updateString("MaHV", hv.getMaHV());
				rs.updateString("TenHV", hv.getTenHV());
				rs.updateString("MaNV", hv.getMaNV());
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

	public int deleteHV(String id) {
		Connection conn = ConnectDB.getConnection();
		String sql = "SELECT * FROM TRINHDOHOCVAN WHERE Mahv  = ?";
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
				// TODO Auto-generated catch block

				e.printStackTrace();
			}
		}
		return rowCount;
	}

	public HocVan getHocVanById(String id) {
		Connection conn = ConnectDB.getConnection();
		String sql = "Select *  from TRINHDOHOCVAN where MaHV = ?";
		PreparedStatement stmt = null;
		HocVan hv = new HocVan();

		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				hv.setMaHV(rs.getString(1));
				hv.setTenHV(rs.getString(2));
				hv.setMaNV(rs.getString(3));
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
		return hv;
	}
	
	public HocVan getHocVanByMaNV(String id) {
		Connection conn = ConnectDB.getConnection();
		String sql = "Select *  from TRINHDOHOCVAN where MaNV = ?";
		PreparedStatement stmt = null;
		HocVan hv = new HocVan();

		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			stmt.setString(3, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				hv.setMaHV(rs.getString(1));
				hv.setTenHV(rs.getString(2));
				hv.setMaNV(rs.getString(3));
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
		return hv;
	}

}
