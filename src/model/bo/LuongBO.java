/**
 * 
 */
package model.bo;
import java.util.ArrayList;
import model.bean.Luong;
import model.dao.LuongDAO;
/**
 * @author TINNH5
 *
 */
public class LuongBO {
	LuongDAO luongDAO = new LuongDAO();
	public ArrayList<Luong> getListLuong() {
		return luongDAO.getListLuong();
	}
	
	public ArrayList<Luong> getListLuongRestore() {
		return luongDAO.getListLuongRestore();
	}
	
	public ArrayList<Luong> getListDaThanhToanLuong(){
		return luongDAO.getListDaThanhToanLuong();
	}
	
	public ArrayList<Luong> getListChuaThanhToanLuong(){
		return luongDAO.getListChuaThanhToanLuong();
	}
	
	public ArrayList<Luong> getListLuong123(String manv) {
		return luongDAO.getListLuong123(manv);
	}
	public ArrayList<Luong> getListLuong(String maLuong) {
		return luongDAO.getListLuong(maLuong);
	}
	
	public Luong getThongTinLuong(String maLuong) {
		return LuongDAO.getThongTinLuong(maLuong);
	}
	
	public static boolean themLuong(String maLuong, String maNV, Float heSoLuong, int luongCoBan, int phuCap,int trangThai) {
		return	LuongDAO.themLuong(maLuong, maNV, heSoLuong, luongCoBan, phuCap,trangThai);
	}
	
	public static boolean suaLuong(String maLuong, String maNV, Float heSoLuong, int luongCoBan, int phuCap,int trangThai) {
		return	LuongDAO.suaLuong(maLuong, maNV, heSoLuong, luongCoBan, phuCap,trangThai);
	}
	
	public static boolean xoaLuong(String maLuong) {
		return LuongDAO.xoaLuong(maLuong);
	}
	
	public static boolean phuchoiLuong(String maLuong) {
		return LuongDAO.phuchoiLuong(maLuong);
	}
	
	public static boolean xoaluongALL(String maLuong) {
		return LuongDAO.xoaluongALL(maLuong);
	}

	public Object createLuongMa() {
		  ArrayList<Luong> list = new ArrayList<>();
	        list = LuongDAO.getListLuong();
	        int index = list.size() - 1;
	        String maL = list.get(index).getMaLuong();
	        int temp = Integer.parseInt(maL.substring(2));
	        temp += 1;
	        String temp2 = String.valueOf(temp);
	        if (temp2.length() == 1) {
	        	maL = "L00" + temp2;
	        } else if (temp2.length() == 2) {
	        	maL = "L0" + temp2;
	        } else if (temp2.length() == 3) {
	        	maL = "L" + temp2;
	        }
	        return maL;
	}
}
