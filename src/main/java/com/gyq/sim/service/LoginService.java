package com.gyq.sim.service;

import com.gyq.sim.entity.BaseUser;

public interface LoginService {
	/**
	 * ÓÃ»§µÇÂ¼
	 * @param password 
	 * @param username 
	 */
	BaseUser doLogin(BaseUser user);
	
}
