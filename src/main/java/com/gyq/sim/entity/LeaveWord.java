package com.gyq.sim.entity;

import java.util.Date;

/**
 * 留言
 * @author qiqiangvae
 *
 */
public class LeaveWord {
	private Integer id; //留言id
	private Integer forResearchId;//留言所属的科研项目id
	private String forResearchName;//留言所属的科研项目名称
	private Integer byUserId;//留言的用户id
	private String userIdentity;//留言用户的身份
	private String byUserName;//留言的用户名
	private Integer parentId;//留言所对应的父id(跟楼)
	private Date createTime;//留言日期
	private String content;//留言内容
	
	
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
