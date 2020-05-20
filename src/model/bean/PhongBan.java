
package model.bean;

/**
 * PhongBan.java
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
 * 25-04-2020           TaiTQS            Create               
 */
public class PhongBan {	
			private String MaPB;
			private String TenPB;
			private String SoDT;
			private String ViTri;
			/**
			 * 
			 */
			public PhongBan() {
				super();
			}
			public String getMaPB() {
				return MaPB;
			}
			public void setMaPB(String maPB) {
				MaPB = maPB;
			}
			public String getTenPB() {
				return TenPB;
			}
			public void setTenPB(String tenPB) {
				TenPB = tenPB;
			}
			public String getSoDT() {
				return SoDT;
			}
			public void setSoDT(String soDT) {
				SoDT = soDT;
			}
			public String getViTri() {
				return ViTri;
			}
			public void setViTri(String viTri) {
				ViTri = viTri;
			}
			/**
			 * @param maPB
			 * @param tenPB
			 * @param soDT
			 * @param viTri
			 */
			public PhongBan(String maPB, String tenPB, String soDT, String viTri) {
				super();
				MaPB = maPB;
				TenPB = tenPB;
				SoDT = soDT;
				ViTri = viTri;
			}

			
}
