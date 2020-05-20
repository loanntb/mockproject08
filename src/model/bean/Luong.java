/**
 * 
 */
package model.bean;

/**
 * @author TINNH5
 *
 */
public class Luong {
	private String maLuong;
	private String maNV;
	private String tenNV;
	private float heSL;
	private int luongCB;
	private int phuCap;
	private java.sql.Timestamp ngayThanhToan;
	public String getMaLuong() {
		return maLuong;
	}
	public void setNgayThanhToan(java.sql.Timestamp ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}
	public java.sql.Timestamp getNgayThanhToan() {
		return ngayThanhToan;
	}
	public void setMaLuong(String maLuong) {
		this.maLuong = maLuong;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public float getHeSL() {
		return heSL;
	}
	public void setHeSL(float heSL) {
		this.heSL = heSL;
	}
	public int getLuongCB() {
		return luongCB;
	}
	public void setLuongCB(int luongCB) {
		this.luongCB = luongCB;
	}
	public int getPhuCap() {
		return phuCap;
	}
	public void setPhuCap(int phuCap) {
		this.phuCap = phuCap;
	}
	public Luong(String maLuong, String maNV, String tenNV, float heSL, int luongCB, int phuCap) {
		super();
		this.maLuong = maLuong;
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.heSL = heSL;
		this.luongCB = luongCB;
		this.phuCap = phuCap;
	}
	
	public Luong() {
		super();
	}
}
