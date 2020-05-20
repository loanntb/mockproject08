package model.bo;

import java.util.ArrayList;

import model.bean.ChucVu;
import model.dao.ChucVuDAO;

public class ChucVuBO {
	ChucVuDAO chucVuDao = new ChucVuDAO();

	public ArrayList<ChucVu> getListCV() {
		return chucVuDao.getListCV();
	}

	public String themCVId() {
		ArrayList<ChucVu> list = new ArrayList<>();
		list = chucVuDao.getListCV();
		int index = list.size() - 1;
		String maCV = list.get(index).getMaCV();
		int temp = Integer.parseInt(maCV.substring(2));
		temp += 1;
		String temp2 = String.valueOf(temp);
		if (temp2.length() == 1) {
			maCV = "CV00" + temp2;
		} else if (temp2.length() == 2) {
			maCV = "CV0" + temp2;
		} else if (temp2.length() == 3) {
			maCV = "CV" + temp2;
		}
		return maCV;
	}

	public boolean ThemChucVu(String maCV, String tenCV) {
		ChucVu CV = new ChucVu(maCV, tenCV);
		if (chucVuDao.Chen(CV) == true)
			return true;

		return false;
	}

	/**
	 * @param maCV
	 * @return
	 */
	public boolean XoaCV(String maCV) {
		if (chucVuDao.deleteCV(maCV) == 1)
			return true;
		return false;
	}

	/**
	 * @param maCV
	 * @return
	 */
	public ChucVu getChucVuById(String maCV) {

		return chucVuDao.getChucVuById(maCV);
	}

	/**
	 * @param maCV
	 * @param tenCV
	 * @return
	 */
	public boolean CapNhatCV(String maCV, String tenCV) {
		ChucVu ChucVu = new ChucVu(maCV, tenCV);
		if (chucVuDao.updateCV(ChucVu) == 1)
			return true;
		return false;
	}

}
