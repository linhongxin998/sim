package com.gyq.sim.entity;

import org.springframework.web.multipart.MultipartFile;

/**
 * ������Ŀ����
 * @author qiqiangvae
 *
 */
public class SimFiled {
	//����id
	private String id;
	//��������
	private String fileName;
	//������ַ
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
