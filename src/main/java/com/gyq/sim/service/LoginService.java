package com.gyq.sim.service;

import com.gyq.sim.entity.BaseUser;

public interface LoginService {
	/**
	 * �û���¼
	 * @param password 
	 * @param username 
	 */
	BaseUser doLogin(BaseUser user);
	
}
