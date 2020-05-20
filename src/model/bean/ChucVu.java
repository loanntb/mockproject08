package model.bean;

/**
 * CHUCVU.java
 *
 * Version 1.0
 *
 * Date: 25-04-2020
 *
 * Copyright
 *
 * Modification Logs: DATE AUTHOR DESCRIPTION
 * -----------------------------------------------------------------------
 * 25-04-2020 LoanNTB Create
 */
public class ChucVu {
	private String maCV;
	private String tenCV;

	/**
	 * @return the maCV
	 */
	public String getMaCV() {
		return maCV;
	}

	/**
	 * @param maCV
	 *            the maCV to set
	 */
	public void setMaCV(String maCV) {
		this.maCV = maCV;
	}

	/**
	 * @return the tenCV
	 */
	public String getTenCV() {
		return tenCV;
	}

	/**
	 * @param tenCV
	 *            the tenCV to set
	 */
	public void setTenCV(String tenCV) {
		this.tenCV = tenCV;
	}

	/**
	 * 
	 */
	public ChucVu() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maCV
	 * @param tenCV
	 */
	public ChucVu(String maCV, String tenCV) {
		this.maCV = maCV;
		this.tenCV = tenCV;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CHUCVU [maCV=" + maCV + ", tenCV=" + tenCV + "]";
	}

}
