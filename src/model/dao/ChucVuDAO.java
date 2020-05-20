package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import common.ConnectDB;
import model.bean.ChucVu;

public class ChucVuDAO {
	public ArrayList<ChucVu> getListCV() {
		Connection conn = ConnectDB.getConnection();
		ArrayList<ChucVu> list = new ArrayList<>();
		String sql = "SELECT * FROM CHUCVU";
		PreparedStatement stmt = null;
		ChucVu cv;

		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				cv = new ChucVu();
				cv.setMaCV(rs.getString(1));
				cv.setTenCV(rs.getString(2));

				list.add(cv);
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

	public boolean Chen(ChucVu CV) {
		try {

			Connection con = ConnectDB.getConnection();
			String sql = "INSERT INTO CHUCVU(MaCV,TenCV) values (?,?)";
			PreparedStatement stmt = con.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, CV.getMaCV());
			stmt.setString(2, CV.getTenCV());
			int rs = stmt.executeUpdate();
			if (rs != 0)
				return true;
		} catch (SQLException ex) {
			Logger.getLogger(ChucVuDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	public int updateCV(ChucVu CV) {
		Connection conn = ConnectDB.getConnection();
		String sql = "SELECT * FROM ChucVu WHERE MaCV = ?";
		PreparedStatement statement = null;
		int rowCount = 0;

		try {
			statement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			statement.setString(1, CV.getMaCV());
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				rs.updateString("MaCV", CV.getMaCV());
				rs.updateString("TenCV", CV.getTenCV());
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

	public int deleteCV(String id) {
		Connection conn = ConnectDB.getConnection();
		String sql = "SELECT * FROM CHUCVU WHERE MaCV  = ?";
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

	public ChucVu getChucVuById(String id) {
		Connection conn = ConnectDB.getConnection();
		String sql = "Select *  from CHUCVU where MaCV = ?";
		PreparedStatement stmt = null;
		ChucVu cv = new ChucVu();

		try {
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				cv.setMaCV(rs.getString(1));
				cv.setTenCV(rs.getString(2));
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
		return cv;
	}

}
