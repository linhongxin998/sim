package com.gyq.sim.entity;

import java.util.Date;

/**
 * ����
 * @author qiqiangvae
 *
 */
public class LeaveWord {
	private Integer id; //����id
	private Integer forResearchId;//���������Ŀ�����Ŀid
	private String forResearchName;//���������Ŀ�����Ŀ����
	private Integer byUserId;//���Ե��û�id
	private String userIdentity;//�����û������
	private String byUserName;//���Ե��û���
	private Integer parentId;//��������Ӧ�ĸ�id(��¥)
	private Date createTime;//��������
	private String content;//��������
	
	
	public Integer getId() {
		return id;
	}
	public String getForResearchName() {
		return forResearchName;
	}
	public void setForResearchName(String forResearchName) {
		this.forResearchName = forResearchName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserIdentity() {
		return userIdentity;
	}
	public void setUserIdentity(String userIdentity) {
		this.userIdentity = userIdentity;
	}
	public void setForResearchId(Integer forResearchId) {
		this.forResearchId = forResearchId;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getForResearchId() {
		return forResearchId;
	}
	public Integer getByUserId() {
		return byUserId;
	}
	public void setByUserId(Integer byUserId) {
		this.byUserId = byUserId;
	}
	public String getByUserName() {
		return byUserName;
	}
	public void setByUserName(String byUserName) {
		this.byUserName = byUserName;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

}
