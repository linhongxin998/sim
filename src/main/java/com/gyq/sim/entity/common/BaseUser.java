package com.gyq.sim.entity.common;

/**
 * �û�����
 * @author qiqiangvae
 *
 */
public class BaseUser extends BaseEntity{
	/**
	 * �û�id
	 */
    private Integer id; 
    /**
     * �û�����
     */
    private String username;    
    
    /**
     * �û���¼����
     */
    private String password;
    
    /**
     * �û����
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