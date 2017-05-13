package com.gyq.sim.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gyq.sim.entity.BaseUser;
import com.gyq.sim.entity.SimAdmin;
import com.gyq.sim.entity.SimStudent;
import com.gyq.sim.entity.SimTeacher;

/**
 * ÓÃ»§µÇÂ¼dao²ã
 * @author qiqiangvae
 *
 */
public interface LoginDao {
	List<BaseUser> doLoginForUser(BaseUser user);
}
