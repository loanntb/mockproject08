package model.bo;

import java.util.ArrayList;

import model.bean.HocVan;
import model.dao.HocVanDAO;

public class HocVanBO {
	HocVanDAO hocVanDAO = new HocVanDAO();

	public ArrayList<HocVan> getListHV() {
		return hocVanDAO.getListHV();
	}

	public String themHVId() {
		ArrayList<HocVan> list = new ArrayList<>();
		list = hocVanDAO.getListHV();
		int index = list.size() - 1;
		String maHV = list.get(index).getMaHV();
		int temp = Integer.parseInt(maHV.substring(2));
		temp += 1;
		String temp2 = String.valueOf(temp);
		if (temp2.length() == 1) {
			maHV = "HV00" + temp2;
		} else if (temp2.length() == 2) {
			maHV = "HV0" + temp2;
		} else if (temp2.length() == 3) {
			maHV = "HV" + temp2;
		}
		return maHV;
	}

	public boolean ThemHocVan(String maHV, String tenHV, String maNV) {
		HocVan hv = new HocVan(maHV, tenHV, maNV);
		if (hocVanDAO.Chen(hv) == true)
			return true;

		return false;
	}

	/**
	 * @param maHV
	 * @return
	 */
	public boolean XoaCV(String maHV) {
		if (hocVanDAO.deleteHV(maHV) == 1)
			return true;
		return false;
	}

	/**
	 * @param maCV
	 * @return
	 */
	public HocVan getHocVanById(String maHV) {

		return hocVanDAO.getHocVanById(maHV);
	}

	/**
	 * @param maNV
	 * @return
	 */
	public HocVan getHocVanByMaNV(String maNV) {

		return hocVanDAO.getHocVanByMaNV(maNV);
	}

	/**
	 * @param maHV
	 * @param tenHV
	 * @param maNV
	 * @return
	 */
	public boolean CapNhatCV(String maHV, String tenHV, String maNV) {
		HocVan hocVan = new HocVan(maHV, tenHV, maNV);
		if (hocVanDAO.updateHV(hocVan) == 1)
			return true;
		return false;
	}

}
