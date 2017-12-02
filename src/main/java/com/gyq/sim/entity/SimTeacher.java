package com.gyq.sim.entity;

import com.gyq.sim.entity.common.BaseUser;

/**
 * ��ʦ�û���
 * @author qiqiangvae
 *
 */
public class SimTeacher extends BaseUser {
	
	private String tCode;//��ʦ���
	
	private String qq;//qq��
	
	private String qqUrl;//qq����
	
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
