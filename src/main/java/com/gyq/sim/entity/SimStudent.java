package com.gyq.sim.entity;

/**
 * 学生用户类
 * @author qiqiangvae
 *
 */
public class SimStudent extends BaseUser {
	private String sCode;//学生学号

	public String getsCode() {
		return sCode;
	}

	public void setsCode(String sCode) {
		this.sCode = sCode;
	}
}
