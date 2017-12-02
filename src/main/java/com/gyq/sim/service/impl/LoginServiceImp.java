package com.gyq.sim.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyq.sim.dao.LoginDao;
import com.gyq.sim.entity.common.BaseUser;
import com.gyq.sim.service.LoginService;

/**
 * �û���¼
 * 
 * @author qiqiangvae
 *
 */
@Service
public class LoginServiceImp implements LoginService {

	@Autowired
	private LoginDao loginDao;

	/**
	 * �û���¼
	 */
	public BaseUser doLogin(BaseUser user) {
		List<BaseUser> list = new ArrayList<>();
		BaseUser resultUser = null;
		// ����ǹ���Ա��¼����ӹ���Ա����ȡ���û�
		list = loginDao.doLoginForUser(user);
		if (list.size()>0) {
			resultUser=list.get(0);
		}
		return resultUser;
	}

}
