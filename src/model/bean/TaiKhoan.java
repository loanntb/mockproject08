
package model.bean;

import model.dao.TaiKhoanDao;

/**
 * TaiKhoan.java
 *
 * Version 1.0 
 *
 * Date: 25-04-2020
 *
 * Copyright
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION				
 * -----------------------------------------------------------------------				
 * 25-04-2020           DungPT49            Create				
 */
public class TaiKhoan {

	private String MaTaiKhoan;
	private String Email;
	private String Matkhau;
	private int PhanQuyen;
	
	/**
	 * 
	 */
	public TaiKhoan() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maTaiKhoan
	 * @param email
	 * @param matkhau
	 * @param phanQuyen
	 */
	public TaiKhoan(String maTaiKhoan, String email, String matkhau, int phanQuyen) {
		super();
		MaTaiKhoan = maTaiKhoan;
		Email = email;
		Matkhau = matkhau;
		PhanQuyen = phanQuyen;
	}

	/**
	 * @param maTaiKhoan2
	 * @param email2
	 * @param matkhau2
	 * @param phanQuyen2
	 */
	public TaiKhoan(String maTaiKhoan, String email, String matkhau, String phanQuyen) {
		MaTaiKhoan = maTaiKhoan;
		Email = email;
		Matkhau = matkhau;
		PhanQuyen = Integer.parseInt(phanQuyen);
	}

	/**
	 * @return the maTaiKhoan
	 */
	public String getMaTaiKhoan() {
		return MaTaiKhoan;
	}

	/**
	 * @param maTaiKhoan the maTaiKhoan to set
	 */
	public void setMaTaiKhoan(String maTaiKhoan) {
		MaTaiKhoan = maTaiKhoan;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}

	/**
	 * @return the matkhau
	 */
	public String getMatkhau() {
		return Matkhau;
	}

	/**
	 * @param matkhau the matkhau to set
	 */
	public void setMatkhau(String matkhau) {
		Matkhau = matkhau;
	}

	/**
	 * @return the phanQuyen
	 */
	public int getPhanQuyen() {
		return PhanQuyen;
	}

	/**
	 * @param phanQuyen the phanQuyen to set
	 */
	public void setPhanQuyen(int phanQuyen) {
		PhanQuyen = phanQuyen;
	}
	
	@Override
	public String toString() {
		return "TaiKhoan [MaTaiKhoan=" + MaTaiKhoan + ", Email=" + Email + ", Matkhau=" + Matkhau + ", PhanQuyen="
				+ PhanQuyen + "]";
	}
	

}
