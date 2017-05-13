package com.gyq.sim.entity;

/**
 * 用户基类
 * @author qiqiangvae
 *
 */
public class BaseUser {
	/**
	 * 用户id
	 */
    private Integer id;    
    /**
     * 用户姓名
     */
    private String username;    
    
    /**
     * 用户登录密码
     */
    private String password;
    
    /**
     * 用户身份
     */
    private String identity;
    
    public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public Integer getId() {    
        return id;    
    }    
    
    public void setId(Integer id) {    
        this.id = id;    
    }     
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {    
        return password;    
    }    

	public void setAge(int parseInt) {
		
	}    
}    