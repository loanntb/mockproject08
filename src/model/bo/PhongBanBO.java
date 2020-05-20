/**
 * 
 */
package model.bo;

import java.util.ArrayList;

import model.bean.PhongBan;
import model.dao.PhongBanDao;

/**
 * @author HP db e dau
 * ở me thod này e muon lam gi
 *
 */
public class PhongBanBO {
	PhongBanDao phongBanDao = new PhongBanDao();

	/**
	 * MoTa
	 * @return
	 */ 
	public ArrayList<PhongBan> getListPB() {
		// TODO Auto-generated method stub
		return phongBanDao.getListPB();
	}

	/**
	 * MoTa
	 * @param maPB
	 * @param tenPB
	 * @param soDT
	 * @param viTri
	 * @return
	 */ 
	public boolean ThemHoatDong(String maPB, String tenPB, String soDT, String viTri) {
	
		PhongBan PB = new PhongBan(maPB, tenPB, soDT, viTri);
		
			if(phongBanDao.Chen(PB) == true)
			return true;
	
		return false;
	}

	/**
	 * MoTa
	 * @param maPB
	 * @param tenPB
	 * @param soDT
	 * @param viTri
	 * @return
	 */ 
	public boolean CapNhatPB(String maPB, String tenPB, String soDT, String viTri) {
		PhongBan phongBan = new PhongBan(maPB, tenPB, soDT, viTri);
		if(phongBanDao.updatePB(phongBan)==1)
			return true;
		return false;
	}

	/**
	 * MoTa
	 * @param maPB
	 * @return
	 */ 
	public PhongBan getPhongBanById(String maPB) {

		return phongBanDao.getPhongBanById(maPB);
	}

	/**
	 * MoTa
	 * @param maPB
	 * @return
	 */ 
	public boolean XoaPB(String maPB) {
		if (phongBanDao.deletePB(maPB) == 1)
			return true;
		return false;
	}

	/**
	 * MoTa
	 * @return
	 */ 
	public String createComputerId() {
        ArrayList<PhongBan> list = new ArrayList<>();
        list = phongBanDao.getListPB();
        int index = list.size() - 1;
        String maPB = list.get(index).getMaPB();
        int temp = Integer.parseInt(maPB.substring(2));
        temp += 1;
        String temp2 = String.valueOf(temp);
        if (temp2.length() == 1) {
            maPB = "PB00" + temp2;
        } else if (temp2.length() == 2) {
            maPB = "PB0" + temp2;
        } else if (temp2.length() == 3) {
            maPB = "PB" + temp2;
        }
        return maPB;}

	
}
