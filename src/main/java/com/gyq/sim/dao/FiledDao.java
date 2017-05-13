package com.gyq.sim.dao;

import com.gyq.sim.entity.SimFiled;

public interface FiledDao {

	void saveFile(SimFiled filed);

	SimFiled downFileByRCode(String rCode);

	void deletePhotoByRcode(String getrCode);

}
