
package model.bean;

/**
 * NhanVien.java
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
public class NhanVien {
	private String MaNV;
	private String TenNV ;
	private String Anh;
	private String NgaySinh;
	private String GioiTinh ;
	private String DienThoai ;
	private String Email ;
	private String Diachi ;
	private String NgayDangKy;
	private String NgayUpdate;
	private String TrangThai;
	private String MaPB ;
	private String MaCV;
	private String MaTaiKhoan;
	
	/**
	 * 
	 */
	public NhanVien() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maNV
	 * @param tenNV
	 * @param anh
	 * @param ngaySinh
	 * @param gioiTinh
	 * @param dienThoai
	 * @param email
	 * @param diachi
	 * @param ngayDangKy
	 * @param ngayUpdate
	 * @param trangThai
	 * @param maPB
	 * @param maCV
	 * @param maTaiKhoan
	 */
	public NhanVien(String maNV, String tenNV, String anh, String ngaySinh, String gioiTinh, String dienThoai,
			String email, String diachi, String ngayDangKy, String ngayUpdate, String trangThai, String maPB,
			String maCV, String maTaiKhoan) {
		super();
		MaNV = maNV;
		TenNV = tenNV;
		Anh = anh;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
		DienThoai = dienThoai;
		Email = email;
		Diachi = diachi;
		NgayDangKy = ngayDangKy;
		NgayUpdate = ngayUpdate;
		TrangThai = trangThai;
		MaPB = maPB;
		MaCV = maCV;
		MaTaiKhoan = maTaiKhoan;
	}

	/**
	 * @param maNV2
	 * @param tenNV2
	 * @param ngaySinh2
	 * @param gioiTinh2
	 * @param dienThoai2
	 * @param email2
	 * @param diachi2
	 * @param maPB2
	 * @param maCV2
	 * @param maTaiKhoan2
	 */
	public NhanVien(String maNV, String tenNV, String ngaySinh, String gioiTinh, String dienThoai, String email,
			String diachi, String maPB, String maCV, String maTaiKhoan) {
		MaNV = maNV;
		TenNV = tenNV;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
		DienThoai = dienThoai;
		Email = email;
		Diachi = diachi;
		MaPB = maPB;
		MaCV = maCV;
		MaTaiKhoan = maTaiKhoan;
	}

	/**
	 * @return the maNV
	 */
	public String getMaNV() {
		return MaNV;
	}

	/**
	 * @param maNV the maNV to set
	 */
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	/**
	 * @return the tenNV
	 */
	public String getTenNV() {
		return TenNV;
	}

	/**
	 * @param tenNV the tenNV to set
	 */
	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}

	/**
	 * @return the anh
	 */
	public String getAnh() {
		return Anh;
	}

	/**
	 * @param anh the anh to set
	 */
	public void setAnh(String anh) {
		Anh = anh;
	}

	/**
	 * @return the ngaySinh
	 */
	public String getNgaySinh() {
		return NgaySinh;
	}

	/**
	 * @param ngaySinh the ngaySinh to set
	 */
	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}

	/**
	 * @return the gioiTinh
	 */
	public String getGioiTinh() {
		return GioiTinh;
	}

	/**
	 * @param gioiTinh the gioiTinh to set
	 */
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	/**
	 * @return the dienThoai
	 */
	public String getDienThoai() {
		return DienThoai;
	}

	/**
	 * @param dienThoai the dienThoai to set
	 */
	public void setDienThoai(String dienThoai) {
		DienThoai = dienThoai;
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
	 * @return the diachi
	 */
	public String getDiachi() {
		return Diachi;
	}

	/**
	 * @param diachi the diachi to set
	 */
	public void setDiachi(String diachi) {
		Diachi = diachi;
	}

	/**
	 * @return the ngayDangKy
	 */
	public String getNgayDangKy() {
		return NgayDangKy;
	}

	/**
	 * @param ngayDangKy the ngayDangKy to set
	 */
	public void setNgayDangKy(String ngayDangKy) {
		NgayDangKy = ngayDangKy;
	}

	/**
	 * @return the ngayUpdate
	 */
	public String getNgayUpdate() {
		return NgayUpdate;
	}

	/**
	 * @param ngayUpdate the ngayUpdate to set
	 */
	public void setNgayUpdate(String ngayUpdate) {
		NgayUpdate = ngayUpdate;
	}

	/**
	 * @return the trangThai
	 */
	public String getTrangThai() {
		return TrangThai;
	}

	/**
	 * @param trangThai the trangThai to set
	 */
	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}

	/**
	 * @return the maPB
	 */
	public String getMaPB() {
		return MaPB;
	}

	/**
	 * @param maPB the maPB to set
	 */
	public void setMaPB(String maPB) {
		MaPB = maPB;
	}

	/**
	 * @return the maCV
	 */
	public String getMaCV() {
		return MaCV;
	}

	/**
	 * @param maCV the maCV to set
	 */
	public void setMaCV(String maCV) {
		MaCV = maCV;
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

	@Override
	public String toString() {
		return "NhanVien [MaNV=" + MaNV + ", TenNV=" + TenNV + ", Anh=" + Anh + ", NgaySinh=" + NgaySinh + ", GioiTinh="
				+ GioiTinh + ", DienThoai=" + DienThoai + ", Email=" + Email + ", Diachi=" + Diachi + ", NgayDangKy="
				+ NgayDangKy + ", NgayUpdate=" + NgayUpdate + ", TrangThai=" + TrangThai + ", MaPB=" + MaPB + ", MaCV="
				+ MaCV + ", MaTaiKhoan=" + MaTaiKhoan + "]";
	}
	
	
	
}
