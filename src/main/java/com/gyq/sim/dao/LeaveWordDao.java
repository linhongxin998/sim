package com.gyq.sim.dao;

import java.util.List;

import com.gyq.sim.entity.LeaveWord;

public interface LeaveWordDao {

	List<LeaveWord> getLeaveWord(LeaveWord leaveWord);

	void saveLeaveWord(LeaveWord leaveWord);

	void deleteLeaveWord(LeaveWord leaveWord);

}
