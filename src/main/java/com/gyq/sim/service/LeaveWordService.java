package com.gyq.sim.service;

import java.util.List;

import com.gyq.sim.entity.LeaveWord;

public interface LeaveWordService {

	List<LeaveWord> getLeaveWord(LeaveWord leaveWord);

	void saveLeaveWord(LeaveWord leaveWord);

	void deleteLeaveWord(LeaveWord leaveWord);

}
