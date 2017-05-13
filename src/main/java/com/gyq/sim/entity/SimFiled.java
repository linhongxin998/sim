package com.gyq.sim.entity;

import org.springframework.web.multipart.MultipartFile;

/**
 * 科研项目附件
 * @author qiqiangvae
 *
 */
public class SimFiled {
	//附件id
	private String id;
	//附件名字
	private String fileName;
	//附件地址
	private String fileUrl;
	
	private byte[] fileData;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	
	
}
