package model.bean;

/**
 * HoHVan.java
 *
 * Version 1.0
 *
 * Date: 26-04-2020
 *
 * Copyright
 *
 * Modification Logs: DATE AUTHOR DESCRIPTION
 * -----------------------------------------------------------------------
 * 26-04-2020 LoanNTB Create
 */
public class HocVan {
	private String maHV;
	private String tenHV;
	private String maNV;

	/**
	 * @return the maHV
	 */
	public String getMaHV() {
		return maHV;
	}

	/**
	 * @param maHV
	 *            the maHV to set
	 */
	public void setMaHV(String maHV) {
		this.maHV = maHV;
	}

	/**
	 * @return the tenHV
	 */
	public String getTenHV() {
		return tenHV;
	}

	/**
	 * @param tenHV
	 *            the tenHV to set
	 */
	public void setTenHV(String tenHV) {
		this.tenHV = tenHV;
	}

	/**
	 * @return the maNV
	 */
	public String getMaNV() {
		return maNV;
	}

	/**
	 * @param maNV
	 *            the maNV to set
	 */
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	/**
	 * 
	 */
	public HocVan() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maHV
	 * @param tenHV
	 * @param maNV
	 */
	public HocVan(String maHV, String tenHV, String maNV) {
		this.maHV = maHV;
		this.tenHV = tenHV;
		this.maNV = maNV;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HocVan [maHV=" + maHV + ", tenHV=" + tenHV + ", maNV=" + maNV + "]";
	}

}
