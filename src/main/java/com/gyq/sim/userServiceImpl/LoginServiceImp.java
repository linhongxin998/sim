package com.gyq.sim.userServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyq.sim.dao.LoginDao;
import com.gyq.sim.entity.BaseUser;
import com.gyq.sim.entity.SimAdmin;
import com.gyq.sim.entity.SimTeacher;
import com.gyq.sim.service.LoginService;

/**
 * 用户登录
 * 
 * @author qiqiangvae
 *
 */
@Service
public class LoginServiceImp implements LoginService {

	@Autowired
	private LoginDao loginDao;

	/**
	 * 用户登录
	 */
	public BaseUser doLogin(BaseUser user) {
		List<BaseUser> list = new ArrayList<>();
		BaseUser resultUser = null;
		// 如果是管理员登录，则从管理员变中取出用户
		list = loginDao.doLoginForUser(user);
		if (list.size()>0) {
			resultUser=list.get(0);
		}
		return resultUser;
	}

}
