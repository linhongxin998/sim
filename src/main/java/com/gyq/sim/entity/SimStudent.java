package com.gyq.sim.entity;

import com.gyq.sim.entity.common.BaseUser;

/**
 * ѧ���û���
 * @author qiqiangvae
 *
 */
public class SimStudent extends BaseUser {
	private String sCode;//ѧ��ѧ��

	public String getsCode() {
		return sCode;
	}

	public void setsCode(String sCode) {
		this.sCode = sCode;
	}
}
