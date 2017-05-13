package com.gyq.sim.entity;
/**
 * 教师用户类
 * @author qiqiangvae
 *
 */
public class SimTeacher extends BaseUser {
	
	private String tCode;//教师编号
	
	private String qq;//qq号
	
	private String qqUrl;//qq链接
	
	private String qqSrc;

	public String gettCode() {
		return tCode;
	}

	public void settCode(String tCode) {
		this.tCode = tCode;
	}

	public String getQqUrl() {
		return qqUrl;
	}

	public void setQqUrl(String qqUrl) {
		this.qqUrl = qqUrl;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getQqSrc() {
		return qqSrc;
	}

	public void setQqSrc(String qqSrc) {
		this.qqSrc = qqSrc;
	}
	
	
}
