
package model.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.bean.NhanVien;
import model.dao.NhanVienDao;

/**
 * NhanVienBO.java
 *
 * Version 1.0 
 *
 * Date: 26-04-2020
 *
 * Copyright
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION				
 * -----------------------------------------------------------------------				
 * 26-04-2020           DungPT49            Create				
 */
public class NhanVienBO {
	NhanVienDao nhanVienDao = new NhanVienDao();
	NhanVien nhanVien = new NhanVien();
	/**
	 * MoTa
	 * @param maTaiKhoan
	 * @return
	 */
	public NhanVien getByID(String maTaiKhoan) {
		 nhanVien= nhanVienDao.getByID(maTaiKhoan);
		return nhanVien ;
	}
	

	public ArrayList<NhanVien> getListNhanVienHV() {
		return nhanVienDao.getListNhanVienHV();
	}
	public List<Map<String, Object>> getListNhanVien() {
		List<Map<String, Object>> list = nhanVienDao.getListNhanVien();	
		return list;
	}

	/**
	 * getListPhongBan
	 * @return Lists
	 */ 
	public List<Map<String, Object>> getListPhongBan() {
		List<Map<String, Object>> lists = nhanVienDao.getListPhongBan();
		return lists;
	
	}

	/**
	 * MoTa
	 * @return
	 */ 
	public List<Map<String, Object>> getListChucVu() {
		List<Map<String, Object>> lists = nhanVienDao.getListChucVu();
		return lists;
	}

	/**
	 * MoTa
	 * @return
	 */ 
	public Object createNhanVienMa() {
		List<Map<String, Object>> list = new ArrayList<>();
	        list = nhanVienDao.getListNhanVien();
	        int index = list.size() - 1;
	        String maNV = (String) list.get(index).get("MaNV");
	        int temp = Integer.parseInt(maNV.substring(2));
	        temp += 1;
	        String temp2 = String.valueOf(temp);
	        if (temp2.length() == 1) {
	        	maNV = "NV00" + temp2;
	        } else if (temp2.length() == 2) {
	        	maNV = "NV0" + temp2;
	        } else if (temp2.length() == 3) {
	        	maNV = "NV" + temp2;
	        }
	        return maNV;
	
	}

	/**
	 * MoTa
	 * @param maNV
	 * @param tenNV
	 * @param gioiTinh
	 * @param ngaySinh
	 * @param email
	 * @param diaChi
	 * @param soDienThoai
	 * @param maPB
	 * @param maCV
	 * @param maTK
	 * @return
	 */ 
	public boolean InsertNhanVien(String maNV,String tenNV,String ngaySinh,String gioiTinh,String dienThoai,String email,String diachi,String maPB,String maCV,String maTaiKhoan) {
		NhanVien NV=new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, dienThoai, email, diachi, maPB, maCV, maTaiKhoan);
				if(nhanVienDao.InsertNhanVien(NV)==true)
					return true;
				return false;
	}

	/**
	 * MoTa
	 * @param maNV 
	 * @param tenanh
	 * @return
	 */ 
	
	
	/**
	 * MoTa
	 * @param maNV
	 * @return
	 */ 
	public NhanVien getNhanVienById(String maNV) {
		return nhanVienDao.getNhanVienById(maNV);
	}

	/**
	 * MoTa
	 * @param tenanh
	 * @param maNV
	 */ 
	public void edithinhanh(String tenanh, String maNV) {
		nhanVienDao.edithinhanh(tenanh,maNV);
		
	}

	/**
	 * MoTa
	 * @param maNV
	 * @param tenNV
	 * @param ngaySinh
	 * @param gioiTinh
	 * @param dienThoai
	 * @param email
	 * @param diachi
	 * @param maPB
	 * @param maCV
	 */ 
	public void editthongtinnhanvien(String maNV, String tenNV, String ngaySinh, String gioiTinh, String dienThoai,
			String email, String diachi, String maPB, String maCV) {
		nhanVienDao.editthongtinnhanvien(maNV,tenNV,ngaySinh,gioiTinh,dienThoai,email,diachi,maPB,maCV);
		
	}

	/**
	 * MoTa
	 * @param maNV
	 * @return
	 */ 
	public boolean XoaNV(String maNV) {
		if (nhanVienDao.XoaNV(maNV) == 1)
			return true;
		return false;
	}

	/**
	 * MoTa
	 * @return
	 */ 
	public List<Map<String, Object>> getListNhanViendaxoa() {
		List<Map<String, Object>> list = nhanVienDao.getListNhanViendaxoa();	
		return list;
	}

	/**
	 * MoTa
	 * @param maNV
	 * @return
	 */ 
	public boolean PhucHoiNV(String maNV) {
		if (nhanVienDao.PhucHoiNV(maNV) == 1)
			return true;
		return false;
	}

	
	public ArrayList<NhanVien> getNhanVien() {
		return nhanVienDao.getNhanVien();
	}

	
}
