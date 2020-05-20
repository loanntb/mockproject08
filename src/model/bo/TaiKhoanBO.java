
package model.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.bean.TaiKhoan;
import model.dao.TaiKhoanDao;

/**
 * TaiKhoanBO.java
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
public class TaiKhoanBO {
	TaiKhoanDao taiKhoanDao = new TaiKhoanDao();
	
	/**
	 * Kiem tra dang nhap
	 * @param email
	 * @param matKhau
	 * @return
	 */
	public TaiKhoan Login(String email, String matKhau) {
		try {
			TaiKhoan taiKhoan =taiKhoanDao.getTaiKhoanByEmail(email); 
		if(taiKhoan!=null && taiKhoan.getMatkhau().equals(matKhau)==true) 
				return taiKhoan;

		} catch (Exception e) {
			return null;
		}
		return null;
	}

	
	/**
	 * MoTa
	 * @param recipient
	 * @return
	 */
	public TaiKhoan ForgotPass(String recipient) {
		try {
			TaiKhoan taiKhoan =taiKhoanDao.getTaiKhoanByEmail(recipient); 
			System.out.println(taiKhoan.getMaTaiKhoan());
			if(taiKhoan!= null)
				return taiKhoan;
		} catch (Exception e) {
			return null;
		}
		return null;
	}public Object createMaTaiKhoan() {
		  ArrayList<TaiKhoan> list = new ArrayList<>();
	        list = taiKhoanDao.getListTaiKhoan();
	        int index = list.size() - 1;
	        String maTK = list.get(index).getMaTaiKhoan();
	        int temp = Integer.parseInt(maTK.substring(2));
	        temp += 1;
	        String temp2 = String.valueOf(temp);
	        if (temp2.length() == 1) {
	        	maTK = "TK00" + temp2;
	        } else if (temp2.length() == 2) {
	        	maTK = "TK0" + temp2;
	        } else if (temp2.length() == 3) {
	        	maTK = "TK" + temp2;
	        }
	        return maTK;
	}

	/**
	 * MoTa
	 * @param maTaiKhoan
	 * @param tenTK
	 * @param matkhau
	 * @param phanQuyen
	 * @return
	 */ 
	public boolean InsertTaiKhoan(String maTaiKhoan, String email, String matkhau, String phanQuyen) {
		TaiKhoan TK=new TaiKhoan(maTaiKhoan, email, matkhau, phanQuyen);
		if(taiKhoanDao.InsertTaiKhoan(TK)==true)
			return true;
		return false;
	}

	/**
	 * MoTa
	 * @return
	 */ 
	public List<Map<String, Object>> getListTaiKhoan() {
		List<Map<String, Object>> list = taiKhoanDao.getListDachSachTaiKhoan();	
		return list;
	}

	/**
	 * MoTa
	 * @param maTK
	 * @return
	 */ 
	public TaiKhoan getTaiKhoanById(String maTK) {
		return taiKhoanDao.getTaiKhoanById(maTK);
	}

	/**
	 * MoTa
	 * @param maTK
	 * @param email
	 * @param matKhau
	 * @param phanQuyen
	 */ 
	public void editthongtintaikhoan(String maTK, String email, String matKhau, String phanQuyen) {
		taiKhoanDao.editthongtintaikhoan(maTK,email,matKhau,phanQuyen);
		
	}
}
