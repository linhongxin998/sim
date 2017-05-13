package com.gyq.sim.entity;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class ResearchProject {
	private Integer id;//������Ŀid
	private String name;//������Ŀ����
	private String content;//������Ŀ����
	private String intro;//������Ŀ���
	private String rCode;//������Ŀ���
	private Integer tid;//������Ŀ�����Ľ�ʦid
	private Date createTime;//����ʱ��
	private Date updateTime;//����ʱ��
	private MultipartFile file;
	
	public Integer getId() {
		return id;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getrCode() {
		return rCode;
	}
	public void setrCode(String rCode) {
		this.rCode = rCode;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	

}
