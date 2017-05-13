package com.gyq.sim.userServiceImpl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyq.sim.dao.LeaveWordDao;
import com.gyq.sim.entity.LeaveWord;
import com.gyq.sim.service.LeaveWordService;

@Service
public class LeaveWordServiceImp implements LeaveWordService{

	@Autowired
	private LeaveWordDao leaveWordDao;
	
	/**
	 * 获取某项目的留言信息
	 */
	@Override
	public List<LeaveWord> getLeaveWord(LeaveWord leaveWord) {
		List<LeaveWord> list=new ArrayList<LeaveWord>();
		list=leaveWordDao.getLeaveWord(leaveWord);	
		return list;
	}

	/**
	 * 评论 楼层
	 */
	@Override
	public void saveLeaveWord(LeaveWord leaveWord) {
		leaveWordDao.saveLeaveWord(leaveWord);
	}

	/**
	 * 删除评论
	 */
	@Override
	public void deleteLeaveWord(LeaveWord leaveWord) {
		leaveWordDao.deleteLeaveWord(leaveWord);
	}

}
