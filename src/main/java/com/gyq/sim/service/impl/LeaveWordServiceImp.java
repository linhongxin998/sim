package com.gyq.sim.service.impl;

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
	 * ��ȡĳ��Ŀ��������Ϣ
	 */
	@Override
	public List<LeaveWord> getLeaveWord(LeaveWord leaveWord) {
		List<LeaveWord> list=new ArrayList<LeaveWord>();
		list=leaveWordDao.getLeaveWord(leaveWord);	
		return list;
	}

	/**
	 * ���� ¥��
	 */
	@Override
	public void saveLeaveWord(LeaveWord leaveWord) {
		leaveWordDao.saveLeaveWord(leaveWord);
	}

	/**
	 * ɾ������
	 */
	@Override
	public void deleteLeaveWord(LeaveWord leaveWord) {
		leaveWordDao.deleteLeaveWord(leaveWord);
	}

}
