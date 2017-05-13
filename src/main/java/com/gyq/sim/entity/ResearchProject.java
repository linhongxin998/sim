package com.gyq.sim.entity;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class ResearchProject {
	private Integer id;//科研项目id
	private String name;//科研项目名称
	private String content;//科研项目内容
	private String intro;//科研项目简介
	private String rCode;//科研项目编号
	private Integer tid;//科研项目所属的教师id
	private Date createTime;//发布时间
	private Date updateTime;//更新时间
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
