package com.gyq.sim.dao;

import java.util.List;

import com.gyq.sim.entity.common.BaseUser;

/**
 * �û���¼dao��
 * @author qiqiangvae
 *
 */
public interface LoginDao {
	List<BaseUser> doLoginForUser(BaseUser user);
}
